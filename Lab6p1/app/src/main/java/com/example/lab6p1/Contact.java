package com.example.lab6p1;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact implements Serializable {
    public String namer;
    public String famer;
    public String numberr;
    public Date Datee;
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Contact(String nams, String fams, String s, java.util.Date dt) {
        namer=nams;
        numberr=s;
        famer=fams;
        Datee=dt;
    }

    public Contact() {
        namer="android";
        numberr="+375296248655";
        famer="linux";
        try {
            Datee=dateFormat.parse("2001-09-18");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
