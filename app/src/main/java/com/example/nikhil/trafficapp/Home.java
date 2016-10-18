package com.example.nikhil.trafficapp;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by Nikhil on 10/12/2016.
 */

public class Home extends AppCompatActivity implements View.OnClickListener {
    SessionManager sessionmanager;
    Button loadprofile;
    EditText idnumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        init();
        loadprofile.setOnClickListener(this);


    }

    private void init(){
        sessionmanager = new SessionManager(Home.this);
        loadprofile = (Button)findViewById(R.id.loadProfile);
        idnumber = (EditText)findViewById(R.id.idNumber);
    }

    @Override
    public void onClick(View v) {
        if(validinput()) {
            if (isConnected()) {
                String url1 = "http://k53ldts.org/api/index.php/loadprofile/";
                String user_id = idnumber.getText().toString();
                String data = "{\"user_id\":\"" + user_id + "\"}";
                try {
                    HttpPostingData htdp = new HttpPostingData(url1, data);
                    String res = htdp.getRes();
                    //System.out.print(res);
                    //Toast.makeText(this, res, Toast.LENGTH_LONG).show();
                    JSONObject jsonObject = new JSONObject(res);
                    JSONArray arr = jsonObject.getJSONArray("result");
                    for(int i=0; i<arr.length(); i++){
                        JSONObject o = arr.getJSONObject(i);

                        if(o.getString("id").matches("")){
                            Toast.makeText(this, "Wrong ID Number.", Toast.LENGTH_LONG).show();
                        }else{
                            String name = o.getString("fullname");
                            String idnumber = o.getString("user_id");
                            String address = o.getString("address");
                            String phonenumber = o.getString("phone");
                            String testdate = o.getString("test_date");
                            String testtime = o.getString("time");
                            String photourl = o.getString("photo");
                           // Toast.makeText(this, idnumber, Toast.LENGTH_LONG).show();
                            sessionmanager.learnerProfile(name, idnumber, address, phonenumber, testdate, testtime, photourl);
                            Intent it = new Intent(this, UserHome.class);
                            startActivity(it);

                        }
                    }

                }catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    //Validating the data
    private boolean validinput(){
        if(idnumber.getText().toString().matches("")){
            Toast.makeText(this, "Fields cann't be left blank", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }

    }

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
}
