/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.*;

/**
 *
 * @author blon8
 */
public class Student {
    private static int nextStudentID = 20000;
    private int studentID;
    private int intakeDate;
    private String studentName;
    private double CGPA;
    
    private String tutorialGroupID;
    private String programmeID;
    
    public Student() {

    }

    public Student(String studentName, String programmeID, String tutorialGroupID, int intakeDate, double CGPA) {
        this.studentName = studentName;
        this.programmeID = programmeID;
        this.tutorialGroupID = tutorialGroupID;
        this.intakeDate = intakeDate;
        this.CGPA = CGPA;
        this.studentID = nextStudentID++;
    }

    public Student(String studentName, String programmeID, String tutorialGroupID, int intakeDate, double CGPA, ListInterface<Student> studentList) {
        this.studentName = studentName;
        this.programmeID = programmeID;
        this.intakeDate = intakeDate;
        this.tutorialGroupID = tutorialGroupID;
        this.CGPA = CGPA;
        this.studentID = nextStudentID++;
    }

    public String getProgrammeID() {
        return programmeID;
    }

    public void setProgrammeID(String programmeID) {
        this.programmeID = programmeID;
    }

    public String getTutorialGroupID() {
        return tutorialGroupID;
    }

    public void setTutorialGroupID(String tutorialGroupID) {
        this.tutorialGroupID = tutorialGroupID;
    }

    public static int getNextStudentID() {
        return nextStudentID;
    }

    public static void setNextStudentID(int nextStudentID) {
        Student.nextStudentID = nextStudentID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public int getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(int intakeDate) {
        this.intakeDate = intakeDate;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    @Override
    public String toString() {
        return "-------------------------------------\nStudentID\t:" + studentID + "\nStudentName\t:" + studentName + "\nintakeDate\t:" + intakeDate + "\nCGPA\t\t:" + CGPA 
                + "\nTutorial Group\t:" + tutorialGroupID + "\nProgram         :" + programmeID ;
    }

}
