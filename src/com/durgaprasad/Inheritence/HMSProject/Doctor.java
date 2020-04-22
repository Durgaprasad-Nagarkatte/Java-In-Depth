package com.durgaprasad.Inheritence.HMSProject;

public class Doctor extends Staff {
    private long doctorId;
    private String specialization;

    public Doctor(long id, String firstName, String lastName, String gender, String email, int yearsOfExperience, String description, double salary, String specialization) {
        super(id, firstName, lastName, gender, email, yearsOfExperience, description, salary);
        this.specialization = specialization;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
