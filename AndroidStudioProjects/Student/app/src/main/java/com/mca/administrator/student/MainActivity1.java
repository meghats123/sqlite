package com.mca.administrator.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity1 extends AppCompatActivity {
EditText ed1,ed2;
    Button b1,b2;
    String getstudentid,getpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ed1=(EditText)findViewById(R.id.stid);
        ed2=(EditText)findViewById(R.id.pswd);
        b1=(Button)findViewById(R.id.loginbutton);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getstudentid=ed1.getText().toString();
                getpassword=ed2.getText().toString();
                Toast.makeText(getApplicationContext(),getstudentid,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),getpassword,Toast.LENGTH_LONG).show();
            }
        });
        b2=(Button)findViewById(R.id.registerbutton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
