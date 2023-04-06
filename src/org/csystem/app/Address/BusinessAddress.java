package org.csystem.app.Address;

import java.util.Iterator;

public class BusinessAddress implements Address ,Comparable<Address>{

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

    @Override
    public int hashCode() {
        return getCompanyName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof HomeAddress && getCountry().equals(((HomeAddress) obj).country) && getStreet().equals(((HomeAddress) obj).street) &&
                getCity().equals(((HomeAddress) obj).city);
    }

    @Override
    public String toString() {
        return "--------------------------------------"+ "\n"+
                "Ulke: " + country +"\n" +
                "Sehir: " + city +"\n" +
                "Mahalle: " + street +"\n" +
                "Sirket İsmi: " + companyName +"\n" +
                "--------------------------------------"+ "\n";
    }

    @Override
    public int compareTo(Address o) {
        return getCountry().compareTo(o.getCountry());
    }
}
