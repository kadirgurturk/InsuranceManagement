package org.csystem.app.Insurance;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResidenceInsurance extends Insurance{
    private final InsuranceType type = InsuranceType.RESIDENCEINSURANCE;
    private int residenceAge;
    private boolean isEarthquakeZone;

    public ResidenceInsurance(int InsuranceYear,int residenceAge, boolean isEarthquakeZone) {
        super( 450, LocalDate.now(), LocalDate.now().plusYears(InsuranceYear));
        this.residenceAge = residenceAge;
        this.isEarthquakeZone = isEarthquakeZone;
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
        return String.format(
                "--------------------------------------"+ "\n"+
                        "Sigorta Türü: " + type.toString() +"\n" +
                        "Sigorta Baslangici: " + super.getStartOfInsurance() +"\n" +
                        "Sigorta Bitisi: " + super.getFinishOfInsurance() +"\n" +
                        "Binanın Yası: " + residenceAge +"\n" +
                        "Bina Deprem Bolgesinde mı: " + isEarthquakeZone +"\n" +
                        "Sigorta Ucreti: " + calculate() +"\n"+
                        "--------------------------------------"+ "\n"
        );
    }
}
