package org.csystem.app.Account;

import org.csystem.app.Address.Address;
import org.csystem.app.Insurance.Insurance;

import java.util.ArrayList;

public class IndividualAcc extends Account{

    public IndividualAcc(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance ınsurances) {
        super.getInsurances().add(ınsurances);
    }
}
