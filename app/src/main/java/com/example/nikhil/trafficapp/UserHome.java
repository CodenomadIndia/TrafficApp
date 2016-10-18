package com.example.nikhil.trafficapp;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Nikhil on 10/13/2016.
 */

public class UserHome extends AppCompatActivity {
    SessionManager sessionManager;
    ImageView img;
    Bitmap bitmap;
    ProgressDialog pDialog;
    TextView client_name, id_number, client_address, client_phone, client_appointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        init();


    }

    private void init(){
        sessionManager = new SessionManager(this);
        String photourl = sessionManager.photourl();
        img = (ImageView)findViewById(R.id.imageView2);
        new LoadImage().execute(photourl);
        client_name = (TextView)findViewById(R.id.client_name);
        id_number = (TextView)findViewById(R.id.id_number);
        client_phone = (TextView)findViewById(R.id.client_phone);
        client_address = (TextView)findViewById(R.id.client_address);
        client_appointment = (TextView)findViewById(R.id.client_appointment);
        client_name.setText(sessionManager.fullname());
        id_number.setText(sessionManager.idnumber());
        client_address.setText(sessionManager.address());
        client_phone.setText(sessionManager.phonenumber());

    }

    private class LoadImage extends AsyncTask<String, String, Bitmap> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(UserHome.this);
            pDialog.setMessage("Loading Image ....");
            pDialog.show();

        }
        protected Bitmap doInBackground(String... args) {
            try {
                bitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap image) {

            if(image != null){
                img.setImageBitmap(image);
                pDialog.dismiss();

            }else{

                pDialog.dismiss();
                Toast.makeText(UserHome.this, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();

            }
        }
    }
}
