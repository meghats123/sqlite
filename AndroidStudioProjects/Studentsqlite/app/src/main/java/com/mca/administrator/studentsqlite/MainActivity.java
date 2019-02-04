package com.mca.administrator.studentsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
    Button b;
    String getname,getrollno,getadmissionno,getcollege;
    StudentHelper studentHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.rollno);
        ed3=(EditText)findViewById(R.id.admissionno);
        ed4=(EditText)findViewById(R.id.college);
        studentHelper=new StudentHelper(this);
        studentHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getname=ed1.getText().toString();
                getrollno=ed2.getText().toString();
                getadmissionno=ed3.getText().toString();
                getcollege=ed4.getText().toString();
                Log.d("name",getname);
                Log.d("rollno",getrollno);
                Log.d("admissionno",getadmissionno);
                Log.d("college",getcollege);
                boolean status=studentHelper.insertData(getname,getrollno,getadmissionno,getcollege);
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
