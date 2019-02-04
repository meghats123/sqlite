package com.mca.administrator.movieapp;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9;
    Button b,b1,b2;
    String getMname,getMactor,getMactress,getRyear,getDirector,getProducer,getCameraman,getTcollection,getMlanguage,getnewMlanguage,getnewMactor,getnewactress,getnewRyear,getnewDirector,getnewProducer,getnewCameraman,getnewTcollection,getid;
 MovieHelper movieHelper;
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
                                boolean status=movieHelper.DeleteData(getid);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(),"Yes clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"No Clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        ed1=(EditText)findViewById(R.id.Mname);
        ed2=(EditText)findViewById(R.id.Mlanguage);
        ed3=(EditText)findViewById(R.id.Mactor);
        ed4=(EditText)findViewById(R.id.Mactress);
        ed5=(EditText)findViewById(R.id.Ryear);
        ed6=(EditText)findViewById(R.id.Director);
        ed7=(EditText)findViewById(R.id.Producer);
        ed8=(EditText)findViewById(R.id.Cameraman);
        ed9=(EditText)findViewById(R.id.Tcollection);


     movieHelper=new MovieHelper(this);
        movieHelper.getWritableDatabase();
        b=(Button)findViewById(R.id.search);
        b1=(Button)findViewById(R.id.update);
        b2=(Button)findViewById(R.id.delete);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert=builder.create();
                alert.show();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getnewMlanguage=ed2.getText().toString();
                getnewMactor=ed3.getText().toString();
                getnewactress=ed4.getText().toString();
                getnewRyear=ed5.getText().toString();
                getnewDirector=ed6.getText().toString();
                getnewProducer=ed7.getText().toString();
                getCameraman=ed8.getText().toString();
                getTcollection=ed9.getText().toString();
                boolean status=movieHelper.UpdateData(getid,getnewMlanguage,getnewMactor,getnewactress,getnewRyear,getnewDirector,getnewProducer,getnewCameraman,getnewTcollection);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMname = ed1.getText().toString();
                Log.d("Mname", getMname);
                getMlanguage=ed2.getText().toString();
                getMactor = ed3.getText().toString();
                getMactress = ed4.getText().toString();
                getRyear = ed5.getText().toString();
                getDirector = ed6.getText().toString();
                getProducer = ed7.getText().toString();
                getCameraman = ed8.getText().toString();
                getTcollection = ed9.getText().toString();

                Cursor cursor = movieHelper.SearchData(getMname);
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No Name Found", Toast.LENGTH_LONG).show();
                } else {
                    while (cursor.moveToNext()) {
                        getMlanguage = cursor.getString(2);
                        Toast.makeText(getApplicationContext(), getMlanguage, Toast.LENGTH_LONG).show();
                        getMactor = cursor.getString(3);
                        Toast.makeText(getApplicationContext(), getMactor, Toast.LENGTH_LONG).show();
                        getMactress = cursor.getString(4);
                        Toast.makeText(getApplicationContext(), getMactress, Toast.LENGTH_LONG).show();
                        getRyear = cursor.getString(5);
                        Toast.makeText(getApplicationContext(), getRyear, Toast.LENGTH_LONG).show();
                        getDirector = cursor.getString(6);
                        Toast.makeText(getApplicationContext(), getDirector, Toast.LENGTH_LONG).show();

                        getProducer = cursor.getString(7);
                        Toast.makeText(getApplicationContext(), getProducer, Toast.LENGTH_LONG).show();
                        getCameraman = cursor.getString(8);
                        Toast.makeText(getApplicationContext(), getCameraman, Toast.LENGTH_LONG).show();
                        getTcollection = cursor.getString(9);
                        Toast.makeText(getApplicationContext(), getTcollection, Toast.LENGTH_LONG).show();
                        getid=cursor.getString(0);
                        Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();
                        ed2.setText(getMlanguage);
                        ed3.setText(getMactor);
                        ed4.setText(getMactress);
                        ed5.setText(getRyear);
                        ed6.setText(getDirector);
                        ed7.setText(getProducer);
                        ed8.setText(getCameraman);
                        ed9.setText(getTcollection);

                    }
                }
            }
        });

    }
}
