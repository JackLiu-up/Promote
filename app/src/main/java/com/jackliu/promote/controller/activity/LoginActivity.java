package com.jackliu.promote.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.jackliu.promote.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login, btn_regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

         btn_login.setOnClickListener(this);
        btn_regist.setOnClickListener(this);
    }

    private void initView() {
        btn_login = findViewById(R.id.btn_login);
        btn_regist = findViewById(R.id.btn_regist);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
            case R.id.btn_regist:
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                break;
        }
    }
}