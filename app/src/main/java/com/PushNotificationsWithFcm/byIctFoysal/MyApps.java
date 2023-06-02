package com.PushNotificationsWithFcm.byIctFoysal;

import android.app.Application;
import com.google.firebase.FirebaseApp;

public class MyApps extends Application {

    //initializeApp

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
