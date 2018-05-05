package com.example.uhylabr.yourguide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       final Runnable launchLogin = new Runnable() {
           @Override
           public void run() {
               launchLogin();
                finish();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(launchLogin, 500);
    }

    /**
     * Launch the Login Activity
     */
    public void launchLogin() {
        Intent launchLogin = new Intent(this, Login.class);
        startActivity(launchLogin);
    }
}
