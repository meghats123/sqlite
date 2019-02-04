package com.mca.administrator.enquiryapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button b;
    String getname,getemailid,getmobileno,getplace,getpurpose,getmessage,getnewemailid,getnewmobileno,getnewplace,getnewpurpose,getnewmessage,getid;
    EnquiryHelper enquiryHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.emailid);
        ed3=(EditText)findViewById(R.id.mobileno);
        ed4=(EditText)findViewById(R.id.place);
        ed5=(EditText)findViewById(R.id.purpose);
        ed6=(EditText)findViewById(R.id.message);
        enquiryHelper=new EnquiryHelper(this);
        enquiryHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.update);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               getnewemailid=ed2.getText().toString();
               getnewmobileno=ed3.getText().toString();
               getnewplace=ed4.getText().toString();
               getnewpurpose=ed5.getText().toString();
               getnewmessage=ed6.getText().toString();
               getname = ed1.getText().toString();
               Log.d("name", getname);
               getemailid=ed2.getText().toString();
               getmobileno = ed3.getText().toString();
               getplace = ed4.getText().toString();
               getpurpose = ed5.getText().toString();
               getmessage = ed6.getText().toString();
               Cursor cursor = enquiryHelper.SearchData(getname);
               if (cursor.getCount() == 0) {
                   Toast.makeText(getApplicationContext(), "No Name Found", Toast.LENGTH_LONG).show();
               } else {
                   while (cursor.moveToNext()) {
                       getemailid = cursor.getString(2);
                       Toast.makeText(getApplicationContext(), getemailid, Toast.LENGTH_LONG).show();
                       getmobileno = cursor.getString(3);
                       Toast.makeText(getApplicationContext(), getmobileno, Toast.LENGTH_LONG).show();
                       getplace = cursor.getString(4);
                       Toast.makeText(getApplicationContext(), getplace, Toast.LENGTH_LONG).show();
                       getpurpose = cursor.getString(5);
                       Toast.makeText(getApplicationContext(), getpurpose, Toast.LENGTH_LONG).show();
                       getmessage= cursor.getString(6);
                       Toast.makeText(getApplicationContext(), getmessage, Toast.LENGTH_LONG).show();


                       getid=cursor.getString(0);
                       Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();
                       ed2.setText(getemailid);
                       ed3.setText(getmobileno);
                       ed4.setText(getplace);
                       ed5.setText(getpurpose);
                       ed6.setText(getmessage);

                   }
       });
    }
}
