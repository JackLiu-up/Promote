package com.forlost.sunflower.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.forlost.sunflower.R;
import com.forlost.sunflower.ui.base.MyBaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends MyBaseActivity {

    //启动页
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer timer = new Timer();
        timer.schedule( new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,LoginActivity.class));
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                       Toast.makeText(SplashActivity.this,"欢迎进入登录界面",Toast.LENGTH_SHORT).show();
                   }
               });
             }
        },2000);



    }

}