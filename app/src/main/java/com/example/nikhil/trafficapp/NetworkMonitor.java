package com.example.nikhil.trafficapp;
/**
 * Created by karwal on 13-10-2016.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class NetworkMonitor extends BroadcastReceiver {



        @Override
        public void onReceive(Context context, Intent intent) {

            if (CheckState.isActivityVisible() == true) {


                ConnectivityManager connectivityManager = (ConnectivityManager)
                        context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();

                if(activeNetInfo!=null){
                    if(activeNetInfo.getType()== ConnectivityManager.TYPE_WIFI || activeNetInfo.getType()== ConnectivityManager.TYPE_MOBILE)
                        Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(context, "NOT Connected", Toast.LENGTH_SHORT).show();


            }
        }
    }