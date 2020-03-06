package com.example.dwminor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private Spinner spinner1;
    Button login;
    Context context=this;
    Connection con;
    EditText username,password;
    String username1,password1;
    String un,pass,db,ip;
    public Connection connectionclass(String user, String password, String database, String server)
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("dekho ji mujhe na pta kya hua");
        ip = "SQL5052.site4now.net";
        db = "DB_A55FDE_dwmini";
        un = "DB_A55FDE_dwmini_admin";
        pass = "megha1996";
        con = connectionclass(un, pass, db, ip);        // Connect to database
        if (con == null) {
            String z = "Check Your Internet Access!";
            System.out.println(z);
            Log.d("dekho", z);
        } else {
            Log.d("dekho", "Connect ho gya khushiya manao");
        }
        spinner1 = findViewById(R.id.Signup);
        List<String> show = new ArrayList<>();
        show.add(0, "SignUp");
        show.add("Teacher");
        show.add("Student");
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, show);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.loginbutton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username1 = username.getText().toString();
                password1 = password.getText().toString();
                check c = new check();
                c.execute("");

            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getItemAtPosition(i).equals("SignUp")) {
                    //Do nothing
                } else {
                    String item = adapterView.getItemAtPosition(i).toString();
                    //on the basis of selected item do something
                    if (item == "Teacher") {
                        Intent intent = new Intent(MainActivity.this, signup.class);
                        startActivity(intent);
                    }
                    if (item == "Student") {
                        Intent intent = new Intent(MainActivity.this, signups.class);
                        startActivity(intent);
                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });
    }
        public class check extends AsyncTask<String,String,String>
        {
            String z="";
            Boolean isSuccess=false;

            @Override
            protected void onPostExecute(String s) {
               if(isSuccess){
                   Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_SHORT).show();
               }
            }

            @Override
            protected String doInBackground(String... params) {
                if(username1.trim().equals("")|password1.trim().equals("")){
                    z="please enter username ";
                }

               else{
                   try {
                       {
                           con = connectionclass(un, pass, db, ip);
                           if (con == null) {
                                Log.d("dekho","abhi bhi nahi hua bhai");
                           } else {
                               String query = "select * from student_login where s_email = '" + username1.toString() + "' and password = '" + password1.toString() + "' ";
                               Statement stmt = con.createStatement();
                               ResultSet rs = stmt.executeQuery(query);
                               if (rs.next()) {
                                   z = "Login successful";
                                   isSuccess = true;
                                   con.close();
                               } else {
                                   z = "Invalid Credentials!";
                                   isSuccess = false;
                               }
                           }
                       }
                   } catch (SQLException e) {
                      e.printStackTrace();
                  } catch (Exception ex)
                       {
                           isSuccess = false;
                           z = ex.getMessage();
                       }

                           }
                return z;
                       }
                   }

                }

