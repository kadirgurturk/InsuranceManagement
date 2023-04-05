package org.csystem.app.Insurance;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Insurance {

    private double insuranceFee;

    private LocalDate startOfInsurance;

    private LocalDate finishOfInsurance;

    public Insurance(double insuranceFee, LocalDate startOfInsurance, LocalDate finishOfInsurance) {

        this.insuranceFee = insuranceFee;
        this.startOfInsurance = startOfInsurance;
        this.finishOfInsurance = finishOfInsurance;
    }

    public abstract double calculate();


    public void setInsuranceFee(double insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public void setStartOfInsurance(LocalDate startOfInsurance) {
        this.startOfInsurance = startOfInsurance;
    }

    public void setFinishOfInsurance(LocalDate finishOfInsurance) {
        this.finishOfInsurance = finishOfInsurance;
    }


    public double getInsuranceFee() {
        return insuranceFee;
    }

    public LocalDate getStartOfInsurance() {
        return startOfInsurance;
    }

    public LocalDate getFinishOfInsurance() {
        return finishOfInsurance;
    }
}
