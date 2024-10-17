package boundary;

import controller.ProgrammeCRUD;
import java.util.Scanner;

public class ProgrammeMenu {

    public ProgrammeMenu() {
        ProgrammeCRUD programme = new ProgrammeCRUD();
        Scanner scanner = new Scanner(System.in);
        char repeatProgrammePage = ' ';
        do {
            System.out.println("********************************************");
            System.out.println("**                Programme               **");
            System.out.println("********************************************");
            System.out.println("1. Add New Programme");
            System.out.println("2. Remove Programme");
            System.out.println("3. Edit Programme Detail");
            System.out.println("4. Display Programme List");
            System.out.println("5. Search Programme");
            System.out.println("6. Add tutorial group to programme");
            System.out.println("7. Remove tutorial group to programme");
            System.out.println("8. List all tutorial groups in a programme");
            System.out.println("9. View Programme Report");
            System.out.print("Please Re-enter your option (1-9 only): ");
            int programmeOption;
            do {
                programmeOption = scanner.nextInt();
                switch (programmeOption) {
                    case 1:
                        programme.addProgramme();
                        break;
                    case 2:
                        programme.removeProgramme();
                        break;
                    case 3:
                        programme.editProgramme();
                        break;
                    case 4:
                        programme.displayProgramme();
                        break;
                    case 5:
                        programme.searchProgramme();
                        break;
                    case 6:
                        programme.addTutorialToProgramme();
                        break;
                    case 7:
                        programme.removeTutorialToProgramme();
                        break;
                    case 8:
                        programme.ListAllTgInprogramme();
                        break;
                    case 9:
                        programme.viewReport();
                        break;                       
                    default:
                        System.out.println("\nPlease choose the option between 1 and 9 ONLY!\n");
                        System.out.println("********************************************");
                        System.out.println("**                Programme               **");
                        System.out.println("********************************************");
                        System.out.println("1. Add New Programme");
                        System.out.println("2. Remove Programme");
                        System.out.println("3. Edit Programme Detail");
                        System.out.println("4. Display Programme List");
                        System.out.println("5. Search Programme");
                        System.out.println("6. Add tutorial group to programme");
                        System.out.println("7. Remove tutorial group to programme");
                        System.out.println("8. List all tutorial groups for programme");
                        System.out.println("9. View Programme Report");
                        System.out.print("Please Re-enter your option (1-9 only): ");
                        break;
                }
            } while (programmeOption < 1 || programmeOption > 9);
            System.out.println("Continue to Programme Page? (Y/N)");
            repeatProgrammePage = scanner.next().charAt(0);
        } while (repeatProgrammePage == 'y' || repeatProgrammePage == 'Y');
    }

    public static void main(String[] args) {
        new ProgrammeMenu();
    }
}
