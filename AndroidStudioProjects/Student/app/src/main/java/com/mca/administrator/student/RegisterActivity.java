package com.mca.administrator.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    Button b3,b4;
    String getname,getadmno,getrollno,getcollege,getplace,getstuid,getpwd,getconfirmpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.admno);
        ed3=(EditText)findViewById(R.id.rollno);
        ed4=(EditText)findViewById(R.id.college);
        ed5=(EditText)findViewById(R.id.place);
        ed6=(EditText)findViewById(R.id.stuid);
        ed7=(EditText)findViewById(R.id.pwd);
        ed8=(EditText)findViewById(R.id.confirmpass);
        b3=(Button)findViewById(R.id.registerbutton);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getname=ed1.getText().toString();
                getadmno=ed2.getText().toString();
                getrollno=ed3.getText().toString();
                getcollege=ed4.getText().toString();
                getplace=ed5.getText().toString();
                getstuid=ed6.getText().toString();
                getpwd=ed7.getText().toString();
                getconfirmpass=ed8.getText().toString();
                Toast.makeText(getApplicationContext(),getname,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getadmno,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getrollno,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getcollege,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getplace,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getstuid,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getpwd,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getconfirmpass,Toast.LENGTH_LONG).show();
            }
        });
        b4=(Button)findViewById(R.id.alreadyregbutton);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),MainActivity1.class);
                startActivity(i);
            }
        });
    }
}
