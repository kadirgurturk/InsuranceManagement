package org.csystem.app.Address;

import java.util.Iterator;

public class BusinessAddress implements Address{

    public String country;
    public String city;
    public String street;
    public String companyName;

    public BusinessAddress(String country, String city, String street, String companyName) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.companyName = companyName;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String getStreet() {
       return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }


}
