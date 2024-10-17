/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;
import controller.Tutor;
import java.util.Scanner;
import controller.TutorialGroupDriver;


/**
 *
 * @author blon8
 */
public class MainMenu {

    public static void main(String[] args) {
        Login(); 
    }
    
      public static void Login() {
        String adminUsername = "admin";
        String adminPassword = "password";

        // Ask the user to enter their credentials
        System.out.println("Please enter your credentials to login.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        // Check if the username and password are correct
        if (inputUsername.equals(adminUsername) && inputPassword.equals(adminPassword)) {
            System.out.println("Login successful!\n");

            menu();
        } else {
            System.out.println("Invalid username or password. Please try again.\n");
            System.exit(0);
        }
    }

    public static void menu() { //Contains the main menu

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        //Display menu   
        while (!exit) {
            System.out.println("|============================|");
            System.out.println("  TARUMT ADMINSTRATION APP  ");
            System.out.println("|============================|");
            System.out.println("Menu options:");
            System.out.println("1. Programme Management");
            System.out.println("2. Tutorial Group Management");
            System.out.println("3. Tutor Management");
            System.out.println("4. Course Management");
            System.out.println("5. Exit");
            System.out.println("|----------------------------|");
            System.out.print("Please select a module:");
            
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    new ProgrammeMenu();
                    break;
                case 2:
                    new TutorialGroupDriver();
                    break;
                case 3:
                    new Tutor().main();
                    break;
                case 4:
                    new CourseMenu().CourseMenu();
                    break;
                case 5:
                    System.out.println("See You Next Time");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Module. Please try again.");
                    break;
            }
        }
    }
    
      
}
