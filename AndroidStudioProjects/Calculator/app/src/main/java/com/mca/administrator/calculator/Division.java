package com.mca.administrator.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Division extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b4;
    String s1,s2,s3;
    int a0,b0,c0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        ed1=(EditText)findViewById(R.id.number1);
        ed2=(EditText)findViewById(R.id.number2);
        ed3=(EditText)findViewById(R.id.result) ;
        b4=(Button)findViewById(R.id.div);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=ed1.getText().toString();
                s2=ed2.getText().toString();
                a0=Integer.parseInt(s1);
                b0=Integer.parseInt(s2);
                c0=a0/b0;
                s3=String.valueOf(c0);
                Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
            }
        });
    }
}
