package com.durgaprasad.Inheritence.HMSProject;

public class Patient extends User {
    private long patientId;
    private boolean insured;

    public Patient(long id, String firstName, String lastName, String gender, String email, boolean insured) {
        super(id, firstName, lastName, gender, email);
        this.insured = insured;
        this.patientId = id;
    }


    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }
}
