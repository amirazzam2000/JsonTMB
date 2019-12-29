package System;

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
        int firstOption;
        String secondOption;
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
                        secondOption = scanner.next();
                        switch (secondOption.toLowerCase()) {
                            case "a":
                                UI.printMyLocationOption(users.getMyLocation());
                                break;
                            case "b":

                                break;
                            case "c":
                                break;
                            case "d":
                                break;
                            case "e":
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
                    break;
                case 3:
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
