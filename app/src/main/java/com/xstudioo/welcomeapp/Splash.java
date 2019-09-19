package com.xstudioo.welcomeapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {
    LuncherManager luncherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        luncherManager = new LuncherManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(luncherManager.isFirstTime()){
                    luncherManager.setFirstLunch(false);
                    startActivity(new Intent(getApplicationContext(),Slider.class));
                }else {
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));

                }

            }
        },2000);
    }
}
