/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import adt.ListInterface;

/**
 *
 * @author jamesyew
 */
public class Tutors {
    private int tutorID;
    private String tutorName;
    private String tutorSubject;
    private int tutorExperience;
    private boolean tutorStatus;
    
    public Tutors(){
        
    }
    
    public Tutors(int id, String name, boolean status, String subject, int experience) {
        this.tutorID = id;
        this.tutorName = name;
        this.tutorStatus = status;
        this.tutorSubject = subject;
        this.tutorExperience = experience;
        
    }
    
    //Tutor ID
    public int getTutorID() {
        return tutorID;
    }

    public void setTutorID(int tutorIdSetID) {
        this.tutorID = tutorIdSetID;
    }

    //Tutor Name
    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorNameSetName) {
        this.tutorName = tutorNameSetName;
    }

    //Tutor Status
    public boolean getTutorStatus() {
        return tutorStatus;
    }

    public void setTutorStatus(boolean tutorStatusSetStatus) {
        this.tutorStatus = tutorStatusSetStatus;
    }
    
    //Tutor Experience
    public int getTutorExperience() {
        return tutorExperience;
    }

    public void setTutorExperience(int tutorIdSetExperience) {
        this.tutorExperience = tutorIdSetExperience;
    }
    
    //Tutor Subject
    public String getTutorSubject() {
        return tutorSubject;
    }

    public void setTutorSubject(String tutorSubjectSetSubject) {
        this.tutorSubject = tutorSubjectSetSubject;
    }

    @Override
    public String toString() {
        return "Tutors{" + "tutorID=" + tutorID + ", tutorName=" + tutorName + ", tutorSubject=" + tutorSubject + ", tutorExperience=" + tutorExperience + ", tutorStatus=" + tutorStatus + '}';
    }

    

}
