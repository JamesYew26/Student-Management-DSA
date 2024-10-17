package boundary;
import controller.Tutor;
import java.util.Scanner;

/**
 *
 * @author jamesyew
 */
public class TutorMenu {
    public void TutorMenu() {

        Tutor tutor = new Tutor();
        Scanner input = new Scanner(System.in);
        char repeat = ' ';

        do {

            do {
                System.out.println("********************************************");
                System.out.println("**                 Tutor                  **");
                System.out.println("********************************************");
                System.out.println("1. Add tutor");
                System.out.println("2. Remove tutor");
                System.out.println("3. Search tutor");
                System.out.println("4. Edit tutor details");
                System.out.println("5. Display tutors");
                System.out.println("6. Sort tutors");
                System.out.println("7. Generate report");
                System.out.print("Please enter your option: ");
                int Option;
                do {
                    Option = input.nextInt();
                    switch (Option) {
                        case 1:
                            tutor.add();
                            break;
                        case 2:
                            tutor.remove();
                            break;
                        case 3:
                            tutor.search();
                            break;
                        case 4:
                            tutor.update();
                            break;
                        case 5:
                            tutor.display();
                            break;
                        case 6:
                            tutor.filter();
                            break;
                        case 7:
                            tutor.generateReport();
                            break;
                        default:
                            System.out.println("Please choose number between 1 to 7");
                            break;
                    }
                } while (Option > 7);
                System.out.println("Continue to tutor's page? (Y/N)");
                repeat = input.next().charAt(0);
            } while (repeat == 'y' || repeat == 'Y');
            if (repeat == 'n' || repeat == 'N') {
                System.out.print("Thank You!");
            }

        } while (repeat == 'y' || repeat == 'Y');
    }
}