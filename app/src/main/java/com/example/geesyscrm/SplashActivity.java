package com.example.geesyscrm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.geesyscrm.utilities.Session;

public class SplashActivity extends Activity {
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.splash_activity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  FirebaseApp.initializeApp(SplashActivity.this);
                //Log.e("FCM_TOKEN", FirebaseInstanceId.getInstance().getToken());
                if(Session.getInstance(SplashActivity.this).getLoginId()!=null&&Session.getInstance(SplashActivity.this).getLoginId().equals("")){
               /* if(checkPlayServices())
                {
                    Intent intent = new Intent(SplashActivity.this, MyFirebaseMessagingService.class);
                    startService(intent);
                }*/
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }else{
                    Log.e("Username",Session.getInstance(SplashActivity.this).getLoginUserName());

                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }


            }
        }, SPLASH_TIME_OUT);

    }
}
