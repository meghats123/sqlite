package com.mca.administrator.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
b1=(Button)findViewById(R.id.add);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),Addition.class);
                startActivity(i);
            }
        });
        b2=(Button)findViewById(R.id.sub);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),Subtract.class);
                startActivity(i);
            }
        });
        b3=(Button)findViewById(R.id.mul);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),Multiplication.class);
                startActivity(i);
            }
        });
        b4=(Button)findViewById(R.id.div);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),Division.class);
                startActivity(i);
            }
        });
        b5=(Button)findViewById(R.id.large);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),LargestActivity.class);
                startActivity(i);
            }
        });

    }
}
