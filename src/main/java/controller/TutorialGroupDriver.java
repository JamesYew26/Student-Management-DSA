/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import entity.Programme;
import boundary.TutorialGroupUi;
import adt.*;
import entity.*;
import controller.ProgrammeCRUD;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author blon8
 */
public class TutorialGroupDriver {
    private ListInterface<Student> studentList = new ArrayList<>();
    private ListInterface<Student> sortedStudentList = new ArrayList<>();
    private ListInterface<TutorialGroup> tutorialGroup = new ArrayList<>();
    private ProgrammeCRUD programmeCRUD;
    private ListInterface<Programme> programmeList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private TutorialGroupUi tutorialUi = new TutorialGroupUi();
    private TutorialGroup tutorialGroupList;

    public TutorialGroupDriver() {
        initializeTutorialGroup();
        char repeat = ' ';
        do {
            tutorialUi.TutorialGroupMenu();
            int Option;
            do {
                Option = tutorialUi.chooseOption();
                switch (Option) {
                    case 1:
                        addNewTutorialGroup();
                        break;
                    case 2:
                        removeTutorialGroup();
                        break;
                    case 3:
                        editTutorialGroup();
                        break;
                    case 4:
                        showTutorialGroup();
                        break;
                    case 5:
                        searchTutorialGroup();
                        break;
                    case 6:
                        tutorialGroupReport();
                        break;
                    case 7:
                        sortingTutorialGroup();
                        break;
                    default:
                        System.out.println("Please choose number between 1 to 7");
                        break;
                }
            } while (Option > 7);
            System.out.print("Continue to Tutorial Group Page? (Y/N) ");
            repeat = scanner.next().charAt(0);
        } while (repeat == 'y' || repeat == 'Y');

    }

    private void initializeTutorialGroup() {
        this.programmeCRUD = new ProgrammeCRUD();
        this.programmeList = programmeCRUD.getProgrammeList();

        tutorialGroup.add(new TutorialGroup("RITY1S1G1", 10));
        tutorialGroup.add(new TutorialGroup("RITY1S1G2", 12));
        tutorialGroup.add(new TutorialGroup("RITY1S2G1", 10));
        tutorialGroup.add(new TutorialGroup("RITY1S2G2", 19));
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

        studentList.add(new Student("Ali", "RITY1S1", "RITY1S1G1", 202305, 4.0));
        studentList.add(new Student("Abu", "RITY1S1", "RITY1S1G1", 202205, 2.5));
        studentList.add(new Student("Anson", "RITY1S2", "RITY1S2G2", 202205, 3.0));
        studentList.add(new Student("Wei Lun", "RSDY1S1", "RSDY1S1G2", 202105, 3.2));
        studentList.add(new Student("James", "RSDY1S2", "RSDY1S2G1", 202105, 3.4));

    }

    public void addNewTutorialGroup() {
        tutorialUi.AddStudentTitle();
        if (studentList == null) {
            studentList = new ArrayList<>();
        }

        String studentName = tutorialUi.inputStudentName();
        String programme = tutorialUi.inputProgramme();
        String tutorialGroupID = tutorialUi.inputTutorialGroup();
        int intakeDate = tutorialUi.inputIntakeDate();
        double CGPA = tutorialUi.inputCGPA();

        studentList.add(new Student(studentName, programme, tutorialGroupID, intakeDate, CGPA));
        int studentIndex = 0;

        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
            if (studentList.getEntry(i).getStudentName() == studentName) {
                studentIndex = i;
                if (tutorialGroup.getEntry(i).getTutorialGroupID().equalsIgnoreCase(tutorialGroupID)) {
                    tutorialGroup.getEntry(i).setMemberOfNumber(tutorialGroup.getEntry(i).getMemberOfNumber() + 1);
                    break;
                }
            }
        }

