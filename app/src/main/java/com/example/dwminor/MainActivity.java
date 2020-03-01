package com.example.dwminor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private Spinner spinner1;
    Button b;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1=findViewById(R.id.Signup);
        List<String> show=new ArrayList<>();
        show.add(0,"SignUp");
        show.add("Teacher");
        show.add("Student");
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,show);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        b=(Button)findViewById(R.id.loginbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(context,faculty_profile.class);
                startActivity(in);

            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(adapterView.getItemAtPosition(i).equals("SignUp"))
                {
                    //Do nothing
                }
                else
                {
                    String item=adapterView.getItemAtPosition(i).toString();
                    //on the basis of selected item do something
                    if (item=="Teacher")
                    {
                        Intent intent=new Intent(MainActivity.this,signup.class);
                        startActivity(intent);
                    }
                    if (item=="Student")
                    {
                        Intent intent=new Intent(MainActivity.this,signups.class);
                        startActivity(intent);
                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

    }
}