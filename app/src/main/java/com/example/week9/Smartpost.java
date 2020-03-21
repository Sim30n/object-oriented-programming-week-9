package com.example.week9;

public class Smartpost {

    private String name;
    private String city;
    private String availability;
    private String postalcode;
    private String address;
    private String country;

    public Smartpost(String name, String city, String availability, String postalcode, String address, String country){
        this.name = name;
        this.city = city;
        this.postalcode = postalcode;
        this.country = country;
        this.address = address;
        this.availability = availability;
    }

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public String getAvailability(){
        return this.availability;
    }

    public String getAddress(){
        return this.address;
    }

    public String getPostalcode(){
        return this.postalcode;
    }

    public String getCountry(){
        return this.country;
    }

}
