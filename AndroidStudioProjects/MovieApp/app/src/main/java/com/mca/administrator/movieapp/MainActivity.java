package com.mca.administrator.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    Button b,b1;
    String getMname,getMactor,getMactress,getRyear,getDirector,getProducer,getCameraman,getTcollection,getMlanguage;
    Spinner sp;
    MovieHelper movieHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.Mname);
        sp=(Spinner)findViewById(R.id.Mlanguage);
        ed2=(EditText)findViewById(R.id.Mactor);
        ed3=(EditText)findViewById(R.id.Mactress);
        ed4=(EditText)findViewById(R.id.Ryear);
        ed5=(EditText)findViewById(R.id.Director);
        ed6=(EditText)findViewById(R.id.Producer);
        ed7=(EditText)findViewById(R.id.Cameraman);
        ed8=(EditText)findViewById(R.id.Tcollection);

        movieHelper=new MovieHelper(this);
        movieHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.register);
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
                getMname=ed1.getText().toString();
                getMlanguage=sp.getSelectedItem().toString();
                getMactor=ed2.getText().toString();
                getMactress=ed3.getText().toString();
                getRyear=ed4.getText().toString();
                getDirector=ed5.getText().toString();
                getProducer=ed6.getText().toString();
                getCameraman=ed7.getText().toString();
                getTcollection=ed8.getText().toString();

                Log.d("Mname",getMname);
                Log.d("Mlanguage",getMlanguage);
                Log.d("Mactor",getMactor);
                Log.d("Mactress",getMactress);
                Log.d("Ryear",getRyear);
                Log.d("Director",getDirector);
                Log.d("Producer",getProducer);
                Log.d("Cameraman",getCameraman);
                Log.d("Tcollection",getTcollection);

                boolean status=movieHelper.insertData(getMname,getMlanguage,getMactor,getMactress,getRyear,getDirector,getProducer,getCameraman,getTcollection);
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
