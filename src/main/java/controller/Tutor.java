/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import adt.ArrayList;
import adt.ListInterface;
import entity.Tutors;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author jamesyew
 */
public class Tutor {

    Scanner input = new Scanner(System.in);
    int select = 0;
    String confirm;

    private ListInterface<Tutors> tutorsList = new adt.ArrayList<>();
    private ListInterface<Tutors> tutorsListSort = new ArrayList<>();

    public void main() {
        initialize();
        do {
            System.out.println("\n==== Tutors ====\n");
            System.out.println("1: Add");
            System.out.println("2: Remove");
            System.out.println("3: Search");
            System.out.println("4: Update Tutor details");
            System.out.println("5: Display tutors");
            System.out.println("6: Filter tutors");
            System.out.println("7: Generate report");
            System.out.println("8: Back to Menu");
            System.out.print("\nSelect: ");
            select = input.nextInt();
            switch (select) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    filter();
                    break;
                case 7:
                    generateReport();
                    break;
                case 8:
                    System.out.print("Back to menu...\n");
                    break;
                default:
                    System.out.println("\nInvalid Input !!");
                    break;
            }
        } while (select != 8);
    }

    public void initialize() {
        tutorsList.add(new Tutors(10001, "Thamarai", true, "Data Structures", 5));
        tutorsList.add(new Tutors(10002, "Hussaini", true, "Tennis", 14));
        tutorsList.add(new Tutors(10003, "Latifah", true, "Research Methods", 15));
        tutorsList.add(new Tutors(10004, "Liaw", true, "Web Application", 12));
        tutorsList.add(new Tutors(10005, "Haslinda", true, "Web Engineering", 2));
        tutorsList.add(new Tutors(10006, "Yeoh", true, "Data Structures(P)", 18));
        tutorsList.add(new Tutors(10007, "Jane", false, "Data Structures", 5));
        tutorsList.add(new Tutors(10008, "Fong", true, "Research Methods", 16));
        tutorsList.add(new Tutors(10009, "Ruby", false, "Computer Organisation", 6));
        tutorsList.add(new Tutors(10010, "Tiara", false, "Artificial Intelligence", 8));
    }

    public void add() {
        String continueStr = "";
        do {
            System.out.println("********************************************");
            System.out.println("**               Add Tutor                 **");
            System.out.println("********************************************");

            //Tutor ID input
            System.out.print("Enter Tutor ID: ");
            int tutorID = input.nextInt();
            input.nextLine();

            //Tutor Name input
            System.out.print("Enter Tutor Name: ");
            String tutorName = input.nextLine();

            //Tutor Status input
            System.out.print("Tutor status active: (True or False) ");

            boolean tutorStatus;
            while (true) {
                String userInput = input.next();
                if (userInput.equalsIgnoreCase("true")) {
                    tutorStatus = true;
                    break;
                } else if (userInput.equalsIgnoreCase("false")) {
                    tutorStatus = false;
                    break;
                } else {
                    System.out.print("Invalid input. Please enter 'True' or 'False': ");
                }
            }

            // Consume the newline character
            input.nextLine();

            // Tutor Subject input
            System.out.print("Enter Tutor Subject: ");
            String tutorSubject = input.nextLine();

            // Tutor ID input
            System.out.print("Enter Tutor Experience: ");
            int tutorExperience = input.nextInt();
            input.nextLine(); // Consume the newline character

            tutorsList.add(new Tutors(tutorID, tutorName, tutorStatus, tutorSubject, tutorExperience));

            System.out.println("\n---------------------------------------------");
            System.out.println("\n             New tutor is added            ");
            System.out.println("\n---------------------------------------------");
            System.out.print("\nDo you wish to add more tutors??? (Y/N) > ");
            continueStr = input.next();
            System.out.println("");

        } //Yes or No option
        while (!"N".equals(continueStr.toUpperCase()));
    }

    public void remove() {

        System.out.println("********************************************");
        System.out.println("**               Remove tutor                 **");
        System.out.println("********************************************");

        if (tutorsList.isEmpty()) {
            System.out.println("\n Tutor list is Empty !!!");
        } else {
            do {
                tutorHeader();
                for (int i = 0; i < tutorsList.getNumberOfEntries(); i++) {
                    System.out.printf("%-16s", tutorsList.getEntry(i + 1).getTutorID());
                    System.out.printf("%-20s", tutorsList.getEntry(i + 1).getTutorName());
                    System.out.printf("%-20s", tutorsList.getEntry(i + 1).getTutorStatus());
                    System.out.printf("%-20s", tutorsList.getEntry(i + 1).getTutorSubject());
                    System.out.printf("%-20s\n", tutorsList.getEntry(i + 1).getTutorExperience());

                }
                System.out.println("=====================================================================================\n");
                System.out.println("Tutor ID (For Remove):");
                int tID = input.nextInt();
                input.nextLine();

                for (int i = 0; i < tutorsList.getNumberOfEntries(); i++) {
                    if (tutorsList.getEntry(i + 1).getTutorID() != tID) {
                        System.out.println("Tutor ID Not Found !!!\n");
                    } else {
                        tutorsList.remove(i + 1);
                        System.out.println("\n Tutor Removed !!!");
                    }
                }
                System.out.print("Do you want to continue remove? (Y/N): ");
                confirm = input.nextLine();

            } while (!"N".equals(confirm.toUpperCase()));
        }
    }

    public void search() {

        System.out.println("********************************************");
        System.out.println("**           Search Tutor Details             **");
        System.out.println("********************************************");

        if (!tutorsList.isEmpty()) {
            int tutorNumber;
            int tutorIndex;
            do {
                System.out.print("Enter tutor ID to search: ");
                tutorNumber = input.nextInt();

                if (tutorNumber == -1) {
                    return; // Exit the method
                }

                tutorIndex = -1;
                for (int i = 1; i <= tutorsList.getNumberOfEntries(); i++) {
                    if (tutorsList.getEntry(i).getTutorID() == tutorNumber) {
                        tutorIndex = i;
                        break;
                    }
                }

                if (tutorIndex == -1) {
                    System.out.println("Tutor not found. Please enter a valid Tutor ID.");
                }
            } while (tutorIndex == -1);

            Tutors foundTutor = tutorsList.getEntry(tutorIndex);
            System.out.println("Tutor ID: " + foundTutor.getTutorID());
            System.out.println("Tutor Name: " + foundTutor.getTutorName());
            System.out.println("Tutor status active: " + foundTutor.getTutorStatus());
            System.out.println("Tutor Subject: " + foundTutor.getTutorSubject());
            System.out.println("Tutor Experience: " + foundTutor.getTutorExperience());
        } else {
            System.out.println("Tutor not found.");
        }
    }

    public void update() {
        System.out.println("********************************************");
        System.out.println("**           Update Tutor Details             **");
        System.out.println("********************************************");

        if (!tutorsList.isEmpty()) {
            int tutorID;
            int tutorIndex;
            do {
                System.out.print("Enter tutor ID to edit: ");
                tutorID = input.nextInt();

                if (tutorID == -1) {
                    return; // Exit the method
                }

                tutorIndex = 0;
                for (int i = 1; i <= tutorsList.getNumberOfEntries(); i++) {
                    if (tutorsList.getEntry(i).getTutorID() == tutorID) {
                        tutorIndex = i;
                        break;
                    }
                }

                if (tutorIndex == 0) {
                    System.out.println("Tutor not found. Please enter a valid Tutor ID.");
                }
            } while (tutorIndex == 0);

            Tutors foundTutor = tutorsList.getEntry(tutorIndex);
            System.out.println("Tutor found. Continuing with editing process...\n");
            System.out.println("Tutor ID: " + foundTutor.getTutorID());
            System.out.println("Tutor Number: " + foundTutor.getTutorName());
            System.out.println("Tutor status active: " + foundTutor.getTutorStatus());
            System.out.println("Tutor Subject: " + foundTutor.getTutorSubject());
            System.out.println("Tutor Experience: " + foundTutor.getTutorExperience());

          
            int option;
            do {
                System.out.println("Choose an option:");
                System.out.println("1. Edit tutor name");
                System.out.println("2. Edit tutor status");
                System.out.println("3. Edit tutor subject");
                System.out.println("4. Edit tutor experience");
                System.out.print("Enter your choice: ");

                option = input.nextInt();
                input.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        System.out.print("Enter tutor name: ");
                        String tutorName = input.nextLine();
                        foundTutor.setTutorName(tutorName);
                        break;

                    case 2:
                        System.out.print("Enter tutor status (True or False): ");
                        boolean tutorStatus = input.nextBoolean();
                        foundTutor.setTutorStatus(tutorStatus);
                        break;

                    case 3:
                        System.out.print("Enter tutor subject: ");
                        String tutorSubject = input.nextLine();
                        foundTutor.setTutorSubject(tutorSubject);
                        break;

                    case 4:
                        System.out.print("Enter tutor experience: ");
                        int tutorExp = input.nextInt();
                        foundTutor.setTutorExperience(tutorExp);
                        break;

                    default:
                        System.out.println("Please choose between 1 to 4.");
                        break;
                }
            } while (option < 1 || option > 4);

            System.out.println("Successfully edited!");

        }
    }

    

    public void display() {
        System.out.println("********************************************");
        System.out.println("**               Display Tutor                **");
        System.out.println("********************************************");

        System.out.println("\n\n==============================Tutor Listing====================================");
        tutorHeader();
        if (!tutorsList.isEmpty()) {
            int count = 0;
            for (int i = 0; i < tutorsList.getNumberOfEntries(); i++) {
                System.out.printf("%-16s", tutorsList.getEntry(i + 1).getTutorID());
                System.out.printf("%-20s", tutorsList.getEntry(i + 1).getTutorName());
                System.out.printf("%-20s", tutorsList.getEntry(i + 1).getTutorStatus());
                System.out.printf("%-15s", tutorsList.getEntry(i + 1).getTutorSubject());
                System.out.printf("%-15s\n", tutorsList.getEntry(i + 1).getTutorExperience());
                count++;
            }
            System.out.println("=====================================================================================\n");
            System.out.printf("Total tutors: %d\n", count);
        } else {
            System.out.println("=====================================================================================");
            System.out.println("\nNo Result found !!!");
            System.out.println("=====================================================================================\n");
        }
    }

    public void filter() {
        sortTutorEXP();
    }

    public void generateReport() {
        System.out.println("********************************************");
        System.out.println("**           Generate Tutor Report             **");
        System.out.println("********************************************");

        //Total number of tutors
        int totalTutors = tutorsList.getNumberOfEntries();
        System.out.println("Total number of tutors: " + totalTutors);

        //Total tutor experience
        int[] tutorExp = new int[tutorsList.getNumberOfEntries()];
        int sumExp = 0; // Initialize sumExp outside the loop

        for (int i = 1; i <= tutorsList.getNumberOfEntries(); i++) {
            Tutors tutors = tutorsList.getEntry(i);
            int getExp = tutors.getTutorExperience();
            sumExp += getExp;
        }
        System.out.println("Total experience: " + sumExp); // Print the total experience

        //Total number of active staff
        int activeTutorsCount = 0;
        for (int i = 1; i <= tutorsList.getNumberOfEntries(); i++) {
            Tutors tutors = tutorsList.getEntry(i);
            boolean tutorStatus = tutors.getTutorStatus(); // Replace with the actual method to get the tutor's status
            if (tutorStatus) {
                activeTutorsCount++;
            }
        }

        System.out.println("Number of active tutors: " + activeTutorsCount);

    }

    public static void tutorHeader() {
        System.out.println("=====================================================================================");
        System.out.printf("%-15s %-19s %-19s %-15s %-15s\n",
                "Tutor ID",
                "Tutor Name",
                "Active Status",
                "Tutor Subject",
                "Years in service");
        System.out.println("=====================================================================================");
    }

    //Interchange tutorsList & tutorsListSort
    private void interchange() {
        for (int i = 1; i <= tutorsList.getNumberOfEntries(); i++) {
            tutorsListSort.add(tutorsList.getEntry(i));
        }
    }

    public void sortTutorEXP() {
        tutorsListSort.clear();
        interchange();
        // Sort the list based on courseNumber using the Comparator
        Comparator<Tutors> tutorEXPComparator = Comparator.comparingInt(Tutors::getTutorExperience);
        tutorsListSort.mergeSort(tutorEXPComparator);
        displaySortedEXP();

    }

    public void displaySortedEXP() {
        System.out.println("********************************************");
        System.out.println("**      Sorted Tutor's Experience      **");
        System.out.println("********************************************");
        for (int i = 1; i <= tutorsListSort.getNumberOfEntries(); i++) {
            System.out.println(tutorsListSort.getEntry(i));
        }
    } 

}
