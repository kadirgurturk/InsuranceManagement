package org.csystem.app.Insurance;

import java.math.BigDecimal;
import java.time.LocalDate;

public class HealthInsurance extends Insurance{
    private final InsuranceType type = InsuranceType.HEALTHINSURANCE;
    private int age;
    private boolean isJobDangerous;
    private boolean isChronical;

    public HealthInsurance( int InsuranceYear, boolean isJobDangerous, boolean isChronical, int age) {
        super(1200 , LocalDate.now(), LocalDate.now().plusYears(InsuranceYear));
        this.isChronical = isChronical;
        this.isJobDangerous = isJobDangerous;
        this.age = age;


    }

    public double calculate() {
        var price = getInsuranceFee();

        if(age > 75){
            price += price * .15;
        }
        if(isChronical){
            price += price * 0.45;
        }
        if(isJobDangerous){
            price += price * 0.3;
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
                        "Kisinin Yası: " + age +"\n" +
                        "Kisinin Kronik Rahatsızlıgı Var mı: " + isChronical +"\n" +
                        "Kisinin Meslegi Tehlikeli mi: " + isJobDangerous +"\n" +
                        "Sigorta Ucreti: " + calculate() +"\n"+
                                "--------------------------------------"+ "\n"
        );
    }
}
