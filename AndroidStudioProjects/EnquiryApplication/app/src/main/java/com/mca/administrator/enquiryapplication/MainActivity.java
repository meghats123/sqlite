package com.mca.administrator.enquiryapplication;

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
    EditText ed1,ed2,ed3,ed4,ed5;
    Button b,b1;
    String getName,getEmailid,getMobileno,getPlace,getpurpose,getMessage;
    Spinner sp;
    EnquiryHelper enquiryHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.Name);
        ed2=(EditText)findViewById(R.id.Emailid);
        ed3=(EditText)findViewById(R.id.Moboleno);
        ed4=(EditText)findViewById(R.id.Place);
        sp=(Spinner)findViewById(R.id.purpose);
        ed5=(EditText)findViewById(R.id.Message);
       enquiryHelper=new EnquiryHelper(this);
        enquiryHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.contactus);
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
                getName=ed1.getText().toString();
                getEmailid=ed2.getText().toString();
                getMobileno=ed3.getText().toString();
                getPlace=ed4.getText().toString();
                getpurpose=sp.getSelectedItem().toString();
                getMessage=ed5.getText().toString();
                Log.d("Name",getName);
                Log.d("Emailid",getEmailid);
                Log.d("Mobileno",getMobileno);
                Log.d("Place",getPlace);
                Log.d("Message",getMessage);
                boolean status=enquiryHelper.insertData(getName,getEmailid,getMobileno,getPlace,getMessage);
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
