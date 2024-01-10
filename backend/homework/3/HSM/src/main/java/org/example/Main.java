package org.example;

import org.example.BillingComponent.*;
import org.example.HSM.Patient;
import org.example.HSM.Staff;
import org.example.HSM.User;

public class Main {
    public static void main(String[] args) {


                HealthInsurancePlan insurancePlan = new PlatinumPlan();
                Patient patient = new Patient();
                patient.setInsurancePlan(insurancePlan);

                double[] payments = Billing.computePaymentAmount(patient, 1000.0);
                System.out.println("Insurance pays: $" + payments[0]);
                System.out.println("Patient pays: $" + payments[1]);

        User staff = new Staff();
        InsuranceBrand insuranceBrand1 = new BlueCrossBlueShield();
        HealthInsurancePlan insurancePlan1 = new PlatinumPlan();

        insurancePlan.setOfferedBy(insuranceBrand1);
        staff.setInsurancePlan(insurancePlan);
        double premium = insurancePlan.computeMonthlyPremium(5000, 56, true);

        System.out.println("Monthly Premium: " + premium);
    }
}

