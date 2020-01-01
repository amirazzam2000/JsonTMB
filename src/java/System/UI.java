package System;

import DataModel.LocationData.*;
import DataModel.TransportationData.*;
import DataModel.User.User;

import javax.sound.midi.Soundbank;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {

    public static void printWelcomeMessage(){
        System.out.println("Welcome to the TMBJson application! Please enter the requested information.");

    }

    public static void printRouteLocationError(){
        System.out.println("Sorry, this location is not valid :(" + System.lineSeparator());

    }

    public static void printRouteDestArrivalError(){
        System.out.println("Error! You must enter \"d\" or \"a\"!.");

    }

    public static void printInfoValidMessage(){
        System.out.println("The information has been successfully registered!");
    }

    public static void printUserWelcomeMessage(String username){
        System.out.println("Welcome back to TMBJson " + username + "!");
    }

    public static void printMainMenu(){
        System.out.println();
        System.out.println("1. User Management");
        System.out.println("2. Search locations");
        System.out.println("3. Plan Route");
        System.out.println("4. Bus wait time");
        System.out.println("5. Exit");
        System.out.println();

        System.out.println("Select an option: ");
    }
    public static void printOption1Menu(){
        System.out.println();
        System.out.println("a) My Locations");
        System.out.println("b) Location History");
        System.out.println("c) My routes");
        System.out.println("d) Favourite stops and stations");
        System.out.println("e) Stations inaugurated my birth year");
        System.out.println("f) Back to the principal menu");
        System.out.println();
        System.out.println("Select an option: ");
    }

    public static void printErrorMenu(){
        System.out.println("'ERROR: Invalid option'"+ System.lineSeparator() + "Please choose an option from the menu"+ System.lineSeparator());
    }

    public static void printAPIParameterError(){
        System.out.println("Error, there is some wrong parameter :(" + System.lineSeparator());
    }


    public static void printInputErrorYN(){
        System.out.println("Error! You must enter \"yes\" or \"no\"." + System.lineSeparator());
    }

    public static void printErrorCoordinates(){
        System.out.println("Error! These coordinates are not valid." + System.lineSeparator());
    }

    public static void printErrorLocationNameExists(){
        System.out.println("Error! This location name already exists." + System.lineSeparator());
    }

    public static void printErrorNoStationsThisYear(){
        System.out.println("No subway station opened your birth year :(" + System.lineSeparator());
    }


    public static void printFavLocationTypeError(){
        System.out.println("Error! You have to enter \"home\", \"work\", \"studies\", \"leisure\" or \"culture\"." + System.lineSeparator());
    }


    public static void printMyLocationOption(ArrayList<Location> locations){
        String createOption;
        if(locations.size() != 0){
            for(Location location: locations){
                System.out.println("Location Name: " + location.getName());
                System.out.println("- Length: " + location.getLongitude());
                System.out.println("- Latitude: " + location.getLatitude());
                System.out.println("- Description: " + location.getDescription() + System.lineSeparator());
            }
        }
        else{
            System.out.println("You don't have any location created.");
        }
    }

    public static void printLocationHistory(ArrayList<Location> LocationHistory){
        if(LocationHistory != null && LocationHistory.size() > 0){
            System.out.println("Searched locations: ");
            for(int i = LocationHistory.size() - 1; i >= 0; i--){
                System.out.println("-" + LocationHistory.get(i).getName());
            }
        }
        else{
            System.out.println("You have not searched for any locations!" + System.lineSeparator() + "To search for one, access option 2 in the principal menu.");
        }

    }

    public static void printSearchedLocation(Location location){
        if(location == null){
            System.out.println("Sorry, there is no location with this name.");
        }
        else{
            System.out.println(System.lineSeparator() + "Position: " + location.getLatitude() + ", " + location.getLongitude());
            System.out.println("Description: " + System.lineSeparator() + location.getDescription());
            if (location instanceof Hotel){
                System.out.println("Stars: " + ((Hotel) location).getStars());
            }
            if (location instanceof Monument){
                System.out.println("Architect: " + ((Monument) location).getArchitect());
                System.out.println("Inauguration: " + ((Monument) location).getInauguration());
            }
            if (location instanceof Restaurant){
                System.out.println("Characteristics: ");

                for(int i = 0; i < ((Restaurant) location).getCharacteristics().length; i++){
                    System.out.println("- " + ((Restaurant) location).getCharacteristics()[i]);
                }
            }
        }
    }

    public static void printRoute(Route route){
        int i = route.getShortestRoute(route.getMaxWalkingDistance());

        System.out.println("Time taken: " +  Math.round(route.getItineraries().get(i).getDuration() / 60.0) + " min");

        if (route.getItineraries().get(i).getMaxWalkDistance() > route.getMaxWalkingDistance()){
            System.out.println("we couldn't find a route within the max walking distance you set. Sorry for the inconvenience!");
            System.out.println("this is a suggested route: (the suggested route is the fastest route)");
        }

        for (int j = 0; j < route.getItineraries().get(i).getJourneys().size(); j++) {
            if(route.getItineraries().get(i).getJourneys().get(j).getLineOrStreet() != null)
                System.out.print(route.getItineraries().get(i).getJourneys().get(j ).getLineOrStreet() + " ");
            if (j == 0)
                System.out.print(route.getItineraries().get(i).getJourneys().get(j).getOrigin());

            else if( route.getItineraries().get(i).getJourneys().get(j - 1).getMode().compareToIgnoreCase("walk") == 0 ) {
                System.out.print(route.getItineraries().get(i).getJourneys().get(j).getOrigin());
                if (route.getItineraries().get(i).getJourneys().get(j).getStopCode() != null)
                    System.out.print(" (" + route.getItineraries().get(i).getJourneys().get(j).getStopCode() + ") ");
            }
            if(route.getItineraries().get(i).getJourneys().get(j).getMode().compareToIgnoreCase("walk") == 0){
                System.out.println();
                System.out.println("|");
                System.out.println("Walk " + Math.round ( route.getItineraries().get(i).getJourneys().get(j).getTime() / 60.0) +" min");
                System.out.println("|");

            }
            else {
                if (j < (route.getItineraries().get(i).getJourneys().size() -1) && route.getItineraries().get(i).getJourneys().get(j).getStopCode() != null)
                     System.out.print(" -> " + route.getItineraries().get(i).getJourneys().get(j).getDestination() + " (" + route.getItineraries().get(i).getJourneys().get(j + 1).getStopCode() + ") " + Math.round( route.getItineraries().get(i).getJourneys().get(j).getTime()/60.0) +" min");
                else
                    System.out.print(" -> " + route.getItineraries().get(i).getJourneys().get(j).getDestination()+ " " + Math.round( route.getItineraries().get(i).getJourneys().get(j).getTime()/60.0) +" min");

            }


        }
        System.out.println(route.getItineraries().get(i).getJourneys().get(route.getItineraries().get(i).getJourneys().size() -1 ).getDestination());

    }


    public static void printMyRoutes(ArrayList<Route> myRoutes) {
        if (myRoutes != null && myRoutes.size() > 0){
            int i = 1;
            for (Route route: myRoutes) {

                System.out.println(System.lineSeparator() + "->Route " + i++ + ":");
                if (route.getOriginName() != null)
                    System.out.println("-Origin: " + route.getOriginName());
                else
                    System.out.println("-Origin: " + route.getOrigin());
                if (route.getDestinationName() != null)
                    System.out.println("-Destination: " + route.getDestinationName());
                else
                    System.out.println("-Destination: " + route.getDestination());
                if (route.getDepartureOrArrival() == 'd')
                    System.out.println("-Start day: " + route.getDay() + " at " + route.getHour());
                else
                    System.out.println("-Arriving by day: " + route.getDay() + " at " + route.getHour());
                System.out.println("-Max walking distance: " + route.getMaxWalkingDistance());
                System.out.println("-Fastest combination: " + System.lineSeparator());

                printRoute(route);
            }
        }
        else{
            System.out.println("You have not made any route :(" + System.lineSeparator() + "To search for one, access option 3 on the principal menu.");
        }
    }

    public static void printFavStopsAndStations(User user, FavLocation favLoc, boolean print) {
        int i = 0, j = 0;
        int counter = 0;
        System.out.println("- " + favLoc.getLocation().getName());

        if(print) {
            while (j < user.getStations().size() && i < user.getStops().size()) {
                if (user.getStops().get(i).getDistance() < user.getStations().get(j).getDistance()) {
                    if (favLoc.getLocation().getName().compareToIgnoreCase(user.getStops().get(i).getLocationName()) == 0) {
                        System.out.println("    " + (counter + 1) + ") " + user.getStops().get(i).getStopName() + " (" + user.getStops().get(i).getStopId() + ") BUS");
                        counter++;
                    }
                    i++;
                } else {
                    if (favLoc.getLocation().getName().compareToIgnoreCase(user.getStations().get(j).getLocationName()) == 0) {
                        System.out.println("    " + (counter + 1) + ") " + user.getStations().get(j).getStationName() + " (" + user.getStations().get(j).getStationId() + ") STATION");
                        counter++;
                    }
                    j++;
                }
            }

            while (i < user.getStops().size()) {
                if (favLoc.getLocation().getName().compareToIgnoreCase(user.getStops().get(i).getLocationName()) == 0) {
                    System.out.println("    " + (counter + 1) + ") " + user.getStops().get(i).getStopName() + " (" + user.getStops().get(i).getStopId() + ") BUS");
                    counter++;
                }
                i++;
            }
            while (j < user.getStations().size()) {
                if (favLoc.getLocation().getName().compareToIgnoreCase(user.getStations().get(j).getLocationName()) == 0) {
                    System.out.println("    " + (counter + 1) + ") " + user.getStations().get(j).getStationName() + " (" + user.getStations().get(j).getStationId() + ") STATION");
                    counter++;
                }
                j++;
            }
        }
        else {
            System.out.println("    TMB is doing its best to make the bus and subway arrive here.");
        }

    }

    public static void printFavStationAndStopsError() {
        System.out.println("In order to have favourite stops and stations it is necessary to create a favourite location previously.");
    }

    public static void printStationsInaugurated(ArrayList<Station> stations, int year){
        System.out.println("Stations inaugurated in " + year + ":");
        for(Station s: stations){
            System.out.println("-" + s.getStationName() + " (" + s.getLineName() + ")");
        }
    }

    public static void printWaitTime(String stopId, ArrayList<Line> lines, User user){
        if (lines != null){
            for (Stop stop: user.getStops()) {
                if (stop.getStopId().compareToIgnoreCase(stopId) == 0){
                    System.out.println("Favourite stop!");
                    break;
                }
            }
            for (Line line : lines) {
                System.out.println(line.getLineName() + " - " + line.getDestination() + " - " + line.getTimeLeftMin() + " min");
            }
        }
    }

}
