package System;

import API.WebManager;
import DataModel.LocationData.*;
import DataModel.TransportationData.StopData.Line;
import DataModel.TransportationData.RouteData.Route;
import DataModel.TransportationData.StationData.Station;
import DataModel.TransportationData.StopData.Stop;
import DataModel.User.User;
import JsonParsing.ParsingExceptions.LineExceptions.LineException;
import JsonParsing.ParsingExceptions.RouteExceptions.RouteOutOfReach;
import JsonParsing.ParsingExceptions.RouteExceptions.RouteWrongParameter;
import JsonParsing.Transportation.JsonLineReader;
import JsonParsing.Transportation.JsonRouteReader;
import JsonParsing.Transportation.JsonStationReader;
import JsonParsing.Transportation.JsonStopsReader;
import Managers.Location.LocationManager;
import Managers.UserManager.UserManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * Class: java.Managers.UserManager.UserManager
 *
 * <br/>Connects all the different classes and manages the main menu and its
 * functionalities
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 30/12/2019
 *
 * @see Location
 * @see LocationManager
 * @see Route
 * @see Station
 * @see Stop
 * @see User
 * @see UserManager
 * @see JsonLineReader
 * @see JsonStationReader
 * @see JsonStopsReader
 * @see JsonParsing.Location.JsonLocationReader
 * @see WebManager
 */
public class MainSystem {

