package com.mca.administrator.productapp;

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
EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8;
    Button b,b1,b2;
    String getpcode,getpname,getprice,getpmodel,getpsellername,getOname,getOmobileno,getnewpname,getnewprice,getnewpmodel,getnewpsellername,getnewOname,getnewOmobileno,getid;
    ProductHelper productHelper;
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
                        boolean status=productHelper.DeleteData(getid);
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
                Toast.makeText(getApplicationContext(),"No Clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        ed1=(EditText)findViewById(R.id.pcode);
        ed2=(EditText)findViewById(R.id.pname);
        ed3=(EditText)findViewById(R.id.price);
        ed4=(EditText)findViewById(R.id.pmodel);
        ed5=(EditText)findViewById(R.id.psellername);


        ed7=(EditText)findViewById(R.id.Oname);
        ed8=(EditText)findViewById(R.id.Omobileno);


        productHelper=new ProductHelper(this);
        productHelper.getWritableDatabase();
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
                getnewpname=ed2.getText().toString();
                getnewprice=ed3.getText().toString();
                getnewpmodel=ed4.getText().toString();
                getnewpsellername=ed5.getText().toString();
                getnewOname=ed7.getText().toString();
                getnewOmobileno=ed8.getText().toString();
                boolean status=productHelper.UpdateData(getid,getnewpname,getnewprice,getnewpmodel,getnewpsellername,getnewOname,getnewOmobileno);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getpcode = ed1.getText().toString();
                Log.d("pcode",getpcode);
                getpname= ed2.getText().toString();
                getprice= ed3.getText().toString();
                getpmodel= ed4.getText().toString();
                getpsellername= ed5.getText().toString();

                getOname= ed7.getText().toString();
                getOmobileno= ed8.getText().toString();


                Cursor cursor=productHelper.SearchData(getpcode);
                if (cursor.getCount() == 0) {
                    Toast.makeText(getApplicationContext(), "No Name Found", Toast.LENGTH_LONG).show();
                } else {
                    while (cursor.moveToNext())
                    {
                        getpname=cursor.getString(3);
                        Toast.makeText(getApplicationContext(), getpname, Toast.LENGTH_LONG).show();
                        getprice=cursor.getString(5);
                        Toast.makeText(getApplicationContext(), getprice, Toast.LENGTH_LONG).show();
                        getpmodel=cursor.getString(1);
                        Toast.makeText(getApplicationContext(), getpmodel, Toast.LENGTH_LONG).show();
                        getpsellername=cursor.getString(4);
                        Toast.makeText(getApplicationContext(), getpsellername, Toast.LENGTH_LONG).show();

                        getOname=cursor.getString(6);
                        Toast.makeText(getApplicationContext(), getOname, Toast.LENGTH_LONG).show();
                        getOmobileno=cursor.getString(7);
                        Toast.makeText(getApplicationContext(), getOmobileno, Toast.LENGTH_LONG).show();
getid=cursor.getString(0);
                        Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();
                        ed2.setText(getpname);
                        ed3.setText(getprice);
                        ed4.setText(getpmodel);
                        ed5.setText(getpsellername);


                        ed7.setText(getOname);
                        ed8.setText(getOmobileno);

                    }
                }



            }
        });
    }
}
