/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author blon8
 */
public class TutorialGroup {

    private String tutorialGroupID;
    private int memberOfNumber;

    public String getTutorialGroupID() {
        return tutorialGroupID;
    }

    public TutorialGroup() {

    }

    public TutorialGroup(String tutorialGroupID, int memberOfNumber) {
        this.tutorialGroupID = tutorialGroupID;
        this.memberOfNumber = memberOfNumber;
    }

    public void setTutorialGroupID(String tutorialGroupID) {
        this.tutorialGroupID = tutorialGroupID;
    }

    public int getMemberOfNumber() {
        return memberOfNumber;
    }

    public void setMemberOfNumber(int memberOfNumber) {
        this.memberOfNumber = memberOfNumber;
    }

    @Override
    public String toString() {
        return  "tutorialGroupID : " + tutorialGroupID + ", memberOfNumber : " + memberOfNumber ;
    }

}
