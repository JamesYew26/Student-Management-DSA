package boundary;

import controller.CourseCRUD;
import java.util.Scanner;

public class CourseMenu {

    public void CourseMenu() {

        CourseCRUD course = new CourseCRUD();
        Scanner scanner = new Scanner(System.in);
        char repeat = ' ';
        
        do {

                        do {
                            System.out.println("********************************************");
                            System.out.println("**                 Course                  **");
                            System.out.println("********************************************");
                            System.out.println("1. Add New Course");
                            System.out.println("2. Remove Course");
                            System.out.println("3. Edit Course Detail");
                            System.out.println("4. Display Course List");
                            System.out.println("5. Search Course");
                            System.out.println("6. Offered Semester Course");
                            System.out.println("7. Sort Courses By Code");
                            System.out.println("8. Add Programme To Course");
                            System.out.println("9. Remove Programme From Course");
                            System.out.println("10.Display Course Taken By Programmes");
                            System.out.println("11.Display Programme Of What Course They Have");
                            System.out.println("12.Report\n");
                            System.out.print("Please enter your option: ");
                            int Option;
                            do {
                                Option = scanner.nextInt();
                                switch (Option) {
                                    case 1:
                                        course.addNewCourse();
                                        break;
                                    case 2:
                                        course.removeCourse();
                                        break;
                                    case 3:
                                        course.editCourse();
                                        break;
                                    case 4:
                                        course.displayCourse();
                                        break;
                                    case 5:
                                        course.searchCourses();
                                        break;
                                    case 6:
                                        course.displaySemesterCourses();
                                        break;
                                    case 7:
                                        course.sortCoursesByCode();
                                        break;
                                    case 8:
                                        course.addProgrammeToCourse();
                                        break;
                                    case 9:
                                        course.removeProgrammeFromCourse();
                                        break;
                                    case 10:
                                        course.displayProgrammeTakenCourse();
                                        break;
                                    case 11:
                                        course.displayCoursesByProgramme();
                                        break;
                                    case 12:
                                        course.courseReport();
                                        break;
                                    default:
                                        System.out.println("Please choose number between 1 to 12!!");
                                        break;
                                }
                            } while (Option > 12);
                            System.out.println("Continue to Course Page? (Y/N)");
                            repeat = scanner.next().charAt(0);
                        } while (repeat == 'y' || repeat == 'Y');
                        if (repeat == 'n' || repeat == 'N') {
                            System.out.print("Thank You!");
                        }

        } while (repeat == 'y' || repeat == 'Y');
    }
}
