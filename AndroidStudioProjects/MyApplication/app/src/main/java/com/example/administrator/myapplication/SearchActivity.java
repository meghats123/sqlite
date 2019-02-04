package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SearchActivity extends AppCompatActivity {
    EditText e1, e2, e3, e5;
    Button b2;
    String p, q, r, t, url = "http://logixspace.com/mzc/search.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        e1 = (EditText) findViewById(R.id.admi);
        e2 = (EditText) findViewById(R.id.sname);
        e3 = (EditText) findViewById(R.id.roll);


        e5 = (EditText) findViewById(R.id.sbranch);
        b2 = (Button) findViewById(R.id.srch);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = e1.getText().toString();
                q = e2.getText().toString();
                r = e3.getText().toString();

                t = e5.getText().toString();
                //Toast.makeText(getApplicationContext(),"SUCCESSFULLY SEARCHED",Toast.LENGTH_LONG).show();
                searchdb();
            }
        });
    }

    private void searchdb() {
        StringRequest st = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json=new JSONObject(response);
                            String resFromServer=json.getString("status");
                            if(resFromServer.equals("success"))
                            {
                                e2.setVisibility(View.VISIBLE);
                                e3.setVisibility(View.VISIBLE);
                                e5.setVisibility(View.VISIBLE);


                                JSONArray jsonArray=json.getJSONArray("data");
                                for(int i=0; i<jsonArray.length();i++)
                                {

                                    JSONObject obj=jsonArray.getJSONObject(i);
                                    String name=obj.getString("name");
                                   e2.setText(name);
                                    String rollno=obj.getString("rollno");

                                    e3.setText(rollno);
                                    String branch=obj.getString("branch");

                                    e5.setText(branch);



                                    Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"invalid admission num",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }


        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>params=new HashMap<String, String>();
                params.put("admno",p);
                params.put("name",q);

                params.put("rollno",r);
                params.put("branch",t);


                return params;
            }
        };
        RequestQueue requestQ= Volley.newRequestQueue(this);
        requestQ.add(st);
    }
}
