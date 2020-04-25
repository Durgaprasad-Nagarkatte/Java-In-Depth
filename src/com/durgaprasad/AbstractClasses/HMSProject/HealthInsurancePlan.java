package com.durgaprasad.AbstractClasses.HMSProject;

public abstract class HealthInsurancePlan {
    // Code for 'coverage' field goes here

    // Don't worry about the below code and also the InsuranceBrand class
    private InsuranceBrand offeredBy;
    private double coverage;

    public HealthInsurancePlan(double coverage) {
        this.coverage = coverage;
    }

    public InsuranceBrand getOfferedBy() {
        return offeredBy;
    }

    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public abstract double computeMonthlyPremium(double salary);
}