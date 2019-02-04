package com.mca.administrator.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Addition extends AppCompatActivity {
EditText ed1,ed2,ed3;
    Button b1,b2;
    String s1,s2,s3,s4;
    int a0,b0,c0,d0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        ed1=(EditText)findViewById(R.id.number1);
        ed2=(EditText)findViewById(R.id.number2);
        ed3=(EditText)findViewById(R.id.number3);
        b1=(Button)findViewById(R.id.addition);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                s3=ed3.getText().toString();
                a0=Integer.parseInt(s1);
                b0=Integer.parseInt(s2);
                c0=Integer.parseInt(s3);
                d0=a0+b0+c0;
                s4=String.valueOf(d0);
                Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG).show();

            }
        });
    }
}
