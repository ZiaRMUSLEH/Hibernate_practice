package com.hb02.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String country;
    private String street;
    private String zipCode;

    public Address () {
    }

    public Address (String city, String country, String street, String zipCode) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.zipCode = zipCode;
    }

    public String getCity () {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public String getCountry () {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }

    @Override
    public String toString () {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public String getStreet () {
        return street;
    }

    public void setStreet (String street) {
        this.street = street;
    }

    public String getZipCode () {
        return zipCode;
    }

    public void setZipCode (String zipCode) {
        this.zipCode = zipCode;
    }
}
