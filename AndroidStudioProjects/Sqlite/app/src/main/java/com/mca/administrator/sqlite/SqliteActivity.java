package com.mca.administrator.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SqliteActivity extends AppCompatActivity {
EditText ed1,ed2;
    Button b,b1;
    String getname,getemail;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.email);
databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.submit);
        b1=(Button)findViewById(R.id.search);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getname = ed1.getText().toString();
                getemail = ed2.getText().toString();
                Log.d("name", getname);
                Log.d("email", getemail);
                boolean status = databaseHelper.insertData(getname, getemail);
                if (status == true) {
                    Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(i);
    }
});
    }
}
