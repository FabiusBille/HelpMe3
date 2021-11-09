package com.example.lab6p1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String ATTRIBUTE_NAME_NAME = "namer";
    final String ATTRIBUTE_NAME_PONE= "number";
   public ArrayList<Contact> contacts;
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public ImageButton btn;  public ImageButton btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        refresh();
        btn=findViewById(R.id.back);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

finish();

            }
        });
        btn2=findViewById(R.id.addd);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

Intent intent = new Intent(MainActivity.this,MainActivity2.class);
startActivity(intent);

            }
        });

 DataWriter dw = new DataWriter();


        File flt = getFilesDir();
        File fl=new File(flt,"contacts01.xml");
        if(fl.exists()){

            try {
                ObjectInputStream oos = new ObjectInputStream(new FileInputStream(fl));
                try {

                    dw = (DataWriter) oos.readObject();
                    oos.close();
                } catch (Exception e) {
                    Toast tt = Toast.makeText(getApplicationContext(),"ErrorWhileRead",Toast.LENGTH_LONG);
                    tt.show();
                }
            } catch (IOException e) {
e.printStackTrace();

            }}
        else{
            try {
                fl.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        ArrayList<Map<String, String>> data = new ArrayList<>();
        Map<String, String> m;
        for (int i = 0; i < dw.recepee.size(); i++) {
            m = new HashMap<>();
            m.put(ATTRIBUTE_NAME_NAME, dw.recepee.get(i).namer+" "+dw.recepee.get(i).famer);
            m.put(ATTRIBUTE_NAME_PONE, String.valueOf( dw.recepee.get(i).numberr));


            data.add(m);
        }
        String[] from = {ATTRIBUTE_NAME_NAME,ATTRIBUTE_NAME_PONE};
        int[] to = {R.id.namer, R.id.number};
        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.layout, from, to);
        sAdapter.notifyDataSetChanged();
        ListView lw = findViewById(R.id.lisi);
        lw.setAdapter(sAdapter);


        EditText et = findViewById(R.id.editTextTextPersonName);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                DataWriter dw = new DataWriter();

                File flt =getFilesDir();
                File fl=new File(flt,"contacts01.xml");
                if(fl.exists()){

                    try {
                        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(fl));
                        try {
                            dw = (DataWriter) oos.readObject();
                            oos.close();
                        } catch (Exception e) {

                        }
                    } catch (IOException e) {


                    }


String tempstr;
                String temp2=et.getText().toString();
                ArrayList<Map<String, String>> data = new ArrayList<>();
                Map<String, String> m;
                for (int i = 0; i < dw.recepee.size(); i++) {
                    tempstr=dw.recepee.get(i).namer+" "+dw.recepee.get(i).famer;
                    if(tempstr.contains(temp2)){
                    m = new HashMap<>();
                    m.put(ATTRIBUTE_NAME_NAME, dw.recepee.get(i).namer+" "+dw.recepee.get(i).famer);
                    m.put(ATTRIBUTE_NAME_PONE, String.valueOf( dw.recepee.get(i).numberr));


                    data.add(m);}
                }
                String[] from = {ATTRIBUTE_NAME_NAME,ATTRIBUTE_NAME_PONE};
                int[] to = {R.id.namer, R.id.number};
                SimpleAdapter sAdapter2 = new SimpleAdapter(MainActivity.this, data, R.layout.layout, from, to);
                sAdapter2.notifyDataSetChanged();
                ListView lw2 = findViewById(R.id.lisi);
                lw2.setAdapter(sAdapter2);

            }}
        });
    }

    private void refresh() {

    }

}

