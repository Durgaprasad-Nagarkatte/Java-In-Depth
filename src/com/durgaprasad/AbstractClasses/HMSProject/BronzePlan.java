package com.durgaprasad.AbstractClasses.HMSProject;

public class BronzePlan extends HealthInsurancePlan {
    public BronzePlan() {
        super(0.6);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary*0.05;
    }
}
