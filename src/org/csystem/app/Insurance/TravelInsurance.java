package org.csystem.app.Insurance;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TravelInsurance extends Insurance{
    private final InsuranceType type = InsuranceType.TRAVELINSURANCE;
    private boolean isDangerousPlace;
    private boolean isDiffContinent;


    public TravelInsurance(LocalDate start, int travelLong, boolean isDangerousPlace, boolean isDiffContinent) {
        super(250, start, start.plusDays(travelLong));
        this.isDangerousPlace = isDangerousPlace;
        this.isDiffContinent = isDiffContinent;
    }

    public double calculate() {

        var price = getInsuranceFee();

        if(isDangerousPlace){
            price += price * 0.2;
        }
        if(isDiffContinent){
            price += price * 0.2;
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
