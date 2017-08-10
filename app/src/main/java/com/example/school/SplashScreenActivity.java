package com.example.school;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ScrollView;

import static java.lang.Thread.sleep;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);


        Thread thread = new Thread() {
            public void run() {

                try {

                    sleep(3*1000);
                    Intent i=new Intent(getBaseContext(),LoginActivity.class);
                    startActivity(i);
                    finish();

                } catch (Exception e) {

                }
            }
        };

        thread.start();
    }
}
