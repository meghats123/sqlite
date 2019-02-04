package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {
EditText ed1,ed2,ed3,ed4;
    ProgressBar progressBar;

    Button b;
    String  a,c,d,e, URL="http://logixspace.com/mzc/add.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed1=(EditText)findViewById(R.id.name);
        ed2=(EditText)findViewById(R.id.roll);
        ed3=(EditText)findViewById(R.id.admi);
        ed4=(EditText)findViewById(R.id.branch);
        progressBar=(ProgressBar)findViewById(R.id.pb);
        b=(Button)findViewById(R.id.addb);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=ed1.getText().toString();
                d=ed2.getText().toString();
                c=ed3.getText().toString();
                e=ed4.getText().toString();
               Toast.makeText(getApplicationContext(),"ADDED STUD",Toast.LENGTH_LONG).show();
progressBar.setVisibility(View.VISIBLE);
                addToDb();
            }
        });

    }

    private void addToDb() {

        //Toast.makeText(getApplicationContext(),"HELLO",Toast.LENGTH_LONG).show();
        StringRequest S=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject js =new JSONObject(response);
                            String responseFromServer=js.getString("status");
                            progressBar.setVisibility(View.GONE);
                            if (responseFromServer.equals("success"))
                            {

                              Toast.makeText(getApplicationContext(),"successfully registered",Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(getApplicationContext(),"error in registration",Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e1) {
                            Toast.makeText(getApplicationContext(),"exception in registration"+e1,Toast.LENGTH_LONG).show();

                            e1.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {
            //DATA TO BE SEND

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap <String, String>();
                params.put("name",a);
                params.put("admno",c);
                params.put("rollno",d);
                params.put("branch",e);
                return params;
            }
        };
       RequestQueue re= Volley.newRequestQueue(this);
        re.add(S);
    }
}
