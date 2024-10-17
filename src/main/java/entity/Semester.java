/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package entity;

import adt.*;



public class Semester {
    private int semesterID;
    private String semesterName;
    private ListInterface<Course> coursesOffered = new ArrayList<>();;
    
    public Semester(int semesterID, String semesterName) {
        this.semesterID = semesterID;
        this.semesterName = semesterName;
        this.coursesOffered = new ArrayList<>();
    }
    

    public int getSemesterID() {
        return semesterID;
    }

    public void setSemesterID(int semesterID) {
        this.semesterID = semesterID;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public ListInterface<Course> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(ListInterface<Course> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }
    
    public void addCourseOffering(Course course) {
        coursesOffered.add(course);
    }
}
