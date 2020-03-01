package com.example.dwminor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class courses_offered extends AppCompatActivity {
    private ListView listView;
    Button b;
    private ArrayAdapter adapter;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> subc = new ArrayList<>();
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_offered);
        listView = findViewById(R.id.sub_off_list);
        list.add("Maths");
        list.add("Science");
        subc.add("MTH101");
        subc.add("SCI101");


        listView.setAdapter(new MyCustomstudent(list,context,subc));
        listView.setVisibility(View.VISIBLE);
    }
}
