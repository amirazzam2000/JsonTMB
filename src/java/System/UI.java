package System;

import DataModel.LocationData.Location;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {

    public static void printWelcomeMessage(){
        System.out.println("Welcome to the TMBJson application! Please enter the requested information.");

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
        System.out.println("3. User Management");
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

        }
        else{

        }
    }


}
