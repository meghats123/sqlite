package com.mca.administrator.productapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7;
    Button b,b1;
    String getpmodel,getpcode,getpname,getpsellername,getprice,getOname,getOmobileno;
    ProductHelper productHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.pmodel);
        ed2=(EditText)findViewById(R.id.pcode);
        ed3=(EditText)findViewById(R.id.pname);
        ed4=(EditText)findViewById(R.id.psellername);
        ed5=(EditText)findViewById(R.id.price);
        ed6=(EditText)findViewById(R.id.Oname);
        ed7=(EditText)findViewById(R.id.Omobileno);
        productHelper=new ProductHelper(this);
        productHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.submit);
        b1=(Button)findViewById(R.id.search);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(i);
    }
});
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getpmodel=ed1.getText().toString();
                getpcode=ed2.getText().toString();
                getpname=ed3.getText().toString();
                getpsellername=ed4.getText().toString();

                getprice=ed5.getText().toString();
                getOname=ed6.getText().toString();
                getOmobileno=ed7.getText().toString();
                Log.d("pmodel",getpmodel);
                Log.d("pcode",getpcode);
                Log.d("pname",getpname);
                Log.d("psellername",getpsellername);
                Log.d("price",getprice);
                Log.d("Oname",getOname);
                Log.d("Omobileno",getOmobileno);
                boolean status=productHelper.insertData(getpmodel,getpcode,getpname,getpsellername,getprice,getOname,getOmobileno);
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
