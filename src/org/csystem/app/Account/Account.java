package org.csystem.app.Account;

import org.csystem.app.Address.AddressManager;
import org.csystem.app.Address.Address;
import org.csystem.app.Insurance.Insurance;

import java.util.ArrayList;

public abstract class Account implements Comparable<Account>{
    private User user;
    private ArrayList<Insurance> ınsurances;
    private AuthenticationStatus authenticationStatus = AuthenticationStatus.FAIL;

    public Account(User user) {
        this.user = user;
        this.ınsurances = new ArrayList<Insurance>();
        this.authenticationStatus = AuthenticationStatus.FAIL;
    }

    //Abstract
    public abstract void addInsurance(Insurance ınsurances);

    public void showUserİnfo()
    {
        System.out.println("-----------------------------------");
        System.out.println("Name : " + user.getName());
        System.out.println("Lastname : " + user.getLastName());
        System.out.println("Email : " + user.getEmail());
        System.out.println("Job : "+user.getJob());
        System.out.println("Age : " + user.getAge());
        System.out.println("Last Visit Date : " + user.getLastVisitDate());
        user.getLastVisitDate();
        System.out.println("-------------Addresses--------------");
        if(user.getAddresses().isEmpty()){
            System.out.println("Henuz Herhangi bir adres girilmemistir ");
        }else{
            for(var address : user.getAddresses())
            {
                System.out.println(address);
            }
        }
        System.out.println("-------------Insurance-------------");
        if(ınsurances.isEmpty()){
            System.out.println("Henuz Herahngi bır sigorta yapılmamıstır");
        }else{
            for(var Insurance : ınsurances)
            {
                System.out.println(Insurance);
            }
        }

    }

    public AuthenticationStatus getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void login(String email, String password)
    {
        if(user.getEmail() == email && user.getPassword() == password){
            authenticationStatus = AuthenticationStatus.SUCCESS;
        }else{
            //TODO... InvalidAuthenticationException
        }
    }

    public void addAddresses(Address address)
    {
        if (authenticationStatus == AuthenticationStatus.SUCCESS) {
            AddressManager.addAddress(user,address);
        }
    }

    public User getUser()
    {
        return user;
    }

    public ArrayList<Insurance> getInsurances() {
        return ınsurances;
    }

    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Account && this.user.getEmail() == ((Account) obj).user.getEmail();
    }

    @Override
    public int compareTo(Account o) {
        return user.getEmail().compareTo(o.user.getEmail());
    }
}
