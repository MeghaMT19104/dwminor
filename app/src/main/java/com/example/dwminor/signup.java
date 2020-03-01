package com.example.dwminor;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signup extends AppCompatActivity implements View.OnClickListener {
    EditText Password_Register, Confirmpassword, Email_Register;
    Button submit, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Password_Register = (EditText) findViewById(R.id.Register_password);
        Confirmpassword = (EditText) findViewById(R.id.Registerconfirm_register);
        Email_Register = (EditText) findViewById(R.id.Register_email);
    }
    private void registeruser () {
        final String Email_Register1;
        String Password_Register1, Confirmpassword1;


        Password_Register1 = Password_Register.getText().toString().trim();
        Confirmpassword1 = Confirmpassword.getText().toString().trim();
        Email_Register1 = Email_Register.getText().toString().trim();
        //  while (!Credentials)
        // {
        if (Email_Register1.isEmpty()) {
            Email_Register.setError("Email is required");
            Email_Register.requestFocus();
            return;

        }

        if (Password_Register1.isEmpty()) {
            Password_Register.setError("Enter Password");
            Password_Register.requestFocus();
            //    Credentials = true;
            return;
        }
        if (Password_Register1.length() < 6) {
            Password_Register.setError("Minimun length of password is 6");
            Password_Register.requestFocus();
            // Credentials = true;
            return;
        }
        if (Confirmpassword1.isEmpty()) {
            Confirmpassword.setError("Enter Confirm Password");
            Confirmpassword.requestFocus();
            //Credentials = true;
            return;
        }
        if (!(Password_Register.equals(Confirmpassword))) {
            Confirmpassword.setError("Password & confirm password must be same");
            Confirmpassword.requestFocus();
            //  Credentials = true;
            return;
        }
        ///////////////////save in database of teacher

    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.Register_submit:
                registeruser();
                startActivity(new Intent(signup.this,MainActivity.class));
                break;
            case R.id.Register_cancel:
                startActivity(new Intent(signup.this,MainActivity.class));
                break;

        }
    }
}
