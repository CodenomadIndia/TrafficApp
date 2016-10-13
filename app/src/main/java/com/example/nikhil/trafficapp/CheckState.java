package com.example.nikhil.trafficapp;

import android.app.Application;

/**
 * Created by karwal on 13-10-2016.
 */

// class to keep track of activity state for network connectivity checking




public class CheckState extends Application {
    private static boolean activityVisible;

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }


}
