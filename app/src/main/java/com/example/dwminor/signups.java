package com.example.dwminor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class signups extends AppCompatActivity
{
    EditText Password_Register, Confirmpassword, Email_Register,sname;
    Button submit, cancel;
    Boolean isSuccess;
    String z,name,roll,em,pass,cgpa,com_cr,c_pass;
    Context context=this;
    public Connection connectionclass()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            ConnectionURL="jdbc:jtds:sqlserver://SQL5052.site4now.net;database=DB_A55FDE_dwmini;user=DB_A55FDE_dwmini_admin;password=megha1996";
            //ConnectionURL = "jdbc:jtds:sqlserver://" + server + database + ";user=" + user+ ";password=" + password + ";";
            connection = DriverManager.getConnection(ConnectionURL);
        }
        catch (SQLException se)
        {
            Log.e("error here 1 : ", se.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            Log.e("error here 2 : ", e.getMessage());
        }
        catch (Exception e)
        {
            Log.e("error here 3 : ", e.getMessage());
        }
        Log.d("dekho","Return to dekho kar rha hoon");
        return connection;
    }
    private void s_details(String Name, String roll,String c,String cg){
        try {
            Connection con = connectionclass();
            if (con == null) {
                Log.d("dekho", "abhi bhi nahi hua bhai");
            } else {

                String query = "insert into student values ( '" + roll + "'," + "'" + Name + "'," + "'" + c + "'," + "'" + cg + "')";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                if (rs.next()) {
                    z = "Inserted successful";
                    Toast.makeText(context, z, Toast.LENGTH_SHORT).show();
                    isSuccess = true;
                    con.close();

                } else {
                    z = "Not Inserted!";
                    Toast.makeText(context, z, Toast.LENGTH_SHORT).show();
                    isSuccess = false;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex)
        {
            isSuccess = false;
            z = ex.getMessage();
        }

    }
    private void login_details(String roll, String pass,String email){
        try {
            Connection con = connectionclass();
            if (con == null) {
                Log.d("dekho", "abhi bhi nahi hua bhai");
            } else {

                String query1 = "insert into student_login values ( '" + email + "'," + "'"+pass + "',"+"'"+roll+"')";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query1);

                if (rs.next()) {
                    z = "Inserted successful";
                    Toast.makeText(context, z, Toast.LENGTH_SHORT).show();
                    isSuccess = true;
                    con.close();

                } else {
                    z = "Not Inserted!";
                    Toast.makeText(context, z, Toast.LENGTH_SHORT).show();
                    isSuccess = false;
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex)
        {
            isSuccess = false;
            z = ex.getMessage();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signups);
       submit=(Button)findViewById(R.id.s_submits);


       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sname = findViewById(R.id.s_name);
               name = sname.getText().toString();
               sname = findViewById(R.id.roll_no);
               roll = sname.getText().toString();
               sname = findViewById(R.id.Register_emails);
               em = sname.getText().toString();
               sname = findViewById(R.id.Register_passwords);
               pass = sname.getText().toString();
               sname = findViewById(R.id.c_pass);
               c_pass = sname.getText().toString();
               sname = findViewById(R.id.cgpa);
               cgpa = sname.getText().toString();
               sname = findViewById(R.id.completed_credit);
               com_cr = sname.getText().toString();
               s_details(name,roll,com_cr,cgpa);
               login_details(roll,pass,em);
               Intent intent=new Intent(context,student_profile.class);
               startActivity(intent);
           }
       });
    }
}