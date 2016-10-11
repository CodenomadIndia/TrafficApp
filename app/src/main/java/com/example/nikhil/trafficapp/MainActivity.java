package com.example.nikhil.trafficapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the components of the Login Page
        init();
        //Add action Listener to the button login
        login.setOnClickListener(this);

    }

    private void init(){
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.login);
    }

    @Override
    public void onClick(View v) {
        //Validate the Input EditText Fields
        validinput();

        if(isConnected()){
            String url1 = "http://k53ldts.org/api/index.php/login/";
            String uname = username.getText().toString();
            String pass = password.getText().toString();
            //String data = "{\"username\":\""+uname+"\", \"password\": \""+pass+"\"}";
            String data = "{\"username\":\"admin\", \"password\": \"admin\"}";
            try {
                HttpPostingData htdp = new HttpPostingData(url1, data);
                String res = htdp.getRes();
                System.out.print(res+"niksdfsdfsdfsdfsdfsdfhil");
                Toast.makeText(this, res, Toast.LENGTH_LONG);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }else{
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_LONG).show();
        }




    }

    //Validating the data
    private void validinput(){

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
