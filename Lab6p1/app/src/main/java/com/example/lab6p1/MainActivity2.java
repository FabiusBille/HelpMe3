package com.example.lab6p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;

public class MainActivity2 extends AppCompatActivity {
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public ImageButton btn;  public ImageButton btn2;
    public Contact ctn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                DataWriter dw = new DataWriter();
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
                   ctn.Datee=dateFormat.parse(dp.getYear()+"-"+dp.getMonth()+"-"+dp.getDayOfMonth());
                }
               catch(Exception e)
               {


               }

                File flt =getFilesDir();
           File fl=new File(flt,"contacts01.xml");
               dw=new DataWriter();
                if(fl.exists()){

                    try {
                        ObjectInputStream oos = new ObjectInputStream(new FileInputStream(fl));
                        try {
                            dw = (DataWriter) oos.readObject();
                            oos.close();
                        } catch (Exception e) {

                        }
                    } catch (IOException e) {


                    }}
                else
                {
                    try {
                        fl.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                dw.recepee.add(ctn);







                    try {
                        try (ObjectOutputStream oosi = new ObjectOutputStream(new FileOutputStream(fl,false))) {
                            try {

                                oosi.writeObject(dw);
                                oosi.close();
                            } catch (Exception e) {

                            }
                        }
                    } catch (IOException e) {


                    }

                CheckBox cb=findViewById(R.id.checkBox);
                    if(cb.isChecked())
                    {
                        Contact ctn2=new Contact();
                       DataWriter dw2 = new DataWriter();
                       et = findViewById(R.id.namee);
                        if(!et.getText().toString().isEmpty())
                            ctn2.namer=et.getText().toString();
                        et = findViewById(R.id.namee2);
                        if(!et.getText().toString().isEmpty())
                            ctn2.famer=et.getText().toString();
                        et = findViewById(R.id.hourss);
                        if(!et.getText().toString().isEmpty())
                            ctn2.numberr=et.getText().toString();
                      dp = findViewById(R.id.dpp);
                        try {
                            ctn2.Datee=dateFormat.parse(dp.getYear()+"-"+dp.getMonth()+"-"+dp.getDayOfMonth());
                        }
                        catch(Exception e)
                        {


                        }

                        File flt2 =getFilesDir();
                        File fl2=new File(flt2,"contacts3.xml");
                        fl2.setReadable(true);
                        fl2.setWritable(true);
                        fl2.setExecutable(true);
                        if(fl2.exists()){

                            try {
                                ObjectInputStream oisi = new ObjectInputStream(new FileInputStream(fl2));
                                try {
                                    dw2= (DataWriter) oisi.readObject();
                                    oisi.close();
                                } catch (ClassNotFoundException e) {

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
                        dw2.recepee.add(ctn2);





                        try {
                            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fl2,false));
                            try {

                                oos.writeObject(dw2);
                                oos.close();
                            } catch (Exception e) {

                            }
                        } catch (IOException e) {


                        }


                    }
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}