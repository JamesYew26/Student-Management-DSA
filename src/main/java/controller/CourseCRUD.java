package controller;

import entity.Course;
import entity.Programme;
import adt.*;
import entity.Semester;
import java.util.Comparator;
import java.util.Scanner;

public class CourseCRUD {

    private ListInterface<Course> courseList = new ArrayList<>();
    private ListInterface<Semester> semesterList = new ArrayList<>();
    private ListInterface<Course> sortedCourseList = new ArrayList<>();
    private ProgrammeCRUD programmeCRUD;
    private ListInterface<Programme> programmeList = new ArrayList<>();
    ;
    private Scanner scanner = new Scanner(System.in);
    private Course course;

    public CourseCRUD() {
        this.programmeCRUD = new ProgrammeCRUD();
        this.programmeList = programmeCRUD.getProgrammeList();
        initializeCourse();
    }

    private void initializeCourse() {
        Course course1 = new Course(102030, "Fundamental Computer Network", 4);
        Course course2 = new Course(102031, "Computer Systems Architecture", 3);
        Course course3 = new Course(102032, "Probability and Statistics", 3);
        Course course4 = new Course(102033, "Mobile Application Development", 4);
        Course course5 = new Course(102034, "GUI and Web Application Programming", 4);

        Semester s1 = new Semester(1, "Fall 2023");
        Semester s2 = new Semester(2, "Spring 2024");
        Semester s3 = new Semester(3, "Winter 2023");

        Programme programmeToAdd = findProgrammeByID("RITY1S1");

        if (programmeToAdd != null) {
            course1.addProgramme(programmeToAdd);
            course2.addProgramme(programmeToAdd);
            course3.addProgramme(programmeToAdd);
            course4.addProgramme(programmeToAdd);
            course5.addProgramme(programmeToAdd);
        }

        s1.addCourseOffering(course1);
        s2.addCourseOffering(course2);
        s1.addCourseOffering(course3);
        s2.addCourseOffering(course4);
        s2.addCourseOffering(course5);

        semesterList.add(s1);
        semesterList.add(s2);
        semesterList.add(s3);
        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        courseList.add(course5);
    }

    public void displaySemesterCourses() {
        System.out.println("********************************************");
        System.out.println("**       View Semester Course Offered     **");
        System.out.println("********************************************");
        System.out.println("Select a semester:");
        for (int i = 1; i <= semesterList.getNumberOfEntries(); i++) {
            Semester semester = semesterList.getEntry(i);
            System.out.println(i + ": " + semester.getSemesterName());
        }

        int semesterChoice = scanner.nextInt();
        scanner.nextLine();

        if (semesterChoice >= 1 && semesterChoice <= semesterList.getNumberOfEntries()) {
            Semester selectedSemester = semesterList.getEntry(semesterChoice);

            ListInterface<Course> coursesOffered = selectedSemester.getCoursesOffered();
            if (!coursesOffered.isEmpty()) {
                System.out.println("Courses offered in " + selectedSemester.getSemesterName() + ":");
                for (int i = 1; i <= coursesOffered.getNumberOfEntries(); i++) {
                    Course course = coursesOffered.getEntry(i);
                    System.out.println("--------------------------");
                    System.out.println("CourseID: " + course.getCourseID());
                    System.out.println("CourseNumber: " + course.getCourseNumber());
                    System.out.println("CourseName: " + course.getCourseName());
                    System.out.println("--------------------------");
                }
            } else {
                System.out.println("No courses offered in " + selectedSemester.getSemesterName());
            }
        } else {
            System.out.println("Invalid semester choice.");
        }
    }

