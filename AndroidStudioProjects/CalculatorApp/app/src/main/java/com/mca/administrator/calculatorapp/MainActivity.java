package com.mca.administrator.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b;
    String getnumber1,getnumber2,getResult;
    CalculatorHelper calculatorHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.number1);
        ed2=(EditText)findViewById(R.id.number2);
        ed3=(EditText)findViewById(R.id.Result);
        calculatorHelper=new CalculatorHelper(this);
        calculatorHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getnumber1=ed1.getText().toString();
                getnumber2=ed2.getText().toString();
                getResult=ed3.getText().toString();
                Log.d("number1",getnumber1);
                Log.d("number2",getnumber2);
                Log.d("Result",getResult);
                boolean status=calculatorHelper.insertData(getnumber1,getnumber2,getResult);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"Successfully Inserted",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
