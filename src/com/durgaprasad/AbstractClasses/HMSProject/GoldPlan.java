package com.durgaprasad.AbstractClasses.HMSProject;

public class GoldPlan extends HealthInsurancePlan {
    public GoldPlan() {
        super(0.8);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary*0.07;
    }
}
