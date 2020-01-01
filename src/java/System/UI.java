package System;

import DataModel.LocationData.*;
import DataModel.TransportationData.*;
import DataModel.User.User;

import javax.sound.midi.Soundbank;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * Class: java.System.UI
 *
 * Prints the menus and the results of running each of the options
 *
 * @author Amir Azzam - amir.azzam@students.salle.url.edu
 * @author <br/>Nicole Alexa leser - nicolealexa.leser@students.salle.url.edu
 * @version 28/12/2019
 *
 */
public class UI {

    /**
     * prints the welcome message when you lunch the program
     */
    public static void printWelcomeMessage(){
        System.out.println("Welcome to the TMBJson application! Please enter the requested information.");
    }

    /**
     * prints a message when the user enters all their information correctly
     */
    public static void printInfoValidMessage(){
        System.out.println("The information has been successfully registered!");
    }

    /**
     * prints an error when the user enteres an invalid option in the menu
     */
    public static void printErrorMenu(){
        System.out.println("'ERROR: Invalid option'"+ System.lineSeparator() + "Please choose an option from the menu"+ System.lineSeparator());
    }

    /**
     * prints an error whe the user is asked to enter (yes/no) but they enter
     * something different
     */
    public static void printInputErrorYN(){
        System.out.println("Error! You must enter \"yes\" or \"no\"." + System.lineSeparator());
    }

    /**
     * prints an error when the user enters wrong coordinates
     */
    public static void printErrorCoordinates(){
        System.out.println("Error! These coordinates are not valid." + System.lineSeparator());
    }

    /**
     * prints error when the user creates a new location with an already
     * existing name
     */
    public static void printErrorLocationNameExists(){
        System.out.println("Error! This location name already exists." + System.lineSeparator());
    }

    /**
     * prints an error when the user search for the subway stations
     * inaugurated in their birth year bu they don't find nay
     */
    public static void printErrorNoStationsThisYear(){
        System.out.println("No subway station opened your birth year :(" + System.lineSeparator());
    }

    /**
     * prints an error message when the users try set the origin or the
     * destination of a route to a location that is not registered in the system
     */
    public static void printRouteLocationError(){
        System.out.println("Sorry, this location is not valid :(" + System.lineSeparator());
    }

    /**
     * prints an error message when the user enters a wrong character while
     * specifying the information of the route the want to plan
     */
    public static void printRouteDestArrivalError(){
        System.out.println("Error! You must enter \"d\" or \"a\"!.");

    }

    /**
     * prints an error message when the user enters a wrong type for the
     * favorite location other than hte ones specified in the question message
     */
    public static void printFavLocationTypeError(){
        System.out.println("Error! You have to enter \"home\", \"work\", \"studies\", \"leisure\" or \"culture\"." + System.lineSeparator());
    }

    /**
     * prints when the user asks to show the stations and stops around them
     * before they assign any favorite locations
     */
    public static void printFavStationAndStopsError() {
        System.out.println("In order to have favourite stops and stations it is necessary to create a favourite location previously.");
    }


    /**
     * prints the main menu
     */
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


    /**
     * prints the User Management menu
     */
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

    //TODO : fix comment

    /**
     * prints all the locations the user has created
     * @param locations contains all the locations created by the user
     */
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
    // TODO : fix comment

    /**
     * prints all the locatino s that the user has searched for using option
     * 2 (Search locations)
     * @param LocationHistory contain all the locations the user searched for
     *                        ordered according to when the user searched for
     *                        them.
     */
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

    /**
     * prints the information of the specific location the user has searched
     * for.
     * @param location the location the user is searching for
     */
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

    /**
     * prints the best route after selecting it form the different routes the
     * api returns. this method uses another method in the Route class
     * @param route all the possible routes offered by API to go from the origin
     *             to the destination
     * @see Route
     */
    public static void printRoute(Route route){
        int i = route.getShortestRoute(route.getMaxWalkingDistance());

        System.out.println("Time taken: " +  Math.round(route.getItineraries().get(i).getDuration() / 60.0) + " min");

        /*
         * check that the chosen route is within the maximum walking
         * distance limit and show a warning message if not
         */
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


    /**
     * print all the routes that the user have planned before
     * @param myRoutes contains all the information about the routes the user
     *                 has planned before.
     */
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

    /**
     * prints all the stations and stops that are within 0.5Km radios from
     * the users specified favorite location
     * @param user the user that is currently logged in the program
     * @param favLoc the favorite location you want to print the stations and
     *              stops around
     * @param print specifies wither there is any stations and stops around
     *              the specified favorite location. it takes the value 'true'
     *              if the specified location has stops and stations around
     *              it and we have to print them, and takes the value 'false'
     *              if the specified location doesn't have any stations and
     *              stops around it so we don't have to print any thing, and
     *              we should show a message saying so.
     */
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

    /**
     * prints the stations that were built on the same year as the user's
     * birth year they entered when logging into the program
     * @param stations all the stations that were built on the specified year
     *                returned by the API
     * @param year the year in which the user was born
     */
    public static void printStationsInaugurated(ArrayList<Station> stations, int year){
        System.out.println("Stations inaugurated in " + year + ":");
        for(Station s: stations){
            System.out.println("-" + s.getStationName() + " (" + s.getLineName() + ")");
        }
    }

    /**
     * prints the waiting time for all the bus lines that stop at the
     * specified stop
     * @param stopId the code of the stop we are interested in knowing the
     *               information about
     * @param lines all the lines that stop at the specified stop
     * @param user the information of the currently logged in user
     */
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