        Student foundStudent = studentList.getEntry(studentIndex);
        System.out.println("\nSuccessfully added");
        tutorialUi.printTutorialDetail(foundStudent);
    }

    public void displayTutorialGroup() {
        if (studentList.isEmpty()) {
            System.out.println("----Student List Is Not Have Student Record----");
        } else {
            tutorialUi.studentList();
            for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                System.out.println(studentList.getEntry(i));
            }
        }
    }

    public void displayTutorialGroupAndStudent() {

        if (studentList.isEmpty()) {
            System.out.println("----toturial group Is Not Have Student Record----");
        } else {
            System.out.println("");
            for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {
                if (tutorialGroup.getEntry(i).getMemberOfNumber() != 0) {
                    System.out.println(tutorialGroup.getEntry(i));
                }
            }
        }
    }

    public void showTutorialGroup() {
        tutorialUi.displayMenu();
        int option;
        do {
            option = tutorialUi.chooseOption();

            switch (option) {
                case 1:
                    displayTutorialGroup();
                    break;

                case 2:
                    displayTutorialGroupAndStudent();
                    break;

                default:
                    System.out.print("Please choose between 1 and 2.\n");
                    break;
            }

        } while (option < 1 || option > 2);

    }

    public void editTutorialGroup() {
        displayTutorialGroup();

        if (!studentList.isEmpty()) {
            int studentID;
            int studentIndex;
            do {
                studentID = tutorialUi.inputStudentID();

                if (studentID == -1) {
                    return; // Exit the method
                }

                studentIndex = -1;
                for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                    if (studentList.getEntry(i).getStudentID() == studentID) {
                        studentIndex = i;
                        break;
                    }
                }

                if (studentIndex == -1) {
                    System.out.println("Student not found. Please enter a valid Student ID.");
                }

            } while (studentIndex == -1);

            Student foundStudent = studentList.getEntry(studentIndex);

            System.out.println("\nThis is student information found in system.");
            tutorialUi.printTutorialDetail(foundStudent);

            tutorialUi.editMenu();

            int option;
            do {
                option = tutorialUi.chooseOption();
                switch (option) {
                    case 1:
                        String studentName = tutorialUi.inputStudentName();

                        studentList.getEntry(studentIndex).setStudentName(studentName);
                        break;

                    case 2:
                        String Programme = tutorialUi.inputProgramme();

                        while (detectStudentProgramme(Programme)) {
                            System.out.println("This Programme Is Not Existing. Please Try again Other Programme ID.");
                            Programme = tutorialUi.inputProgramme();
                        }

                        studentList.getEntry(studentIndex).setProgrammeID(Programme);
                        break;

                    case 3:
                        String tutorialGroupID = tutorialUi.inputTutorialGroup();

                        while (detectStudentTutorialGroup(tutorialGroupID)) {
                            System.out.println("This Tutorial Group Is Not Existing. Please Try again Other Tutorial Group ID.");
                            tutorialGroupID = tutorialUi.inputTutorialGroup();
                        }

                        for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {

                            if (tutorialGroup.getEntry(i).getTutorialGroupID().equalsIgnoreCase(foundStudent.getTutorialGroupID())) {
                                tutorialGroup.getEntry(i).setMemberOfNumber(tutorialGroup.getEntry(i).getMemberOfNumber() - 1);
                            }

                            if (tutorialGroup.getEntry(i).getTutorialGroupID().equalsIgnoreCase(tutorialGroupID)) {
                                tutorialGroup.getEntry(i).setMemberOfNumber(tutorialGroup.getEntry(i).getMemberOfNumber() + 1);
                            }

                        }

                        studentList.getEntry(studentIndex).setTutorialGroupID(tutorialGroupID);
                        break;

                    case 4:
                        int IntakeDate = tutorialUi.inputIntakeDate();

                        studentList.getEntry(studentIndex).setIntakeDate(IntakeDate);
                        break;

                    case 5:
                        double CGPA = 0;
                        do {
                            CGPA = tutorialUi.inputCGPA();
                        } while (CGPA >= 4.0 && CGPA <= 0.0);

                        studentList.getEntry(studentIndex).setCGPA(CGPA);
                        break;

                    default:
                        System.out.print("Please choose between 1 and 5.\n");
                        break;
                }
            } while (option < 1 || option > 5);

            System.out.println("\nThis Is The Data That You Edited.");
            tutorialUi.printTutorialDetail(foundStudent);
        }
    }

    public void searchTutorialGroup() {
        if (!studentList.isEmpty()) {
            int studentID;
            int studentIndex;
            do {
                studentID = tutorialUi.inputStudentID();

                if (studentID == -1) {
                    return; // Exit the method
                }

                studentIndex = -1;
                for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                    if (studentList.getEntry(i).getStudentID() == studentID) {
                        studentIndex = i;
                        break;
                    }
                }

                if (studentIndex == -1) {
                    System.out.println("Student not found. Please enter a valid Student ID.");
                }
            } while (studentIndex == -1);

            Student foundStudent = studentList.getEntry(studentIndex);
            tutorialUi.printTutorialDetail(foundStudent);
        } else {
            System.out.println("Student not found.\n");
        }
    }

    public void removeTutorialGroup() {
        if (!studentList.isEmpty()) {
            int studentID;
            int studentIndex = 0;

            displayTutorialGroup();

            do {
                studentID = tutorialUi.inputStudentID();

                if (studentID == -1) {
                    return; // Exit the method
                }

                for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                    if (studentList.getEntry(i).getStudentID() == studentID) {
                        studentIndex = i;
                        break;
                    }
                }
            } while (studentID == -1);

            Student foundStudent = studentList.getEntry(studentIndex);

            tutorialUi.deleteMenu();
            int option;
            do {
                option = tutorialUi.chooseOption();

                switch (option) {
                    case 1:
                        studentList.remove(studentIndex);
                        System.out.println("Delete Successfully.");
                        displayTutorialGroup();
                        break;

                    case 2:
                        for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {
                            if (tutorialGroup.getEntry(i).getTutorialGroupID().equalsIgnoreCase(foundStudent.getTutorialGroupID())) {
                                tutorialGroup.getEntry(i).setMemberOfNumber(tutorialGroup.getEntry(i).getMemberOfNumber() - 1);
                            }
                        }
                        studentList.getEntry(studentIndex).setTutorialGroupID(null);
                        System.out.println("Delete Successfully.");
                        System.out.println("The student tutorial Group will assign to empty toturial group");
                        displayTutorialGroup();
                        break;

                    default:
                        System.out.print("Please choose between 1 and 2.\n");
                        break;
                }

                if (studentID == -1) {
                    System.out.println("Student Tutorial Group not found. Please enter again.");
                }
            } while (option < 1 || option > 2);

            System.out.println("Student Tutorial Group removed successfully");
        } else {
            System.out.println("No Student Tutorial Group to remove.");
        }
    }

    public void tutorialGroupReport() {
        tutorialUi.TutorialGroupTitle();

        int numberOfStudent = 0;
        int numberOfTutorialGroup = 0;
        double totalCGPA = 0.0, highCGPA = 0.0;

        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
            if (studentList.getEntry(i).getCGPA() != 0) {
                totalCGPA += studentList.getEntry(i).getCGPA();
                if (highCGPA <= studentList.getEntry(i).getCGPA()) {
                    highCGPA = studentList.getEntry(i).getCGPA();
                }
            }
        }

        for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {
            if (tutorialGroup.getEntry(i).getMemberOfNumber() != 0) {
                numberOfStudent += tutorialGroup.getEntry(i).getMemberOfNumber();
                numberOfTutorialGroup++;
            }
        }
        tutorialUi.Report(numberOfStudent, numberOfTutorialGroup, totalCGPA, highCGPA);

    }

    public void sortingTutorialGroup() {

        tutorialUi.sortingMenu();

        int option;
        do {
            option = tutorialUi.chooseOption();

            switch (option) {
                case 1:
                    tutorialUi.ascendingIDTitle();

                    sortedStudentList.clear();
                    for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                        sortedStudentList.add(studentList.getEntry(i));
                    }
                    Comparator<Student> studentIDComparator = Comparator.comparingInt(Student::getStudentID);
                    sortedStudentList.mergeSort(studentIDComparator);

                    for (int i = 1; i <= sortedStudentList.getNumberOfEntries(); i++) {
                        System.out.println(sortedStudentList.getEntry(i));
                    }
                    break;

                case 2:
                    tutorialUi.DescendingIDTitle();

                    sortedStudentList.clear();
                    for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                        sortedStudentList.add(studentList.getEntry(i));
                    }
                    Comparator<Student> studentIDReverseComparator = Comparator.comparingInt(Student::getStudentID);
                    sortedStudentList.mergeSort(studentIDReverseComparator);

                    for (int i = sortedStudentList.getNumberOfEntries(); i >= 1; i--) {
                        System.out.println(sortedStudentList.getEntry(i));
                    }
                    break;

                case 3:
                    tutorialUi.ascendingDateTitle();

                    sortedStudentList.clear();
                    for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                        sortedStudentList.add(studentList.getEntry(i));
                    }
                    Comparator<Student> studentDateComparator = Comparator.comparingInt(Student::getStudentID);
                    sortedStudentList.mergeSort(studentDateComparator);

                    for (int i = 1; i <= sortedStudentList.getNumberOfEntries(); i++) {
                        System.out.println(sortedStudentList.getEntry(i));
                    }
                    break;

                case 4:
                    tutorialUi.DescendingDateTitle();

                    sortedStudentList.clear();
                    for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                        sortedStudentList.add(studentList.getEntry(i));
                    }
                    Comparator<Student> studentDateReverseComparator = Comparator.comparingInt(Student::getStudentID);
                    sortedStudentList.mergeSort(studentDateReverseComparator);

                    for (int i = sortedStudentList.getNumberOfEntries(); i >= 1; i--) {
                        System.out.println(sortedStudentList.getEntry(i));
                    }
                    break;

                case 5:
                    tutorialUi.ascendingCGPATitle();

                    sortedStudentList.clear();
                    for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                        sortedStudentList.add(studentList.getEntry(i));
                    }
                    Comparator<Student> studentCGPAComparator = Comparator.comparingDouble(Student::getCGPA);
                    sortedStudentList.mergeSort(studentCGPAComparator);

                    for (int i = 1; i <= sortedStudentList.getNumberOfEntries(); i++) {
                        System.out.println(sortedStudentList.getEntry(i));
                    }
                    break;
                case 6:
                    tutorialUi.DescendingCGPATitle();

                    sortedStudentList.clear();
                    for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
                        sortedStudentList.add(studentList.getEntry(i));
                    }
                    Comparator<Student> studentCGPAReserveComparator = Comparator.comparingDouble(Student::getCGPA);
                    sortedStudentList.mergeSort(studentCGPAReserveComparator);

                    for (int i = sortedStudentList.getNumberOfEntries(); i >= 1; i--) {
                        System.out.println(sortedStudentList.getEntry(i));
                    }
                    break;

                default:
                    System.out.print("Please choose between 1 and 6.\n");
                    break;

            }

        } while (option < 1 || option > 6);
    }

    public boolean detectStudentID(int studentID) {
        for (int i = 1; i <= studentList.getNumberOfEntries(); i++) {
            if (studentList.getEntry(i).getStudentID() == studentID) {
                return true;
            }
        }
        return false;
    }

    public boolean detectStudentTutorialGroup(String tutorialGroupID) {
        for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {
            if (!tutorialGroup.getEntry(i).getTutorialGroupID().equalsIgnoreCase(tutorialGroupID)) {
                return false;
            }
        }
        return true;
    }

    public boolean detectStudentProgramme(String Programme) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            if (!programmeList.getEntry(i).getProgrammeID().equalsIgnoreCase(Programme)) {
                return false;
            }
        }
        return true;
    }
}
