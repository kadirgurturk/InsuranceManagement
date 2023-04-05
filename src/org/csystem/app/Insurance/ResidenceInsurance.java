package org.csystem.app.Insurance;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResidenceInsurance extends Insurance{
    private final InsuranceType type = InsuranceType.RESIDENCEINSURANCE;
    private int residenceAge;
    private boolean isEarthquakeZone;

    public ResidenceInsurance(int InsuranceYear) {
        super( 450, LocalDate.now(), LocalDate.now().plusYears(InsuranceYear));
    }

    public double calculate() {
        var price = getInsuranceFee();

        if(residenceAge > 25){
            price += price * 0.15;
        }
        if(isEarthquakeZone){
            price += price * 0.25;
        }

        setInsuranceFee(price);

        return getInsuranceFee();

    }

    public InsuranceType getType()
    {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Insurance Type: " + type.toString());
    }
}
