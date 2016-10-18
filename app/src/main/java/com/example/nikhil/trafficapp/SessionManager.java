package com.example.nikhil.trafficapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nikhil on 10/13/2016.
 */

public class SessionManager {
    SharedPreferences sh;
    SharedPreferences.Editor t1;
    SessionManager(Context t){
        sh = t.getSharedPreferences("session_data", 0);
        t1 = sh.edit();
        //init();
    }

    private void init(){
        try{
            t1.putString("user_id", "");
            t1.putString("user_type", "");
            t1.putString("fullname", "");
            t1.putString("idnumber", "");
            t1.putString("address", "");
            t1.putString("phonenumber", "");
            t1.putString("testdate", "");
            t1.putString("testtime", "");
            t1.commit();
        }catch (Exception ee){}
    }

    void loggingIn(String user_type, String user_id){
        try{
            t1.putString("user_id", user_id);
            t1.putString("user_type", user_type);
            t1.commit();
        }catch (Exception ee){}
    }

    void learnerProfile(String name, String idnumber, String address, String phonenumber, String testdate, String testtime, String photourl){
        try{
            t1.putString("fullname", name);
            t1.putString("idnumber", idnumber);
            t1.putString("address", address);
            t1.putString("phonenumber", phonenumber);
            t1.putString("testdate", testdate);
            t1.putString("testtime", testtime);
            t1.putString("photourl", photourl);
            t1.commit();
        }catch (Exception ee){}

    }

    public String getUserType(){
        return  sh.getString("user_type", "");
    }
    public String getUserId() {
        return sh.getString("user_id", "");
    }
    public String fullname() {
        return sh.getString("fullname", "");
    }
    public String idnumber() {
        return sh.getString("idnumber", "");
    }
    public String address() {
        return sh.getString("address", "");
    }
    public String phonenumber() {
        return sh.getString("phonenumber", "");
    }
    public String testdate() {
        return sh.getString("testdate", "");
    }
    public String testtime() {
        return sh.getString("testtime", "");
    }
    public String photourl() {
        return sh.getString("photourl", "");
    }

    void loggingOut(){
        init();
    }


}
