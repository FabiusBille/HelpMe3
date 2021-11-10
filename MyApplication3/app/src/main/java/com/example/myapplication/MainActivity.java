package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    final String ATTRIBUTE_NAME_NAME = "namer";
    final String ATTRIBUTE_NAME_PONE= "number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       ImageButton btn2=findViewById(R.id.addd);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);

            }
        });
 ImageButton btn7=findViewById(R.id.imageButton7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> lc = new ArrayList<>();
                File fl = getExternalFilesDir("nik");
                if(!fl.exists())
                {
                    try {
                        fl.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                File fl2=new File(fl,"recuor111.xml");

                if(!fl2.exists())
                {
                    try {
                        fl.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                try {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fl2));
                    try {
                        lc.clear();
                        lc = (List<Contact>) ois.readObject();
                        ois.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {

                    e.printStackTrace();
                }


                ArrayList<Map<String, String>> data = new ArrayList<>();
                Map<String, String> m;
                for (int i = 0; i < lc.size(); i++) {
                    m = new HashMap<>();
                    m.put(ATTRIBUTE_NAME_NAME,lc.get(i).namer+" "+lc.get(i).famer);
                    m.put(ATTRIBUTE_NAME_PONE,lc.get(i).numberr);


                    data.add(m);
                }
                String[] from = {ATTRIBUTE_NAME_NAME,ATTRIBUTE_NAME_PONE};
                int[] to = {R.id.namer, R.id.number};
                SimpleAdapter sAdapter = new SimpleAdapter(MainActivity.this, data, R.layout.layout, from, to);
                sAdapter.notifyDataSetChanged();
                ListView lw = findViewById(R.id.lisi);
                lw.setAdapter(sAdapter);


            }
        });




    }
}