package com.example.dwminor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class faculty_profile extends AppCompatActivity {

    private ListView listView;

    private ArrayAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> subc = new ArrayList<>();
    Context context=this;
    //private ArrayList<String,> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_profile);
        listView = findViewById(R.id.fac_sub);
        list.add("Maths");
        list.add("Science");
        subc.add("MTH101");
        subc.add("SCI101");


        listView.setAdapter(new MyCustom(list,context,subc));
        listView.setVisibility(View.VISIBLE);
        Button b=(Button)findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(context,add_subject.class);
                startActivity(in);
            }
        });
    }
}
