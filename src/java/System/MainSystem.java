package System;

import Managers.UserManager.UserManager;

import java.util.Scanner;

public class MainSystem {
    public static void mainSystem(){
        UserManager users = new UserManager();
        Scanner userScanner = new Scanner(System.in);

        UI.printWelcomeMessage();

        System.out.println("Username:");
        users.setName(userScanner.nextLine());

        System.out.println(System.lineSeparator() + "E-mail:");
        users.setEmail(userScanner.nextLine());

        System.out.println(System.lineSeparator() + "Birth Year:");
        users.setYear(userScanner.nextInt());

        UI.printInfoValidMessage();
    }
}
