package controller;

import entity.Programme;
import adt.ArrayList;
import adt.ListInterface;
import entity.TutorialGroup;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class ProgrammeCRUD {

    private ListInterface<TutorialGroup> tutorialGroup = new ArrayList<>();
    private ListInterface<Programme> programmeList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Programme programme;

    public ProgrammeCRUD() {
        initialization();
    }
    

    private void initialization() {
        programme = new Programme("RITY1S1", "Bachelor of Information Technology (Honours) in Internet Technology");
        programmeList.add(programme);
        programme = new Programme("RITY1S2", "Bachelor of Information Technology (Honours) in Internet Technology");
        programmeList.add(programme);
        programme = new Programme("RITY1S3", "Bachelor of Information Technology (Honours) in Internet Technology");
        programmeList.add(programme);
        programme = new Programme("RSDY1S1", "Bachelor of Information Technology (Honours) in Software Systems Development");
        programmeList.add(programme);
        programme = new Programme("RSDY1S2", "Bachelor of Information Technology (Honours) in Software Systems Development");
        programmeList.add(programme);
        programme = new Programme("RSDY1S3", "Bachelor of Information Technology (Honours) in Software Systems Development");
        programmeList.add(programme);
        programme = new Programme("RISY1S1", "Bachelor of Information Technology (Honours) in Information Security");
        programmeList.add(programme);
        programme = new Programme("RISY1S2", "Bachelor of Information Technology (Honours) in Information Security");
        programmeList.add(programme);
        programme = new Programme("RISY1S3", "Bachelor of Information Technology (Honours) in Information Security");
        programmeList.add(programme);
        
        tutorialGroup.add(new TutorialGroup("RITY1S1G1", 10));
        tutorialGroup.add(new TutorialGroup("RITY1S1G2", 12));
        tutorialGroup.add(new TutorialGroup("RITY1S2G1", 10));
        tutorialGroup.add(new TutorialGroup("RITY1S2G2", 19));
        tutorialGroup.add(new TutorialGroup("RITY1S3G1", 12));
        tutorialGroup.add(new TutorialGroup("RITY1S3G2", 11));
        
        tutorialGroup.add(new TutorialGroup("RSDY1S1G1", 18));
        tutorialGroup.add(new TutorialGroup("RSDY1S1G2", 17));
        tutorialGroup.add(new TutorialGroup("RSDY1S2G1", 15));
        tutorialGroup.add(new TutorialGroup("RSDY1S2G2", 13));
        tutorialGroup.add(new TutorialGroup("RSDY1S3G1", 12));
        tutorialGroup.add(new TutorialGroup("RSDY1S3G2", 9));
        
        tutorialGroup.add(new TutorialGroup("RISY1S1G1", 11));
        tutorialGroup.add(new TutorialGroup("RISY1S1G2", 18));
        tutorialGroup.add(new TutorialGroup("RISY1S2G1", 16));
        tutorialGroup.add(new TutorialGroup("RISY1S2G2", 15));
        tutorialGroup.add(new TutorialGroup("RISY1S3G1", 13));
        tutorialGroup.add(new TutorialGroup("RISY1S3G2", 12));

    }

    public ListInterface<Programme> getProgrammeList() {
        return programmeList;
    }

    //Add Programme
    public void addProgramme() {
        System.out.println("\n");
        System.out.println("********************************************");
        System.out.println("**               Add Programme            **");
        System.out.println("********************************************");
        System.out.print("Enter Programme ID: ");
        String programmeID = scanner.nextLine().toUpperCase();
        System.out.print("Enter Programme Name: ");
        String programmeName = scanner.nextLine();

        while (detectProgrammeID(programmeID)) {
            System.out.println("The Programme ID has already been taken, Please enter another programme code!");
            System.out.print("Enter Programme ID: ");
            programmeID = scanner.nextLine().toUpperCase();
        }

        if (programmeList == null) {
            programmeList = new ArrayList<>();
        }

        programme = new Programme(programmeID, programmeName);
        programmeList.add(programme);
        System.out.println("\nSuccessfully your programme had been added");
        System.out.println("Programme ID = " + programme.getProgrammeID());
        System.out.println("Programme Name = " + programme.getProgrammeName());
        System.out.println("Programme = " + programme.getProgrammeID() + " " + programme.getProgrammeName());
    }

    public void removeProgramme() {
        System.out.println("\n********************************************");
        System.out.println("**               Remove Programme         **");
        System.out.println("********************************************");
        if (!programmeList.isEmpty()) {

            int programmeIndex;

            displayProgramme();

            do {
                System.out.print("Enter a Programme Id to remove (type -1 to exit) --> ");
                String programmeID = scanner.nextLine().toUpperCase();

                if (programmeID.equals("-1")) {
                    return; // Exit the method
                }

                programmeIndex = -1;
                for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                    if ((programmeList.getEntry(i).getProgrammeID()).equals(programmeID)) {
                        programmeIndex = i;
                        break;
                    }
                }

                if (programmeIndex == -1) {
                    System.out.println("Programme not found!!! Please enter a valid Programme Id!");
                }
            } while (programmeIndex == -1);

            programmeList.remove(programmeIndex);
            System.out.println("Programme removed successfully");
        } else {
            System.out.println("No Programme to remove.");
        }
    }

    public void editProgramme() {

        System.out.println("\n********************************************");
        System.out.println("**           Edit Programme Details       **");
        System.out.println("********************************************");

        displayProgramme();

        if (!programmeList.isEmpty()) {
            int programmeIndex;
            do {
                System.out.print("Enter a Programme Id to edit (type -1 to exit) --> ");
                String programmeID = scanner.nextLine().toUpperCase();

                if (programmeID.equals("-1")) {
                    return; // Exit the method
                }

                programmeIndex = -1;
                for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                    if ((programmeList.getEntry(i).getProgrammeID()).equals(programmeID)) {
                        programmeIndex = i;
                        break;
                    }
                }

                if (programmeIndex == -1) {
                    System.out.println("Programme not found. Please enter a valid Programme ID.");
                }
            } while (programmeIndex == -1);

            Programme foundProgramme = programmeList.getEntry(programmeIndex);
            System.out.println("Programme found. Continuing with editing process...\n");
            System.out.println("Programme ID: " + foundProgramme.getProgrammeID());
            System.out.println("Programme Name: " + foundProgramme.getProgrammeName());

            System.out.println("\nWhat info do you want to edit?\nOption: \n1: Programme ID\n2: Programme Name");
            int option;
            do {
                System.out.print("Please enter your option (1 or 2): ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Enter New Programme ID: ");
                        String programmeID = scanner.nextLine().toUpperCase();

                        while (detectProgrammeID(programmeID)) {
                            System.out.println("Programme ID has already been taken. Please try again with another number.");
                            System.out.print("Enter New Programme ID: ");
                            programmeID = scanner.nextLine().toUpperCase();
                        }

                        programmeList.getEntry(programmeIndex).setProgrammeID(programmeID);
                        break;
                    case 2:
                        System.out.print("Enter New Programme Name: ");
                        String programmeName = scanner.nextLine();

                        while (detectProgrammeName(programmeName)) {
                            System.out.println("Programme Name has already been taken. Please try again with another name.");
                            System.out.print("Enter New Programme Name: ");
                            programmeName = scanner.nextLine();
                        }

                        programmeList.getEntry(programmeIndex).setProgrammeName(programmeName);
                        break;
                    default:
                        System.out.print("Please choose between 1 and 2 only!\n");
                        break;
                }
            } while (option < 1 || option > 2);

            System.out.println("Successfully edited.\n");
        }
    }
    
   //Display ProgrammeID and Name
    public void displayProgramme() {
        System.out.println("\n==============================Programme Listing====================================");
        if (programmeList.isEmpty()) {
            System.out.println("Programme List is Empty!!!, Please add some Programme!");
        } else {
            for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                System.out.println(i+". "+"Programme ID: " + programmeList.getEntry(i).getProgrammeID() + " | Programme Name: " + programmeList.getEntry(i).getProgrammeName());
            }
        }
    }
    
    //Display Programme ID only
     public void displayProgrammeID() {
        System.out.println("\n==========Programme Listing==========");
        if (programmeList.isEmpty()) {
            System.out.println("Programme List is Empty!!!, Please add some Programme!");
        } else {
            for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                System.out.println(i+". "+"Programme ID: " + programmeList.getEntry(i).getProgrammeID());
            }
        }
    }

    public void searchProgramme() {
        System.out.println("\n********************************************");
        System.out.println("**         Search Programme Details       **");
        System.out.println("********************************************");
        displayProgrammeID();

        if (!programmeList.isEmpty()) {

            int programmeIndex;

            do {
                System.out.print("Enter a Programme ID to search (type -1 to exit) --> ");
                String programmeID = scanner.nextLine().toUpperCase();

                if (programmeID.equals("-1")) {
                    return; // Exit the method
                }

                programmeIndex = -1;
                for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                    if ((programmeList.getEntry(i).getProgrammeID()).equals(programmeID)) {
                        programmeIndex = i;
                        break;
                    }
                }

                if (programmeIndex == -1) {
                    System.out.println("Programme not able to found. Please enter a valid Programme ID.");
                }
            } while (programmeIndex == -1);

            Programme foundProgramme = programmeList.getEntry(programmeIndex);
            System.out.println("\nProgramme that you searched: ");
            System.out.println("Programme ID: " + foundProgramme.getProgrammeID());
            System.out.println("Programme Name: " + foundProgramme.getProgrammeName());
        } else {
            System.out.println("Programme not able to found.");
        }
    }

    public void addTutorialToProgramme() {

        System.out.println("\n********************************************");
        System.out.println("**     Add Tutorial Group to Programme    **");
        System.out.println("** *****************************************");
        displayProgramme();
        
       
        if (!programmeList.isEmpty()) {
            System.out.print("Enter the Programme ID of the Programme to which you want to add a Tutorial Group: (type -1 to exit) --> ");
            String programmeID = scanner.nextLine().toUpperCase();
            
            

            Programme targetProgramme = null;

            for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                if (programmeList.getEntry(i).getProgrammeID().equals(programmeID)) {
                    targetProgramme = programmeList.getEntry(i);
                }
            }

            if (targetProgramme != null) {
                displayTutorialGroup();
                System.out.print("Enter the Tutorial Group ID of the programme to add: ");
                String tgID = scanner.nextLine().toUpperCase();

                TutorialGroup tgAdd = findTutorialGroup(tgID);

                if (tgAdd != null) {
                    if (!targetProgramme.hasProgramme(tgAdd)) {
                        targetProgramme.addTutorialGroup(tgAdd);
                        System.out.println("Programme added to the tutorialGroup successfully.");
                    } else {
                        System.out.println("The TutorialGroup already taken the programme.");
                    }
                } else {
                    System.out.println("Programme not found.");
                }
            } else {
                System.out.println("TutorialGroup not found.");
            }
        } else {
            System.out.println("No tutorialGroup available.");
        }
    }

    public void removeTutorialToProgramme() {

        System.out.println("\n********************************************");
        System.out.println("** Remove a Tutorial Group from Programme **");
        System.out.println("** *****************************************");
        displayProgramme();

        if (!programmeList.isEmpty()) {
            System.out.print("Enter the Programme ID of the Programme to which you want to remove a Tutorial Group: ");
            String programmeID = scanner.nextLine().toUpperCase();
            
            Programme targetProgramme = null;

            for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                if (programmeList.getEntry(i).getProgrammeID().equals(programmeID)) {
                    targetProgramme = programmeList.getEntry(i);
                 break;   
                }
            }

            if (targetProgramme != null) {
                ListInterface<TutorialGroup> tutorialGroup = targetProgramme.getTutorialGroup();
                
                if (tutorialGroup.isEmpty()){
                System.out.println("This Programme doesn't have any Tutorial Group.");
                } else{
                    
                 listAllTutorialProgramme();
                
                System.out.print("Enter the Tutorial Group ID of the programme to remove: ");
                String tgID = scanner.nextLine().toUpperCase();

                TutorialGroup tgRemove = findTutorialGroup(tgID);

                if (tgRemove != null) {
                    if (targetProgramme.hasProgramme(tgRemove)) {
                        targetProgramme.removeTutorialGroup(tgRemove);
                        
                        System.out.println("Programme removed the tutorialGroup successfully.");
                    } else {
                        System.out.println("The TutorialGroup already removed from the programme.");
                    }
                } else {
                    System.out.println("TutorialGroup not found.");
                }
              }
            } else {
                System.out.println("TutorialGroup not found.");
            }
        } else {
            System.out.println("No tutorialGroup available.");
        }
    }
    
    // List all Details about Programme and Tutorial Group
    public void listAllTutorialProgramme() {

        System.out.println("\n==============================Programme Listing====================================");
        if (programmeList.isEmpty()) {
            System.out.println("Programme List is Empty!!!, Please add some Programme!");
        } else {
            for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                System.out.println(i+". "+programmeList.getEntry(i));
            }
        }

    }
    
    //List all Tutorial Group In a Programme
    public void ListAllTgInprogramme(){
        System.out.println("\n********************************************");
        System.out.println("**  List Tutorial Group from a Programme  **");
        System.out.println("** *****************************************");
        
        displayProgramme();
        
         if (!programmeList.isEmpty()) {

            int programmeIndex;

            do {
                System.out.print("Enter a Programme ID to display the Tutorial Group (type -1 to exit) --> ");
                String programmeID = scanner.nextLine().toUpperCase();

                if (programmeID.equals("-1")) {
                    return; // Exit the method
                }

                programmeIndex = -1;
                for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
                    if ((programmeList.getEntry(i).getProgrammeID()).equals(programmeID)) {
                        programmeIndex = i;
                        break;
                    }
                }

                if (programmeIndex == -1) {
                    System.out.println("Programme not able to found. Please enter a valid Programme ID.");
                }
            } while (programmeIndex == -1);

            Programme foundProgramme = programmeList.getEntry(programmeIndex);
            System.out.println("\nProgramme that you searched: ");
            System.out.println("Programme ID: " + foundProgramme.getProgrammeID());
            System.out.println("Programme Name: " + foundProgramme.getProgrammeName());
            System.out.println("Tutorial Group: \n" + foundProgramme.getTutorialGroup());
        } else {
            System.out.println("Programme not able to found.");
        }
    }
    
    

    //Print Report
    public void viewReport() {
        System.out.println("\n********************************************");
        System.out.println("**       Generate Programme Report       **");
        System.out.println("********************************************");
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Date & Time: "+ formatter.format(currentDateTime));

        int totalProgramme = programmeList.getNumberOfEntries();
        System.out.println("Total Number of Programme: " + totalProgramme);
        System.out.println("All Programme & Tutorial Group: ");
        System.out.println("=============================================================");
        //display programme list
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            System.out.println(i+". "+programmeList.getEntry(i));
        }

        System.out.print("===============================================");
        System.out.print("============ End Of Programme Report ==========");
        System.out.print("==============================================\n");

    }

    //display tutorialgroup
    private void displayTutorialGroup() {
        System.out.println("List of TutorialGroup:");
        for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {
            TutorialGroup tg = tutorialGroup.getEntry(i);
            System.out.println(i+". Tutorial Group ID: "+tg.getTutorialGroupID() + " | GroupMember: " + tg.getMemberOfNumber());
        }
    }

    private TutorialGroup findTutorialGroup(String tgId) {
        for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {
            TutorialGroup tg = tutorialGroup.getEntry(i);
            if (tg.getTutorialGroupID().equals(tgId)) {
                return tg;
            }
        }
        return null;
    }

    //To check Programme ID is used or not
    public boolean detectProgrammeID(String programmeID) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            if (programmeList.getEntry(i).getProgrammeID().equals(programmeID)) {
                return true;
            } else {
            }
        }
        return false;
    }

    //To check Programme name is used or not 
    public boolean detectProgrammeName(String targetProgrammeName) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            String programmeName = programmeList.getEntry(i).getProgrammeName();
            if (programmeName.equals(targetProgrammeName)) {
                return true;
            }
        }
        return false;
    }

}
