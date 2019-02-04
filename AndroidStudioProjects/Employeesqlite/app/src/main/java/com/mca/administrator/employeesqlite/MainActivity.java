package com.mca.administrator.employeesqlite;

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
    Button b;
    String getempcode,getempname,getmobileno,getemailid,getdesignation,getsalary,getcompanyname;
    EmployeeHelper employeeHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.empcode);
        ed2=(EditText)findViewById(R.id.empname);
        ed3=(EditText)findViewById(R.id.mobileno);
        ed4=(EditText)findViewById(R.id.emailid);
        ed5=(EditText)findViewById(R.id.designation);
        ed6=(EditText)findViewById(R.id.salary);
        ed7=(EditText)findViewById(R.id.companyname);
        employeeHelper=new EmployeeHelper(this);
        employeeHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getempcode=ed1.getText().toString();
                getempname=ed2.getText().toString();
                getmobileno=ed3.getText().toString();
                getemailid=ed4.getText().toString();
                getdesignation=ed5.getText().toString();
                getsalary=ed6.getText().toString();
                getcompanyname=ed7.getText().toString();
                Log.d("empcode",getempcode);
                Log.d("empname",getempname);
                Log.d("mobileno",getmobileno);
                Log.d("emailid",getemailid);
                Log.d("designation",getdesignation);
                Log.d("salary",getsalary);
                Log.d("companyname",getcompanyname);
boolean status=employeeHelper.insertData(getempcode,getempname,getmobileno,getemailid,getdesignation,getsalary,getcompanyname);
if (status==true) {
    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_LONG).show();
}
                else {
    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
