package com.example.nikhil.trafficapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nikhil on 10/13/2016.
 */

public class UserHome extends AppCompatActivity {
    ImageView iv;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);
        sessionManager = new SessionManager(this);
        String photourl = sessionManager.photourl();
        iv = (ImageView)findViewById(R.id.imageView2);
        URL url = null;
       /* try {
            url = new URL(photourl);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            iv.setImageBitmap(bmp);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }
}
