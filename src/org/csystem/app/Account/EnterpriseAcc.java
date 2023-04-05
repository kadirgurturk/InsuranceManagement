package org.csystem.app.Account;

import org.csystem.app.Address.Address;
import org.csystem.app.Insurance.Insurance;

import java.util.ArrayList;

public class EnterpriseAcc extends Account{

    public EnterpriseAcc(User user) {
        super(user);
    }

    @Override
    public void addInsurance(Insurance ınsurances) {
        super.getInsurances().add(ınsurances);

    }
}
