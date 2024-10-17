package entity;

import adt.*;

public class Course {

    private static int nextCourseID = 100000;
    private int courseID;
    private int courseNumber;
    private String courseName;
    private int creditHour;
    private ListInterface<Programme> associatedProgrammes = new ArrayList<>();

    public Course() {

    }

    public Course(int courseNumber, String courseName, int creditHour) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.creditHour = creditHour;
        this.courseID = nextCourseID++;
        this.associatedProgrammes = new ArrayList<>();
    }

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }
    
    public static int getNextCourseID() {
        return nextCourseID;
    }

    public static void setNextCourseID(int nextCourseID) {
        Course.nextCourseID = nextCourseID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ListInterface<Programme> getAssociatedProgrammes() {
        return associatedProgrammes;
    }

    public void setAssociatedProgrammes(ListInterface<Programme> associatedProgrammes) {
        this.associatedProgrammes = associatedProgrammes;
    }

    public void addProgramme(Programme programme) {
        associatedProgrammes.add(programme);
    }

    public void removeProgramme(Programme programme) {
        for (int i = 1; i <= associatedProgrammes.getNumberOfEntries(); i++) {
            if (associatedProgrammes.getEntry(i).equals(programme)) {
                associatedProgrammes.remove(i);
                break; // Remove only one instance
            }
        }
    }

    public boolean hasProgramme(Programme programme) {
        for (int i = 1; i <= associatedProgrammes.getNumberOfEntries(); i++) {
            if (associatedProgrammes.getEntry(i).equals(programme)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "========================================\t " + "\nCourseID\t: " + courseID + "\nCourseNumber\t: " + courseNumber
                + "\nCourseName\t: " + courseName + "\nCreditHour\t: " + creditHour + " hours";
    }
}