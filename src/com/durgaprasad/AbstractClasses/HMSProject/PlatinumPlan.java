package com.durgaprasad.AbstractClasses.HMSProject;

public class PlatinumPlan extends HealthInsurancePlan {

    public PlatinumPlan() {
        super(0.9);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary*0.08;
    }
}
