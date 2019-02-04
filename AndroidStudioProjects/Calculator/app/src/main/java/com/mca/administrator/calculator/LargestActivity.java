package com.mca.administrator.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LargestActivity extends AppCompatActivity {
    EditText n1,n2,n3,n4;
    Button b1,b2;
    String s1,s2,s3,s4;
    int e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_largest);
        n1=(EditText)findViewById(R.id.number1);
        n2=(EditText)findViewById(R.id.number2);
       n3=(EditText)findViewById(R.id.number3);
       n4=(EditText)findViewById(R.id.result);
        b1=(Button)findViewById(R.id.large);
        b2=(Button)findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=n1.getText().toString();
                s2=n2.getText().toString();
                s3=n3.getText().toString();
                e1=Integer.parseInt(s1);
                e2=Integer.parseInt(s2);
               e3=Integer.parseInt(s3);
                if ((e1>e2)&&(e1>e3))
                {
s4=String.valueOf(e2);
                    n4.setVisibility(View.VISIBLE);
                    n4.setText(s4);
//                    Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG).show();
                }
                else if (e2>e3){
                    s4=String.valueOf(e2);
                    n4.setVisibility(View.VISIBLE);
                    n4.setText(s4);
//                    Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG).show();
                }
else
                {
                    s4=String.valueOf(e3);
                    n4.setVisibility(View.VISIBLE);
                    n4.setText(s4);
//                    Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(i);
            }
        });

    }
}
