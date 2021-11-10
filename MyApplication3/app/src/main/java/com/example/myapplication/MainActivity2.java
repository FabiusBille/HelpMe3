package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public ImageButton btn;
    public Contact ctn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        {



            setContentView(R.layout.activity_main2);
            btn = findViewById(R.id.back);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(intent);
                }
            });
            btn = findViewById(R.id.save);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ctn=new Contact();

                    EditText et = findViewById(R.id.namee);
                    if(!et.getText().toString().isEmpty())
                        ctn.namer=et.getText().toString();
                    et = findViewById(R.id.namee2);
                    if(!et.getText().toString().isEmpty())
                        ctn.famer=et.getText().toString();
                    et = findViewById(R.id.hourss);
                    if(!et.getText().toString().isEmpty())
                        ctn.numberr=et.getText().toString();
                    DatePicker dp = findViewById(R.id.dpp);
                    try {
                        ctn.Datee=dp.getYear()+"-"+dp.getMonth()+"-"+dp.getDayOfMonth();
                    }
                    catch(Exception e)
                    {

                            ctn.Datee="2001-09-18";


                    }




                    File flt = getExternalFilesDir("nik");
                    File fl=new File(flt,"recuor111.xml");
                    List<Contact> lc = new ArrayList<>();

                    if(fl.exists()){

                        try {
                            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(fl));
                            try {lc.clear();
                                lc = (List<Contact>) oos.readObject();
                                oos.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();

                        }}
                    else
                    {
                        try {
                            fl.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                    lc.add(ctn);







                    try {
                        try (ObjectOutputStream oosi = new ObjectOutputStream(new FileOutputStream(fl,false))) {
                            try {

                                oosi.writeObject(lc);
                                oosi.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e) {

                        e.printStackTrace();
                    }

                    CheckBox cb=findViewById(R.id.checkBox);
                    if(cb.isChecked())
                    {
                        Contact ctn2=new Contact();
                        List<Contact> lc2 = new ArrayList<>();
                        et = findViewById(R.id.namee);
                        if(!et.getText().toString().isEmpty())
                            ctn2.namer=et.getText().toString();
                        et = findViewById(R.id.namee2);
                        if(!et.getText().toString().isEmpty())
                            ctn2.famer=et.getText().toString();
                        et = findViewById(R.id.hourss);
                        if(!(et.getText().toString().isEmpty()))
                            ctn2.numberr=et.getText().toString();
                        dp = findViewById(R.id.dpp);

                            ctn2.Datee=dp.getYear()+"-"+dp.getMonth()+"-"+dp.getDayOfMonth();




                        File flt2 = getExternalFilesDir("nik");
                        File fl2=new File(flt2,"recuor222.xml");

                        if(fl2.exists()){

                            try {
                                ObjectInputStream oisi = new ObjectInputStream(new FileInputStream(fl2));
                                try {lc2.clear();
                                    lc2= (List<Contact>) oisi.readObject();
                                    oisi.close();
                                } catch (ClassNotFoundException e) {
e.printStackTrace();
                                }
                            } catch (Exception e) {

                                e.printStackTrace();
                            }}
                        else
                        {
                            try {
                                fl2.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        lc2.add(ctn2);






                        try {
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fl2,false));
                            try {

                                oos.writeObject(lc2);
                                oos.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
e.printStackTrace();

                        }


                    }
                    Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
}