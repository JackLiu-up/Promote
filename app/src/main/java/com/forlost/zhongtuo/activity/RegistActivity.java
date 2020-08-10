package com.forlost.zhongtuo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.forlost.zhongtuo.R;
import com.forlost.zhongtuo.helper.httphelper.DtdHttpCallback;
import com.forlost.zhongtuo.helper.httphelper.DtdHttpHelper;
import com.forlost.zhongtuo.ui.base.MyBaseActivity;


public class RegistActivity extends MyBaseActivity {
    public static final int RQ_QRCODE_FOR_LOGIN = 101;
    public static final String TAG = "RegistActivity";
    private Button btn_regist;
    private EditText nick_name, pwd,regist_email;
    private TextView emailCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initData();
    }

    private void initData() {
        nick_name = findViewById(R.id.regist_nickname);
        pwd = findViewById(R.id.regist_pwd);
        emailCode = findViewById(R.id.email_code);
        regist_email = findViewById(R.id.EmailAddress);
    }

    private void doRegByApi(){
        String userName = nick_name.getText().toString();
        String password = pwd.getText().toString();
        String email = regist_email.getText().toString();
        String code = emailCode.getText().toString();

        DtdHttpHelper.getInstance().regist(userName,password,email,code, new DtdHttpCallback<Void>(){
            @Override
            public void onSuccess(Void result) {
                super.onSuccess(result);
                //登录成功
                startActivity(new Intent(RegistActivity.this, LoginActivity.class));
            }

            @Override
            public void onFailure(final String msg) {
                super.onFailure(msg);
                Toast.makeText(RegistActivity.this, "注册失败 :"+msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
