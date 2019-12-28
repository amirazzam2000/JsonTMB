package System;

public class UI {

    public static void printWelcomeMessage(){
        System.out.println("Welcome to the TMBJson application! Please enter the requested information.");

    }
    public static void printInfoValidMessage(){
        System.out.println("The information has been successfully registered!");
    }

    public static void printUserWelcomeMessage(String username){
        System.out.println("The information has been successfully registered!");
    }

    public static void printMainMenu(){
        System.out.println("1. User Management");
        System.out.println("2. Search locations");
        System.out.println("3. User Management");
        System.out.println("4. Bus wait time");
        System.out.println("5. Exit");
        System.out.println();
        System.out.println("Select an option: ");
    }
    public static void printOption1Menu(){
        System.out.println("a) My Locations");
        System.out.println("b) Location History");
        System.out.println("c) My routes");
        System.out.println("d) Favourite stops and stations");
        System.out.println("e) Stations inaugurated my birth year");
        System.out.println("f) Back to the principal menu");
        System.out.println();
        System.out.println("Select an option: ");
    }
}
