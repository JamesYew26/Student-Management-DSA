/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boundary;

import entity.Student;
import java.util.Scanner;

/**
 *
 * @author blon8
 */
public class TutorialGroupUi {

    private Scanner scanner = new Scanner(System.in);

    public void TutorialGroupMenu() {
        System.out.println("\n********************************************");
        System.out.println("**             Tutorial Group             **");
        System.out.println("********************************************");
        System.out.println("1. Add New Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Edit Student");
        System.out.println("4. Display Student List");
        System.out.println("5. Search Student");
        System.out.println("6. Report");
        System.out.println("7. Sort Courses By Code");
    }

    public int inputStudentID() {
        System.out.println("--------------------------------------------");
        System.out.print("Enter A Student ID To Edit (type -1 to exit) --> ");
        int studentID = scanner.nextInt();
        return studentID;
    }

    public String inputStudentName() {
        System.out.print("Enter Student Name (Anson): ");
        String studentName = scanner.nextLine();
        return studentName;
    }

    public String inputProgramme() {
        System.out.print("Enter Student Programme (RITY1S1): ");
        String programme = scanner.nextLine();
        return programme;
    }

    public String inputTutorialGroup() {
        System.out.print("Enter Tutorial Group ID (RITY1S1G1): ");
        String tutorialGroupID = scanner.nextLine();
        return tutorialGroupID;
    }

    public int inputIntakeDate() {
        System.out.print("Enter Intake Date (202205): ");
        int intakeDate = scanner.nextInt();
        return intakeDate;
    }

    public double inputCGPA() {
        System.out.print("Enter CGPA (4.0): ");
        double CGPA = scanner.nextDouble();
        return CGPA;
    }

    public int chooseOption() {
        System.out.print("Please enter your option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }

    public void printTutorialDetail(Student student) {
        System.out.println("\n--------------------------------------------------------");
        System.out.println("Student ID created --> " + student.getStudentID());
        System.out.println("Student Name created --> " + student.getStudentName());
        System.out.println("Student Programme created --> " + student.getProgrammeID());
        System.out.println("Student Tutorial Group created --> " + student.getTutorialGroupID());
        System.out.println("Student Intake Date created --> " + student.getIntakeDate());
        System.out.println("Student CGPA created --> " + student.getCGPA());
        System.out.println("----------------------------------------------------------");
    }

    public void sortingMenu() {
        System.out.println("\n------------------------------------------");
        System.out.println("What info do you want to Sort?\n"
                + "1: Ascending Student ID\n"
                + "2: Descending Student ID\n"
                + "3: Ascending Student Intake Date\n"
                + "4: Descending Intake Date\n"
                + "5: Ascending Student Intake Date\n"
                + "6: Descending Student CGPA");

    }

    public void deleteMenu() {
        System.out.println("What info do you want to delete?\n"
                + "1: Student\n"
                + "2: Student Tutorial Group");
    }

    public void displayMenu() {
        System.out.println("\nWhat info do you want to display?\n"
                + "1: Student\n"
                + "2: Tutorial Group and quantity of student");
    }

    public void editMenu() {
        System.out.println("\nWhat info do you want to edit?\n"
                + "1: Student Name\n"
                + "2: Student Programme\n"
                + "3: Student Tutorial Group\n"
                + "4: Student Intake Date\n"
                + "5: Student CGPA");
    }

    public void AddStudentTitle() {
        System.out.println("********************************************");
        System.out.println("~~        Add Student To Tutorial Group   ~~");
        System.out.println("********************************************");
    }

    public void studentList() {
        System.out.println("\n**########################################**");
        System.out.println("##               Student List             ##");
        System.out.println("**########################################**");
    }

    public void TutorialGroupTitle() {
        System.out.println("\n*********************************************");
        System.out.println("*  Summary of total tutorial group student  *");
        System.out.println("*********************************************");
    }

    public void Report(int numberOfStudent, int numberOfTutorialGroup, double totalCGPA, double highCGPA) {
        System.out.println("------------------------------------------------");
        System.out.println("Total Of Student :" + numberOfStudent);
        System.out.printf("Total Of Student CGPA : %.2f", totalCGPA);
        System.out.printf("\nAverage Of Student CGPA : %.2f", totalCGPA / numberOfStudent);
        System.out.println("\nThe High CGPA :" + highCGPA);
        System.out.println("Total Of Tutorial Group :" + numberOfTutorialGroup);
        System.out.println("------------------------------------------------");
    }

    public void ascendingIDTitle() {
        System.out.println("********************************************");
        System.out.println("**          Ascending Student ID          **");
        System.out.println("********************************************");
    }

    public void DescendingIDTitle() {
        System.out.println("********************************************");
        System.out.println("**        Descending Student ID           **");
        System.out.println("********************************************");
    }

    public void ascendingDateTitle() {
        System.out.println("********************************************");
        System.out.println("**          Ascending Intake Date         **");
        System.out.println("********************************************");
    }

    public void DescendingDateTitle() {
        System.out.println("********************************************");
        System.out.println("**           Descending Intake Date       **");
        System.out.println("********************************************");
    }

    public void ascendingCGPATitle() {
        System.out.println("********************************************");
        System.out.println("**            Ascending CGPA              **");
        System.out.println("********************************************");
    }

    public void DescendingCGPATitle() {
        System.out.println("********************************************");
        System.out.println("**           Descending CGPA              **");
        System.out.println("********************************************");
    }
}
