package com.mca.administrator.sqlite;

import android.content.DialogInterface;
import android.database.Cursor;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button b,b1,b2;
    String getname,getemail,getnewvalue,getid;
    DatabaseHelper databaseHelper;
AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        builder=new AlertDialog.Builder(this);
        builder.setTitle("confirm");
        builder.setMessage("Are you sure want to delete ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        boolean status=databaseHelper.DeleteData(getid);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
                        Toast.makeText(getApplicationContext(),"Yes Clicked",Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });
builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Toast.makeText(getApplicationContext(),"No clicked",Toast.LENGTH_LONG).show();
dialogInterface.dismiss();
    }
});
                ed1 = (EditText) findViewById(R.id.name);
        ed2 = (EditText) findViewById(R.id.email);
        databaseHelper = new DatabaseHelper(this);
        databaseHelper.getWritableDatabase();
        b = (Button) findViewById(R.id.search);
        b1 = (Button) findViewById(R.id.update);
        b2 = (Button) findViewById(R.id.delete);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert=builder.create();
                alert.show();
//
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getnewvalue=ed2.getText().toString();
               boolean status=databaseHelper.UpdateData(getid,getnewvalue);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error In Updation",Toast.LENGTH_LONG).show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getname = ed1.getText().toString();
                Log.d("Name", getname);
                getemail=ed2.getText().toString();



                Cursor cursor = databaseHelper.SearchData(getname);
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No Name Found", Toast.LENGTH_LONG).show();
                } else {
while (cursor.moveToNext())
{
    getemail=cursor.getString(2);
    Toast.makeText(getApplicationContext(), getemail, Toast.LENGTH_LONG).show();
    getid=cursor.getString(0);
    Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();
    ed2.setText(getemail);
}
                }

            }
        });
    }
}
