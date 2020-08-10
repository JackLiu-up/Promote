package com.forlost.zhongtuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.forlost.zhongtuo.R;
import com.forlost.zhongtuo.helper.httphelper.DtdHttpCallback;
import com.forlost.zhongtuo.helper.httphelper.DtdHttpHelper;
import com.forlost.zhongtuo.ui.base.MyBaseActivity;

public class LoginActivity extends MyBaseActivity implements View.OnClickListener {
    public static final int RQ_QRCODE_FOR_LOGIN = 101;
    public static final String TAG = "LoginActivity";
    private Button btn_login, btn_regist;
    private EditText edit_name, edit_pwd;

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
        edit_name = findViewById(R.id.edit_name);
        edit_pwd = findViewById(R.id.edit_pwd);
    }

    private void loginByApi() {
        String userName = edit_name.getText().toString();
        String password = edit_pwd.getText().toString();
        DtdHttpHelper.getInstance().login(userName, password, new DtdHttpCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                super.onSuccess(result);
                //登录成功
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }

            @Override
            public void onFailure(final String msg) {
                super.onFailure(msg);
                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                loginByApi();
                break;
            case R.id.btn_regist:
                startActivity(new Intent(LoginActivity.this, RegistActivity.class));
                break;
        }
    }
}