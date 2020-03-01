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

public class student_profile extends AppCompatActivity {
    private ListView listView;
    Button b;
    private ArrayAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> subc = new ArrayList<>();
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);
        listView = findViewById(R.id.subjectstaken);
        list.add("Maths");
        list.add("Science");
        subc.add("MTH101");
        subc.add("SCI101");


        listView.setAdapter(new MyCustomstudent(list,context,subc));
        listView.setVisibility(View.VISIBLE);
        b=(Button)findViewById(R.id.slne);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(context,course_selection.class);
                startActivity(in);
            }
        });
    }
}
