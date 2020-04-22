package com.durgaprasad.Inheritence.HMSProject;

public class Nurse extends Staff {
    private int nurseId;

    public Nurse(long id, String firstName, String lastName, String gender, String email, int yearsOfExperience, String description, double salary) {
        super(id, firstName, lastName, gender, email, yearsOfExperience, description, salary);
    }


    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }
}
