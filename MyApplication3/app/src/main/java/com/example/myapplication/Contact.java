package com.example.myapplication;


import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact implements Serializable {
    public String namer;
    public String famer;
    public String numberr;

    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String Datee;
    public Contact(String nams, String fams, String s, java.util.Date dt) {
        namer=nams;
        numberr=s;
        famer=fams;
        Datee=dateFormat.format(dt);
    }

    public Contact() {
        namer="android";
        numberr="+375296248655";
        famer="linux";

            Datee="2001-09-18";

    }
}
