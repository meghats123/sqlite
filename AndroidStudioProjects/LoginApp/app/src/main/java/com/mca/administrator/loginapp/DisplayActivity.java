package com.mca.administrator.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
Button b1,b2,b3;
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        SharedPreferences shared=getSharedPreferences("username",MODE_PRIVATE);
        String check=shared.getString("username",null);
        if (check!=null)
        {
            Intent i=new Intent(getApplicationContext(),DisplayActivity.class);
            startActivity(i);
        }
tv=(TextView)findViewById(R.id.display);
        SharedPreferences preferences=getSharedPreferences("display",MODE_PRIVATE);
        String data=preferences.getString("username",null);
        tv.setText("welcome "+data);


    }
}