    /**
     * this method runs the main functionalities of the system by connecting the methods from all the classes together
     * in order to come up with final result
     * */
    public static void mainSystem(){
        // initializing variables
        UserManager users = new UserManager();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean check = false ;
        int firstOption = 6;
        String secondOption;
        String input;
        WebManager webManager = new WebManager();


        // Registering a new user:
        UI.printWelcomeMessage();
        System.out.println("Username:");
        users.setName(scanner.nextLine());
        System.out.println(System.lineSeparator() + "E-mail:");
        users.setEmail(scanner.nextLine());
        do{
            scanner = new Scanner(System.in);
            flag = false;
            System.out.println(System.lineSeparator() + "Birth Year:");
            try {
                users.setYear(scanner.nextInt());
            }catch (InputMismatchException e){
                System.out.println("you can only enter numbers here!");
                flag = true;
            }
        }while(flag);
        UI.printInfoValidMessage();

        do {
            // displaying the menu :
            UI.printMainMenu();
            do{
                flag = false;
                scanner = new Scanner(System.in);
                try {
                    firstOption = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("you can only enter numbers here!");
                    flag = true;
                    System.out.println(System.lineSeparator() + "Select an option: ");

                }
            }while (flag);

            switch (firstOption) {
                case 1:
                    do {
                        UI.printOption1Menu();
                        scanner = new Scanner(System.in);
                        secondOption = scanner.nextLine().trim();
                        switch (secondOption.toLowerCase()) {
                            case "a":
                                do {
                                    UI.printMyLocationOption(users.getMyLocation());
                                    System.out.println("Want to create a new location? (yes/no)");
                                    input = scanner.nextLine().trim();
                                    if (input.compareToIgnoreCase("yes") == 0) {
                                        flag = true;
                                        Location location = new Location();
                                        do {
                                            System.out.println("Location Name: ");
                                            location.setName(scanner.nextLine().trim());
                                            check = LocationManager.checkLocationNameExists(location.getName());
                                            if (check)
                                                UI.printErrorLocationNameExists();
                                        } while (check);

                                        do {
                                            System.out.println("Length: ");
                                            location.setLongitude(scanner.nextFloat());
                                            System.out.println(System.lineSeparator() + "Latitude: ");
                                            location.setLatitude(scanner.nextFloat());
                                            check = LocationManager.checkCoordinates(location.getLatitude(), location.getLongitude());
                                            if (!check)
                                                UI.printErrorCoordinates();
                                        } while (!check);
                                        scanner = new Scanner(System.in);
                                        System.out.println("Description: ");
                                        location.setDescription(scanner.nextLine());
                                        users.createNewMyLocation(location);
                                        UI.printInfoValidMessage();
                                    } else if (input.compareToIgnoreCase("no") == 0) {
                                        flag = false;
                                    } else {
                                        flag = false;
                                        UI.printInputErrorYN();
                                    }
                                } while (flag);

                                break;
                            case "b":
                                UI.printLocationHistory(users.getLocationHistory());
                                break;
                            case "c":
                                UI.printMyRoutes(users.getMyRoutes());
                                break;
                            case "d":
                                if (users.getFavLocations() != null && users.getFavLocations().size() > 0) {
                                    // for each favorite location find all
                                    // the stations and stops within the
                                    // distance limit and print them
                                    for (FavLocation favLoc : users.getFavLocations()) {
                                        String JsonString;
                                        // make the call to the API
                                        JsonString = webManager.callAllStations();
                                        ArrayList<Station> stations = null;
                                        if (JsonString != null)
                                            stations = JsonStationReader.readFavStations(JsonString, favLoc);
                                        JsonString = webManager.callAllStops();
                                        ArrayList<Stop> stops = null;
                                        if (JsonString != null) {
                                            stops = JsonStopsReader.readFavStops(JsonString, favLoc);
                                        }
                                        boolean print = users.addFavStationsAndStops(favLoc, stations, stops);
                                        UI.printFavStopsAndStations(users.getUser(), favLoc, print);
                                    }
                                }
                                else{
                                    UI.printFavStationAndStopsError();
                                }
                                break;
                            case "e":
                                String JsonString;
                                JsonString = webManager.callAllStations();
                                ArrayList<Station> stations = null;
                                if (JsonString != null)
                                    stations = JsonStationReader.readInauguratedStations(JsonString, users.getYear());
                                if (stations != null && stations.size() > 0) {
                                    UI.printStationsInaugurated(stations, users.getYear());
                                }
                                else{
                                    UI.printErrorNoStationsThisYear();
                                }
                                break;
                            case "f":
                                break;
                            default:
                                UI.printErrorMenu();
                                break;
                        }
                    } while (secondOption.compareToIgnoreCase("f") != 0);
                    break;
                case 2:
                    System.out.println("Enter the name of a location: ");
                    scanner = new Scanner(System.in);
                    Location location =
                            LocationManager.searchLocations(scanner.nextLine().trim());
                    UI.printSearchedLocation(location);
                    if (location != null){
                        users.addLocationHistory(location);
                        System.out.println(System.lineSeparator() + "Do you want to save the found location as your favorite? (yes/no)");
                        String favLocOption;
                        do {
                            favLocOption = scanner.nextLine().trim();
                            if (favLocOption.equalsIgnoreCase("yes") || favLocOption.equalsIgnoreCase("no")) {
                                if (favLocOption.equalsIgnoreCase("yes")) {
                                    String type;
                                    boolean goIn = true;
                                    boolean exist = false;
                                    for (FavLocation fav : users.getFavLocations()) {
                                        if (fav.containLocation(location)) {
                                            exist = true;
                                            break;
                                        }
                                    }
                                    if (exist) {
                                        goIn = false;
                                        String option ;
                                        System.out.println("this location is already A favorite location ... would you ike to change the type of your favorite location? (yes/no)");
                                        scanner = new Scanner(System.in);
                                        option = scanner.nextLine().trim();
                                        do{
                                            if (option.equalsIgnoreCase("yes")){
                                                goIn = true;
                                                users.deleteFavLocation(location);
                                                break;
                                            }
                                            else if(!(option.equalsIgnoreCase("yes") || option.equalsIgnoreCase("no"))){
                                                UI.printInputErrorYN();
                                            }

                                        } while (!(option.equalsIgnoreCase("yes") || option.equalsIgnoreCase("no")));
                                    }
                                    if(goIn){
                                        do {
                                            System.out.println("Type (home / work / studies / leisure / culture):");
                                            type = scanner.nextLine().trim();
                                            flag = type.equalsIgnoreCase("home") || type.equalsIgnoreCase("work") || type.equalsIgnoreCase("studies") || type.equalsIgnoreCase("leisure") || type.equalsIgnoreCase("culture");
                                            if (!flag) {
                                                UI.printFavLocationTypeError();
                                            } else {
                                                users.addFavLocation(location, type);
                                                System.out.println(location.getName() + " has been assigned as a new favorite location.");
                                            }
                                        } while (!flag);
                                    }
                                }
                            } else
                                UI.printInputErrorYN();
                        } while (!(favLocOption.equalsIgnoreCase("yes") || favLocOption.equalsIgnoreCase("no")));
                    }
                    break;
                case 3:
                    do {
                        flag = false;
                        Location originLocation = new Location();
                        Location destLocation = new Location();
                        Route route = new Route();
                        scanner = new Scanner(System.in);
                        flag = true;

                        do {
                            System.out.println("Origin? (lat,lon/name location)");
                            String origin = scanner.nextLine().trim();

                            try{
                                String[] coords = null;
                                coords = origin.split(",");
                                flag = !(LocationManager.checkCoordinates(Float.parseFloat(coords[0]), Float.parseFloat(coords[1])));
                            } catch (NumberFormatException e){
                                route.setOriginName(origin);
                                originLocation = LocationManager.searchLocations(origin);
                                if (originLocation != null) {
                                    origin = LocationManager.lanLogToString(originLocation);
                                    flag = false;
                                } else {
                                    UI.printRouteLocationError();
                                }
                            }
                            route.setOrigin(origin);

                        } while (flag);

                        flag = true;
                        do {
                            System.out.println("Destination? (lat,lon/name location)");
                            String destination = scanner.nextLine().trim();

                            try {
                                String[] coords = null;
                                coords = destination.split(",");
                                flag = !(LocationManager.checkCoordinates(Float.parseFloat(coords[0]), Float.parseFloat(coords[1])));
                            }catch(NumberFormatException e){
                                route.setDestinationName(destination);
                                destLocation = LocationManager.searchLocations(destination);
                                if (destLocation != null) {
                                    destination = LocationManager.lanLogToString(destLocation);
                                    flag = false;
                                } else {
                                    UI.printRouteLocationError();
                                }
                            }
                            route.setDestination(destination);

                        } while (flag);


                        flag = true;

                        do {
                            System.out.println("Departure or arrival? (d/a)");
                            String destOrArrivalOption = scanner.nextLine().trim();

                            if (destOrArrivalOption.equalsIgnoreCase("d") || destOrArrivalOption.equalsIgnoreCase("a")) {
                                route.setDepartureOrArrival(destOrArrivalOption.charAt(0));
                                flag = false;
                            } else {
                                UI.printRouteDestArrivalError();
                            }

                        } while (flag);

                        System.out.println("Day? (MM-DD-YYYY)");
                        route.setDay(scanner.nextLine());

                        System.out.println("Hour? (HH:MMam/HH:MMpm)");
                        route.setHour(scanner.nextLine());

                        System.out.println("Maximum walking distance in meters?");
                        do {
                            flag = false;
                            scanner = new Scanner(System.in);
                            try {
                                route.setMaxWalkingDistance(scanner.nextFloat());
                            }catch (InputMismatchException e){
                                System.out.println("you can only enter numbers here!");
                                flag = true;
                            }
                        }while (flag);
                        String JsonString;
                        JsonString = webManager.callRoute(route);
                        if (JsonString != null) {
                            try {
                                route.setItineraries(JsonRouteReader.readRoute(JsonString).getItineraries());
                                UI.printRoute(route);
                                users.addRoute(route);
                            } catch (RouteOutOfReach routeOutOfReach) {
                                System.out.println(routeOutOfReach.getMessage());
                                flag = false;
                            } catch (RouteWrongParameter routeWrongParameter){
                                System.out.println(routeWrongParameter.getMessage());
                                flag = true;
                            }

                        }
                    }while (flag);
                    break;
                case 4:
                    String stopId;
                    ArrayList<Line> lines = null;
                    do {
                        flag = false;
                        scanner = new Scanner(System.in);
                        System.out.println("Enter the stop code:");
                        stopId = scanner.nextLine().trim();
                        String JsonString = webManager.callLine(stopId);
                        if (JsonString != null) {
                            try {
                                lines = JsonLineReader.readStopLine(JsonString, stopId);
                            } catch (LineException e) {
                                System.out.println(e.getMessage());
                                flag = true;
                            }
                        }
                    }while(flag);
                    if (users.getFavLocations() != null && users.getFavLocations().size() > 0) {
                        for (FavLocation favLoc : users.getFavLocations()) {
                            String JsonString;
                            JsonString = webManager.callAllStations();
                            ArrayList<Station> stations = null;
                            if (JsonString != null)
                                stations = JsonStationReader.readFavStations(JsonString, favLoc);
                            JsonString = webManager.callAllStops();
                            ArrayList<Stop> stops = null;
                            if (JsonString != null) {
                                stops = JsonStopsReader.readFavStops(JsonString, favLoc);
                            }
                            users.addFavStationsAndStops(favLoc, stations, stops);
                        }
                    }
                    UI.printWaitTime(stopId, lines, users.getUser());
                    break;
                case 5:
                    break;
                default:
                    UI.printErrorMenu();
                    break;
            }

        }while(firstOption != 5);

    }
}
