package System;

import DataModel.LocationData.Hotel;
import DataModel.LocationData.Location;
import DataModel.LocationData.Monument;
import DataModel.LocationData.Restaurant;
import DataModel.TransportationData.Route;
import DataModel.TransportationData.RouteJourney;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UI {

    public static void printWelcomeMessage(){
        System.out.println("Welcome to the TMBJson application! Please enter the requested information.");

    }

    public static void printRouteLocationError(){
        System.out.println("Welcome to the TMBJson application! Please enter the requested information.");

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

    public static void printInputErrorYN(){
        System.out.println("Error! You must enter \"yes\" or \"no\"." + System.lineSeparator());
    }

    public static void printErrorCoordinates(){
        System.out.println("Error! These coordinates are not valid." + System.lineSeparator());
    }

    public static void printErrorLocationNameExists(){
        System.out.println("Error! This location name already exists." + System.lineSeparator());
    }


    public static void printLocationExistsError(){
        System.out.println("Error! This location already exists." + System.lineSeparator());
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
        System.out.println("Searched locations: ");
        if(LocationHistory != null){
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
        int i = route.getShortestRoute();

        System.out.println("Time taken: " +  Math.round(route.getItineraries().get(i).getDuration() / 60.0) + " min");

        for (int j = 0; j < route.getItineraries().get(i).getJourneys().size(); j++) {
            if(route.getItineraries().get(i).getJourneys().get(j).getLineOrStreet() != null)
                System.out.print(route.getItineraries().get(i).getJourneys().get(j ).getLineOrStreet() + " ");
            if (j == 0)
                System.out.print(route.getItineraries().get(i).getJourneys().get(j).getOrigin());

            else if( route.getItineraries().get(i).getJourneys().get(j - 1).getMode().compareToIgnoreCase("walk") == 0 )
                System.out.print( route.getItineraries().get(i).getJourneys().get(j).getOrigin() );
            if (route.getItineraries().get(i).getJourneys().get(j).getStopCode() != null)
                System.out.print(" (" +  route.getItineraries().get(i).getJourneys().get(j).getStopCode() + ") ");

            if(route.getItineraries().get(i).getJourneys().get(j).getMode().compareToIgnoreCase("walk") == 0){
                System.out.println();
                System.out.println("|");
                System.out.println("Walk " + Math.round ( route.getItineraries().get(i).getJourneys().get(j).getTime() / 60.0) +" min");
                System.out.println("|");

                //System.out.print("|" + route.getItineraries().get(i).getJourneys().get(j).getDestination() + "| (" + (int) route.getItineraries().get(i).getJourneys().get(j).getDistance() + ") ");
            }
            else {
                if (j < (route.getItineraries().get(i).getJourneys().size() -1) && route.getItineraries().get(i).getJourneys().get(j + 1).getStopCode() != null)
                     System.out.print(" -> " + route.getItineraries().get(i).getJourneys().get(j).getDestination() + " (" + route.getItineraries().get(i).getJourneys().get(j + 1).getStopCode() + ") " + Math.round( route.getItineraries().get(i).getJourneys().get(j).getTime()/60.0) +" min");
                else
                    System.out.print(" -> " + route.getItineraries().get(i).getJourneys().get(j).getDestination() + Math.round( route.getItineraries().get(i).getJourneys().get(j).getTime()/60.0) +" min");

            }
            //j++;


        }
        System.out.println(route.getItineraries().get(i).getJourneys().get(route.getItineraries().get(i).getJourneys().size() -1 ).getDestination());

    }


}
