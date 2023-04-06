package org.csystem.app.Address;

public class HomeAddress implements Address, Comparable<Address>{
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

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof HomeAddress && getCountry().equals(((HomeAddress) obj).country) && getStreet().equals(((HomeAddress) obj).street) &&
                getCity().equals(((HomeAddress) obj).city);
    }

    @Override
    public String toString() {
        return "--------------------------------------"+ "\n"+
                "Ülke: " + country +"\n" +
                "Şehir: " + city +"\n" +
                "Mahalle: " + street +"\n" +
                "--------------------------------------"+ "\n";
    }

    @Override
    public int compareTo(Address o) {
        return getCountry().compareTo(o.getCountry());
    }
}