    private void copyCourseListToSortedCourseList() {
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            sortedCourseList.add(courseList.getEntry(i));
        }
    }

    public void sortCoursesByCode() {
        sortedCourseList.clear();
        copyCourseListToSortedCourseList();
        Comparator<Course> courseNumberComparator = Comparator.comparingInt(Course::getCourseNumber);
        sortedCourseList.mergeSort(courseNumberComparator);
        displaySortedCourse();
    }

    public void displaySortedCourse() {
        System.out.println("********************************************");
        System.out.println("**           Sorted Course List           **");
        System.out.println("********************************************");
        for (int i = 1; i <= sortedCourseList.getNumberOfEntries(); i++) {
            System.out.println(sortedCourseList.getEntry(i));
        }
    }

    public void addNewCourse() {
        System.out.println("********************************************");
        System.out.println("**               Add Course                 **");
        System.out.println("********************************************");
        System.out.print("Enter CourseNumber: ");
        int courseNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter CourseName: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter CreditHour: ");
        int creditHour = scanner.nextInt();

        while (detectCourseNumber(courseNumber)) {
            System.out.println("CourseNumber has already been taken,"
                    + " Please try again with another number!!!");
            System.out.print("Enter CourseNumber: ");
            courseNumber = scanner.nextInt();
            scanner.nextLine();
        }

        if (courseList == null) {
            courseList = new ArrayList<>();
        }

        course = new Course(courseNumber, courseName, creditHour);
        courseList.add(course);
        System.out.println("\nSuccessfully added!!!");
        System.out.println("Course ID created --> " + course.getCourseID());

        System.out.println("Select a semester to add the course to:");
        for (int i = 1; i <= semesterList.getNumberOfEntries(); i++) {
            Semester semester = semesterList.getEntry(i);
            System.out.println(i + ": " + semester.getSemesterName());
        }

        int semesterChoice = scanner.nextInt();
        scanner.nextLine();

        if (semesterChoice >= 1 && semesterChoice <= semesterList.getNumberOfEntries()) {
            Semester selectedSemester = semesterList.getEntry(semesterChoice);
            selectedSemester.addCourseOffering(course);
            System.out.println("Course added to " + selectedSemester.getSemesterName() + " successfully.");
        } else {
            System.out.println("Invalid semester choice.");
        }
    }

    public void displayCourse() {
        if (courseList.isEmpty()) {
            System.out.println("Course List is empty!!!");
        } else {
            System.out.println("********************************************");
            System.out.println("**               Course List              **");
            System.out.println("********************************************");
            for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                System.out.println(courseList.getEntry(i));
            }
        }
    }

    public void editCourse() {
        System.out.println("********************************************");
        System.out.println("**               Edit Course              **");
        System.out.println("********************************************");
        displayCourse();

        if (!courseList.isEmpty()) {
            int courseNumber;
            int courseIndex;
            do {
                System.out.print("Enter a CourseNumber to Edit (type -1 to exit) --> ");
                courseNumber = scanner.nextInt();

                if (courseNumber == -1) {
                    return; // Exit the method
                }

                courseIndex = -1;
                for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                    if (courseList.getEntry(i).getCourseNumber() == courseNumber) {
                        courseIndex = i;
                        break;
                    }
                }

                if (courseIndex == -1) {
                    System.out.println("Course not found. Please enter a valid CourseNumber.");
                }
            } while (courseIndex == -1);

            Course foundCourse = courseList.getEntry(courseIndex);
            System.out.println("Course found. Continuing with editing process...\n");
            System.out.println("CourseID: " + foundCourse.getCourseID());
            System.out.println("CourseNumber: " + foundCourse.getCourseNumber());
            System.out.println("CourseName: " + foundCourse.getCourseName());
            System.out.println("CreditHour: " + foundCourse.getCreditHour());

            System.out.println("What info do you want to edit?\n"
                    + "1: CourseNumber\n"
                    + "2: CourseName\n"
                    + "3: CreditHour");

            int option;
            do {
                System.out.print("Please enter your option: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Enter CourseNumber: ");
                        int courseNum = scanner.nextInt();
                        scanner.nextLine();

                        while (detectCourseNumber(courseNum)) {
                            System.out.println("CourseNumber has already been taken. Please try again with another number.");
                            System.out.print("Enter CourseNumber: ");
                            courseNum = scanner.nextInt();
                            scanner.nextLine();
                        }
                        Course editedCourse = new Course(courseNum, foundCourse.getCourseName(), foundCourse.getCreditHour());
                        courseList.replace(courseIndex, editedCourse);
                        break;
                    case 2:
                        System.out.print("Enter CourseName: ");
                        String courseName = scanner.nextLine();

                        while (detectCourseName(courseName)) {
                            System.out.println("Course Name has already been taken. Please try again with another name.");
                            System.out.print("Enter CourseName: ");
                            courseName = scanner.nextLine();
                        }
                        courseList.getEntry(courseIndex).setCourseName(courseName);
                        break;
                    case 3:
                        System.out.print("Enter CreditHour: ");
                        int creditHour = scanner.nextInt();
                        scanner.nextLine();
                        courseList.getEntry(courseIndex).setCreditHour(creditHour);
                        break;
                    default:
                        System.out.print("Please choose between 1 to 3.\n");
                        break;
                }
            } while (option < 1 || option > 3);

            System.out.println("Successfully edited!");
        }
    }

    public void searchCourses() {
        System.out.println("********************************************");
        System.out.println("**               Search Course            **");
        System.out.println("********************************************");
        if (!courseList.isEmpty()) {
            int courseNumber;
            int courseIndex;
            do {
                System.out.print("Enter a CourseNumber to remove (type -1 to exit) --> ");
                courseNumber = scanner.nextInt();

                if (courseNumber == -1) {
                    return;
                }

                courseIndex = -1;
                for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                    if (courseList.getEntry(i).getCourseNumber() == courseNumber) {
                        courseIndex = i;
                        break;
                    }
                }

                if (courseIndex == -1) {
                    System.out.println("Course not found. Please enter a valid CourseNumber.");
                }
            } while (courseIndex == -1);

            Course foundCourse = courseList.getEntry(courseIndex);
            System.out.println("CourseID: " + foundCourse.getCourseID());
            System.out.println("CourseNumber: " + foundCourse.getCourseNumber());
            System.out.println("CourseName: " + foundCourse.getCourseName());
            System.out.println("CreditHour: " + foundCourse.getCreditHour());
        } else {
            System.out.println("Course not found.");
        }
    }

    public void removeCourse() {
        if (!courseList.isEmpty()) {
            int courseNumber;
            int courseIndex;
            System.out.println("********************************************");
            System.out.println("**               Remove Course            **");
            System.out.println("********************************************");
            displayCourse();

            do {
                System.out.print("Enter a CourseNumber to remove (type -1 to exit) --> ");
                courseNumber = scanner.nextInt();

                if (courseNumber == -1) {
                    return;
                }

                courseIndex = -1;
                for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                    if (courseList.getEntry(i).getCourseNumber() == courseNumber) {
                        courseIndex = i;
                        break;
                    }
                }
                if (courseIndex == -1) {
                    System.out.println("Course not found. Please enter a valid CourseNumber.");
                }
            } while (courseIndex == -1);

            Course foundCourse = courseList.getEntry(courseIndex);
            courseList.remove(courseIndex);

            for (int i = 1; i <= semesterList.getNumberOfEntries(); i++) {
                Semester semester = semesterList.getEntry(i);
                ListInterface<Course> coursesOffered = semester.getCoursesOffered();

                for (int j = 1; j <= coursesOffered.getNumberOfEntries(); j++) {
                    Course courseInSemester = coursesOffered.getEntry(j);

                    if (courseInSemester.getCourseNumber() == foundCourse.getCourseNumber()) {
                        coursesOffered.remove(j);
                        break;
                    }
                }
            }
            System.out.println("Course removed successfully");
        } else {
            System.out.println("No courses to remove.");
        }
    }

    public void courseReport() {
        System.out.println("********************************************");
        System.out.println("**  Course Report Summary of Credit Hours **");
        System.out.println("********************************************");

        int totalCourses = courseList.getNumberOfEntries();
        System.out.println("Total Number of Courses: " + totalCourses);
        System.out.println();

        int[] creditHourDistribution = new int[7];
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            Course course = courseList.getEntry(i);
            int creditHour = course.getCreditHour();

            if (creditHour >= 1 && creditHour <= 6) {
                creditHourDistribution[creditHour - 1]++;
            } else {
                creditHourDistribution[6]++;
            }
        }

        System.out.println("Course Distribution by Credit Hours:");
        for (int i = 0; i < 6; i++) {
            int lowerBound = i + 1;
            int upperBound = i + 2;
            System.out.printf("%d-%d credits: %d%n", lowerBound, upperBound, creditHourDistribution[i]);
        }
        System.out.println("6+ credits: " + creditHourDistribution[6]);

        System.out.println();
        System.out.println("********************************************");
        System.out.println("**           End of Course Report         **");
        System.out.println("********************************************");
    }

    public boolean detectCourseNumber(int courseNumber) {
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            if (courseList.getEntry(i).getCourseNumber() == courseNumber) {
                return true;
            }
        }
        return false;
    }

    public boolean detectCourseName(String targetCourseName) {
        for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
            String courseName = courseList.getEntry(i).getCourseName();
            if (courseName.equals(targetCourseName)) {
                return true;
            }
        }
        return false;
    }

    public void addProgrammeToCourse() {
        System.out.println("********************************************");
        System.out.println("**       Add Course to Programme          **");
        System.out.println("********************************************");
        displayCourse();

        if (!courseList.isEmpty()) {
            System.out.print("Enter the CourseNumber of the course to which you want to add a programme: ");
            int courseNumber = scanner.nextInt();
            scanner.nextLine();

            Course targetCourse = null;

            for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                if (courseList.getEntry(i).getCourseNumber() == courseNumber) {
                    targetCourse = courseList.getEntry(i);
                    break;
                }
            }

            if (targetCourse != null) {
                displayProgrammes();
                System.out.print("Enter the ProgrammeID of the programme to add: ");
                String programmeID = scanner.nextLine();

                Programme programmeToAdd = findProgrammeByID(programmeID);

                if (programmeToAdd != null) {
                    if (!targetCourse.hasProgramme(programmeToAdd)) {
                        targetCourse.addProgramme(programmeToAdd);
                        System.out.println("Programme added to the course successfully.");
                    } else {
                        System.out.println("The programme already taken the course.");
                    }
                } else {
                    System.out.println("Programme not found.");
                }
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("No courses available.");
        }
    }

    public void removeProgrammeFromCourse() {
        System.out.println("********************************************");
        System.out.println("**    Remove Course Taken by Programme    **");
        System.out.println("********************************************");
        displayCourse();

        if (!courseList.isEmpty()) {
            System.out.print("Enter the CourseNumber of the course from which you want to remove a programme: ");
            int courseNumber = scanner.nextInt();
            scanner.nextLine();

            Course targetCourse = null;

            for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                if (courseList.getEntry(i).getCourseNumber() == courseNumber) {
                    targetCourse = courseList.getEntry(i);
                    break;
                }
            }

            if (targetCourse != null) {
                ListInterface<Programme> associatedProgrammes = targetCourse.getAssociatedProgrammes();

                if (associatedProgrammes.isEmpty()) {
                    System.out.println("This course doesn't have any programmes taken.");
                } else {
                    displayAssociatedProgrammes(targetCourse);
                    System.out.print("Enter the ProgrammeID of the programme to remove: ");
                    String programmeID = scanner.nextLine();

                    Programme programmeToRemove = findProgrammeByID(programmeID);

                    if (programmeToRemove != null) {
                        targetCourse.removeProgramme(programmeToRemove);
                        System.out.println("Programme removed from the course successfully.");
                    } else {
                        System.out.println("Programme not found.");
                    }
                }
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("No courses available.");
        }
    }

    public void displayCoursesByProgramme() {
        System.out.println("*********************************************");
        System.out.println("** Display Programme What Course They Have **");
        System.out.println("*********************************************");

        if (!programmeList.isEmpty()) {
            displayProgrammes();
            System.out.print("Enter the ProgrammeID to display courses of the programme taken: ");
            String programmeID = scanner.nextLine();

            Programme selectedProgramme = findProgrammeByID(programmeID);

            if (selectedProgramme != null) {
                System.out.println("Courses taken by " + selectedProgramme.getProgrammeName() + ":");

                for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                    Course course = courseList.getEntry(i);
                    if (course.hasProgramme(selectedProgramme)) {
                        System.out.println("--------------------------");
                        System.out.println("CourseID: " + course.getCourseID());
                        System.out.println("CourseNumber: " + course.getCourseNumber());
                        System.out.println("CourseName: " + course.getCourseName());
                        System.out.println("CreditHour: " + course.getCreditHour());
                        System.out.println("--------------------------");
                    }
                }
            } else {
                System.out.println("Programme not found.");
            }
        } else {
            System.out.println("No programmes available.");
        }
    }

    public void displayProgrammeTakenCourse() {
        System.out.println("********************************************");
        System.out.println("**    Display Programme taken Course     **");
        System.out.println("********************************************");
        displayCourse();

        if (!courseList.isEmpty()) {
            System.out.print("Enter the CourseNumber to check which Programme has taken the Course: ");
            int courseNumber = scanner.nextInt();
            scanner.nextLine();

            Course targetCourse = null;

            for (int i = 1; i <= courseList.getNumberOfEntries(); i++) {
                if (courseList.getEntry(i).getCourseNumber() == courseNumber) {
                    targetCourse = courseList.getEntry(i);
                    break;
                }
            }
            if (targetCourse != null) {
                displayAssociatedProgrammes(targetCourse);
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("No courses available.");
        }
    }

    private Programme findProgrammeByID(String programmeID) {
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme programme = programmeList.getEntry(i);
            if (programme.getProgrammeID().equals(programmeID)) {
                return programme;
            }
        }
        return null;
    }

    private void displayProgrammes() {
        System.out.println("List of Programmes:");
        for (int i = 1; i <= programmeList.getNumberOfEntries(); i++) {
            Programme programme = programmeList.getEntry(i);
            System.out.println(programme.getProgrammeID() + ": " + programme.getProgrammeName());
        }
    }

    private void displayAssociatedProgrammes(Course course) {
        ListInterface<Programme> associatedProgrammes = course.getAssociatedProgrammes();
        System.out.println("Associated Programmes for Course " + course.getCourseNumber() + ":");
        for (int i = 1; i <= associatedProgrammes.getNumberOfEntries(); i++) {
            Programme programme = associatedProgrammes.getEntry(i);
            System.out.println(programme.getProgrammeID() + ": " + programme.getProgrammeName());
        }
    }
}
