package com.durgaprasad.AbstractClasses.HMSProject;

public class Billing {

    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        // your logic
        if(patientInsurancePlan == null){
            payments[0] = 20;
            payments[1] = amount-20;
            return payments;
        }

        payments[0] = amount*patientInsurancePlan.getCoverage();
        payments[1] = amount-payments[0];

        if(patientInsurancePlan instanceof PlatinumPlan){
            payments[0] += 50;
            payments[1] -= 50;
        }else if(patientInsurancePlan instanceof GoldPlan){
            payments[0] += 40;
            payments[1] -= 40;
        }else if(patientInsurancePlan instanceof SilverPlan){
            payments[0] += 30;
            payments[1] -= 30;
        }else{
            payments[0] += 25;
            payments[1] -= 25;
        }
        return payments;
    }
}
