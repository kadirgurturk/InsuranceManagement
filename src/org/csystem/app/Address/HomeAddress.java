package org.csystem.app.Address;

public class HomeAddress implements Address{
    public String country;
    public String city;
    public String street;

    public HomeAddress(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
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
