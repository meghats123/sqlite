package com.example.administrator.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b;
    String e,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button)findViewById(R.id.button1);
        ed1=(EditText)findViewById(R.id.email);
        ed2=(EditText)findViewById(R.id.pass);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e=ed1.getText().toString();
                p=ed2.getText().toString();
                //Toast.makeText(getApplicationContext(),e,Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),p,Toast.LENGTH_LONG).show();
                if(e.equals("admin") && p.equals("1234"))
                {
                    Intent i=new Intent(getApplicationContext(),Dashboard.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_LONG).show();

                }
            }

        });
    }
}

