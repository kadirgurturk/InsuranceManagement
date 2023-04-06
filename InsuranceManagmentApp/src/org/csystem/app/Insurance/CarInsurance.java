package org.csystem.app.Insurance;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CarInsurance extends Insurance{
    private final InsuranceType type = InsuranceType.CARINSURANCE;
    private final String carModel;
    private int carAge;
    private boolean isDamaged;

    public CarInsurance(String carModel, int carAge, boolean carDameged, int InsuranceYear) {
        super(900 , LocalDate.now(), LocalDate.now().plusYears(InsuranceYear));
        this.carModel = carModel;
        this.carAge = carAge;
        this.isDamaged = carDameged;
    }


    public double calculate() {

        var price = getInsuranceFee();

        if(carAge > 10){
            price += price * 0.2;
        }
        if(isDamaged){
            price += price * 0.1;
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
                        "Araba Modeli: " + carModel +"\n" +
                        "Arabanın Yası: " + carAge +"\n" +
                        "Arabanın Hasarı var mı: " + isDamaged +"\n" +
                        "Sigorta Ucreti: " + calculate() +"\n"+
                        "--------------------------------------"+ "\n"
        );
    }
}
