package com.mca.administrator.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registeractivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b1,b2;
    DatabaseHelper databaseHelper;
    String getname,getemail,getmobileno,getusername,getpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.email);
        ed3=(EditText)findViewById(R.id.mobileno);
        ed4=(EditText)findViewById(R.id.username);
        ed5=(EditText)findViewById(R.id.password);

        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();
        b1=(Button)findViewById(R.id.register);
        b2=(Button)findViewById(R.id.backtologin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getname = ed1.getText().toString();
                getemail = ed2.getText().toString();
                getmobileno=ed3.getText().toString();
                getusername=ed4.getText().toString();
                getpassword=ed5.getText().toString();
                Log.d("name", getname);
                Log.d("email", getemail);
                Log.d("mobileno", getmobileno);
                Log.d("username", getusername);
                Log.d("password",getpassword);

                  boolean status = databaseHelper.insertData(getname,getemail,getmobileno,getusername, getpassword);
                if (status == true) {
                    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }



            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);


            }

        });
    }
}
