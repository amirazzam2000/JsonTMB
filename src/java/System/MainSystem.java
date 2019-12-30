package System;

import API.WebManager;
import DataModel.LocationData.Location;
import DataModel.TransportationData.Route;
import DataModel.TransportationData.Station;
import JsonParsing.Transportation.JsonRouteReader;
import Managers.Location.LocationManager;
import Managers.UserManager.UserManager;

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
            switch (firstOption){
                case 1 :
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
                                    if(input.compareToIgnoreCase("yes") == 0){
                                        Location location = new Location();
                                        do {
                                            System.out.println("Location Name: ");
                                            location.setName(scanner.nextLine());
                                            check = LocationManager.checkLocationNameExists(location.getName());
                                            if(check)
                                                UI.printLocationExistsError();
                                        }while(check);

                                        do {
                                            System.out.println("Length: ");
                                            location.setLongitude(scanner.nextFloat());
                                            System.out.println(System.lineSeparator() + "Latitude: ");
                                            location.setLatitude(scanner.nextFloat());
                                            check = LocationManager.checkCoordinates(location.getLatitude(), location.getLongitude());
                                            if(!check)
                                                UI.printErrorCoordinates();
                                        }while(!check);
                                        scanner = new Scanner(System.in);
                                        System.out.println("Description: ");
                                        location.setDescription(scanner.nextLine());
                                        users.createNewMyLocation(location);
                                        UI.printInfoValidMessage();
                                    }
                                    else if(input.compareToIgnoreCase("no")==0){
                                        flag = false;
                                    }
                                    else {
                                        UI.printInputErrorYN();
                                    }
                                }while(flag);
                                flag = true; // reinitializing the flag to false so we can re use it in the future
                                break;
                            case "b":
                                UI.printLocationHistory(users.getLocationHistory());
                                break;
                            case "c":
                                UI.printMyRoutes(users.getMyRoutes());
                                break;
                            case "d":
                                break;
                            case "e":
                                System.out.println("Stations inaugurated in " + users.getYear() + ":");
                                break;
                            case "f":
                                break;
                            default:
                                UI.printErrorMenu();
                                break;
                        }
                    }while(secondOption.compareToIgnoreCase("f") != 0);
                    break;
                case 2:
                    System.out.println("Enter the name of a location: ");
                    scanner = new Scanner(System.in);
                    Location location = LocationManager.searchLocations(scanner.nextLine());
                    UI.printSearchedLocation(location);
                    if (location != null)
                        users.addLocationHistory(location);
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
