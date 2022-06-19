package ui;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        System.out.println("Hello, Welcome to the Hotel Reservation App");
        showMainMenu();


    }

    private static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isValid = false;
        int choice = 0;


        System.out.println("Main Menu");
        System.out.println("--------------------------");
        System.out.println("1. Find and reserve a room");
        System.out.println("2. See my reservations");
        System.out.println("3. Create an account");
        System.out.println("4. Admin");
        System.out.println("5. Exit");
        System.out.println("--------------------------");
        System.out.println("Please select a number for the menu option");

        do {
            input = scanner.next();
            try {
                choice = Integer.parseInt(input);
                if(choice > 0 && choice < 6) {
                    isValid = true;
                } else {
                    choiceError();
                }
            } catch (Exception exc) {
                System.out.println("Please enter a number between 1 and 5.");
            }
        } while (isValid == false);
        getOption(choice);

    }

    private static void getOption(int menuChoice) {
        switch(menuChoice) {
            case 1:
                findAndReserve();
                break;
            case 2:
                seeReservations();
                break;
            case 3:
                createAccount();
                break;
            case 4:
                openAdmin();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                choiceError();
        }
    }

    private static void choiceError() {
        System.out.println("Please enter a number between 1 and 5");
        showMainMenu();
    }

    private static void openAdmin() {
    }

    private static void createAccount() {

    }

    private static void seeReservations() {

    }

    private static void findAndReserve() {

    }
}
