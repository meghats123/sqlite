package com.mca.administrator.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b1,b2;
    String getusername,getpassword,getretreivepassword,getid;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.username);
        ed2=(EditText)findViewById(R.id.password);
        databaseHelper=new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();
        b1=(Button)findViewById(R.id.login);
        b2=(Button)findViewById(R.id.register);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getusername = ed1.getText().toString();
                getpassword = ed2.getText().toString();
                Log.d("username", getusername);
                Log.d("password", getpassword);

                Cursor cursor=databaseHelper.SearchData(getusername);
                if(cursor.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no name found",Toast.LENGTH_LONG).show();

                }
                else
                {
                    while (cursor.moveToNext())

                    {
                      String getretreivepassword=cursor.getString(5);

                        if (getretreivepassword.equals(getpassword))
                        {
                            SharedPreferences.Editor editor=getSharedPreferences("display",MODE_PRIVATE).edit();
                            editor.putString("username",getusername);
                            editor.apply();

                            Intent i=new Intent(getApplicationContext(),DisplayActivity.class);
                            startActivity(i);

                        }
                        else{
                            Toast.makeText(getApplicationContext(),"invalid",Toast.LENGTH_LONG).show();
                        }
                       getid=cursor.getString(0);
                        Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();


}
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Registeractivity.class);
                startActivity(i);
            }
        });
    }
}
