
package entity;

import adt.*;


public class Programme {

    private String programmeID;//For example RITY1S3
    private String programmeName;
    private ListInterface<TutorialGroup> tutorialGroup = new ArrayList<>();

    public ListInterface<TutorialGroup> getTutorialGroup() {
        return tutorialGroup;
    }

    public void setTutorialGroup(ListInterface<TutorialGroup> tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public String getProgrammeID() {
        return programmeID;
    }

    public void setProgrammeID(String programmeID) {
        this.programmeID = programmeID;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }

    public Programme(String programmeID, String programmeName) {
        this.programmeID = programmeID;
        this.programmeName = programmeName;
        this.tutorialGroup = new ArrayList<>();

    }

    public void addTutorialGroup(TutorialGroup tutorialGroupID) {
        tutorialGroup.add(tutorialGroupID);
    }

    public void removeTutorialGroup(TutorialGroup tutorialGroupID) {
        for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {
            if (tutorialGroup.getEntry(i).equals(tutorialGroupID)) {
                tutorialGroup.remove(i);
                break; // Remove only one instance
            }
        }
    }

    public boolean hasProgramme(TutorialGroup tutorialGroupID) {
        for (int i = 1; i <= tutorialGroup.getNumberOfEntries(); i++) {
            if (tutorialGroup.getEntry(i).equals(tutorialGroupID)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Programme: " + "Programme ID = " + programmeID + " | Programme Name = " + programmeName + "\n | Tutorial Group |\n"+tutorialGroup;
    }

}
