package com.example.dwminor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class course_selection extends AppCompatActivity {
    private ListView listView;
    Button b;
    private ArrayAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> subc = new ArrayList<>();
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selection);
        listView = findViewById(R.id.select_courses);
        list.add("Maths");
        list.add("Science");
        subc.add("MTH101");
        subc.add("SCI101");



        b=(Button)findViewById(R.id.fecl);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(new course_add(list,context,subc));
                listView.setVisibility(View.VISIBLE);

            }
        });
        Button b1=(Button)findViewById(R.id.viewprofile);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(context,student_profile.class);
                startActivity(in);
            }
        });
    }
    }

