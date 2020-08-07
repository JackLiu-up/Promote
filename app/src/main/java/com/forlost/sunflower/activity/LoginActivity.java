package com.forlost.sunflower.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.forlost.sunflower.R;
import com.forlost.sunflower.ui.base.AdBaseActivity;
import com.forlost.sunflower.ui.base.MyBaseActivity;

public class LoginActivity extends MyBaseActivity implements View.OnClickListener {
    public static final int RQ_QRCODE_FOR_LOGIN = 101;
    public static final String TAG = "LoginActivity";
    private Button btn_login, btn_regist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();

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