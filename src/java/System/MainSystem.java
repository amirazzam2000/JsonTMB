package System;

import API.WebManager;
import DataModel.LocationData.*;
import DataModel.TransportationData.Route;
import DataModel.TransportationData.Station;
import JsonParsing.Transportation.JsonRouteReader;
import JsonParsing.Transportation.JsonStationReader;
import Managers.Location.LocationManager;
import Managers.UserManager.UserManager;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSystem {

    /**
     * this method runs the main functionalities of the system by connecting the methods from all the classes together
     * in order to come up with final result
     * */
    public static void mainSystem(){
        UserManager users = new UserManager();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        boolean check = false ;
        int firstOption;
        String secondOption;
        String input;
        // Registering a new user:
        UI.printWelcomeMessage();

        System.out.println("Username:");
        users.setName(scanner.nextLine());

        System.out.println(System.lineSeparator() + "E-mail:");
        users.setEmail(scanner.nextLine());

        System.out.println(System.lineSeparator() + "Birth Year:");
        users.setYear(scanner.nextInt());

        UI.printInfoValidMessage();

        do {
            // displaying the menu :
            UI.printMainMenu();
            firstOption = scanner.nextInt();
            switch (firstOption) {
                case 1:
                    do {
                        UI.printOption1Menu();
                        scanner = new Scanner(System.in);
                        secondOption = scanner.nextLine();
                        switch (secondOption.toLowerCase()) {
                            case "a":
                                do {
                                    UI.printMyLocationOption(users.getMyLocation());
                                    System.out.println("Want to create a new location? (yes/no)");
                                    input = scanner.nextLine();
                                    if (input.compareToIgnoreCase("yes") == 0) {
                                        Location location = new Location();
                                        do {
                                            System.out.println("Location Name: ");
                                            location.setName(scanner.nextLine());
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
                                        UI.printInputErrorYN();
                                    }
                                } while (flag);
                                flag = true; // reinitializing the flag to false so we can re use it in the future
                                break;
                            case "b":
                                UI.printLocationHistory(users.getLocationHistory());
                                break;
                            case "c":
                                UI.printMyRoutes(users.getMyRoutes());
                                break;
                            case "d":
                                if (users.getFavLocations() != null && users.getFavLocations().size() > 0) {
                                    for (FavLocation favLoc : users.getFavLocations()) {
                                        boolean print = users.getFavStationsAndStops(favLoc);
                                        UI.printFavStopsAndStations(users.getUser(), favLoc, print);
                                    }
                                }
                                else{
                                    UI.printFavStationAndStopsError();
                                }
                                break;
                            case "e":
                                String JsonString;
                                JsonString = WebManager.callAllStations();
                                ArrayList<Station> stations = null;
                                if (JsonString != null)
                                    stations = JsonStationReader.readInauguratedStations(JsonString, users.getYear());
                                if (stations != null && stations.size() > 0) {

                                    UI.printStationsInaguarated(stations, users.getYear());
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
                    Location location = LocationManager.searchLocations(scanner.nextLine());
                    UI.printSearchedLocation(location);
                    if (location != null){
                        users.addLocationHistory(location);
                        System.out.println(System.lineSeparator() + "Do you want to save the found location as your favorite? (yes/no)");
                        String favLocOption;
                        do {
                            favLocOption = scanner.nextLine();
                            if (favLocOption.equalsIgnoreCase("yes") || favLocOption.equalsIgnoreCase("no")) {
                                if (favLocOption.equalsIgnoreCase("yes")) {
                                    String type;
                                    do {
                                        System.out.println("Type (home / work / studies / leisure / culture):");
                                        type = scanner.nextLine();
                                        flag = type.equalsIgnoreCase("home") || type.equalsIgnoreCase("work") || type.equalsIgnoreCase("studies") || type.equalsIgnoreCase("leisure") || type.equalsIgnoreCase("culture");
                                        if (!flag) {
                                            UI.printFavLocationTypeError();
                                        } else {
                                            if (location != null) {
                                                users.addFavLocation(location, type);
                                                System.out.println(location.getName() + " has been assigned as a new favorite location.");
                                            }
                                        }
                                    } while (!flag);
                                }
                            } else
                                UI.printInputErrorYN();
                        } while (!(favLocOption.equalsIgnoreCase("yes") || favLocOption.equalsIgnoreCase("no")));
                    }
                    break;
                case 3:
                    Location originLocation = new Location();
                    Location destLocation = new Location();
                    Route route = new Route();
                    scanner = new Scanner(System.in);

                    flag = true;
                    do {
                        System.out.println("Origin? (lat,lon/name location)");
                        String origin = scanner.nextLine();
                        if (origin.charAt(0) >= '0' && origin.charAt(0) <= '9') {
                            String[] coords = null;
                            coords = origin.split(",");
                            flag = !(LocationManager.checkCoordinates(Float.parseFloat(coords[0]), Float.parseFloat(coords[1])));
                        } else {
                            originLocation = LocationManager.searchLocations(origin);
                            if (originLocation != null) {
                                origin = LocationManager.lanLogToString(originLocation);
                                flag = false;
                            } else {
                                UI.printRouteLocationError();
                            }
                        }

                        route.setOrigin(origin);

                    }while(flag);

                    flag = true;
                    do {
                        System.out.println("Destination? (lat,lon/name location)");
                        String destination = scanner.nextLine();


                        if (destination.charAt(0) >= '0' && destination.charAt(0) <= '9') {
                            String[] coords = null;
                            coords = destination.split(",");
                            flag = !(LocationManager.checkCoordinates(Float.parseFloat(coords[0]), Float.parseFloat(coords[1])));
                        } else {
                            destLocation = LocationManager.searchLocations(destination);
                            if (destLocation != null) {
                                destination = LocationManager.lanLogToString(destLocation);
                                flag = false;
                            } else {
                                UI.printRouteLocationError();
                            }
                        }

                        route.setDestination(destination);

                    }while(flag);



                    flag = true;

                    do{
                        System.out.println("Departure or arrival? (d/a)");
                        String destOrArrivalOption = scanner.nextLine();

                        if(destOrArrivalOption.equalsIgnoreCase("d") || destOrArrivalOption.equalsIgnoreCase("a")){
                            route.setDepartureOrArrival(destOrArrivalOption.charAt(0));
                            flag = false;
                        }
                        else{
                            UI.printRouteDestArrivalError();
                        }

                    }while(flag);

                    System.out.println("Day? (MM-DD-YYYY)");
                    route.setDay(scanner.nextLine());

                    System.out.println("Hour? (HH:MMam/HH:MMpm)");
                    route.setHour(scanner.nextLine());

                    System.out.println("Maximum walking distance in meters?");
                    route.setMaxWalkingDistance(scanner.nextFloat());

                    String JsonString;
                    JsonString = WebManager.callRoute(route);
                    if (JsonString != null)
                        route.setItineraries(JsonRouteReader.readRoute(JsonString).getItineraries());

                    UI.printRoute(route);
                    users.addRoute(route);

                    break;
                case 4:
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
