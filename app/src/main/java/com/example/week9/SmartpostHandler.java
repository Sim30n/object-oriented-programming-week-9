package com.example.week9;

import java.util.ArrayList;

public class SmartpostHandler{

    private static SmartpostHandler single_instance = null;
    ArrayList<Smartpost> smartpost_array_suomi = new ArrayList<Smartpost>();
    ArrayList<Smartpost> smartpost_array_viro = new ArrayList<Smartpost>();

    private SmartpostHandler(){

    }

    public static SmartpostHandler getInstance()
    {
        if (single_instance == null)
            single_instance = new SmartpostHandler();

        return single_instance;
    }

    public void addSmartpostSuomi(String name, String city, String availability, String postalcode, String address, String country) {
        smartpost_array_suomi.add(new Smartpost(name, city, availability, postalcode, address, country));
    }
    public void addSmartpostViro(String name, String city, String availability, String postalcode, String address, String country) {
        smartpost_array_suomi.add(new Smartpost(name, city, availability, postalcode, address, country));
    }
}
