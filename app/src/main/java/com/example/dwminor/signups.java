package com.example.dwminor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signups extends AppCompatActivity
{
    EditText Password_Register, Confirmpassword, Email_Register;
    Button submit, cancel;
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signups);
       submit=(Button)findViewById(R.id.Register_submits);
       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context,student_profile.class);
               startActivity(intent);
           }
       });
    }
}