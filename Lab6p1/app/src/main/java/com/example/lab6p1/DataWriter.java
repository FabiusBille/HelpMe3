package com.example.lab6p1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataWriter implements Serializable {
    public List<Contact> recepee;
    DataWriter()
    {
        recepee=new ArrayList<>();
    }
}
