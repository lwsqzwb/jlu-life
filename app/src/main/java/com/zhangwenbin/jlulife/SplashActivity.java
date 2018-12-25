package com.zhangwenbin.jlulife;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jlulife.zhangwenbin.mainpage.MainActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gotoMainPage();
        finish();
    }

    private void gotoMainPage() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
