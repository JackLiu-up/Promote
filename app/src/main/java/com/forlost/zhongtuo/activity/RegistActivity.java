package com.forlost.zhongtuo.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
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
    private EditText nick_name, pwd, regist_email, realcode;
    private TextView emailCode;
    private Button regist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initData();
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (realcode == null || nick_name == null || pwd == null || regist_email == null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegistActivity.this, "请填满信息", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                doRegByApi();
            }
        });
    }

    private void initData() {
        regist = findViewById(R.id.regist);
        nick_name = findViewById(R.id.regist_nickname);
        pwd = findViewById(R.id.regist_pwd);
        realcode = findViewById(R.id.code);
        emailCode = findViewById(R.id.email_code);
        regist_email = findViewById(R.id.EmailAddress);
        emailCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DtdHttpHelper.getInstance().getEmailCodeForReg(regist_email.getText().toString(), new DtdHttpCallback<Void>() {
                    @Override
                    public void onSuccess(Void result) {
                        super.onSuccess(result);
                        Toast.makeText(RegistActivity.this, "验证码已发送成功 :", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(String msg) {
                        super.onFailure(msg);
                        Toast.makeText(RegistActivity.this, "验证码发送失败 :" + msg, Toast.LENGTH_SHORT).show();
                    }
                });

            };

        });
    }

    private void doRegByApi() {
        String userName = nick_name.getText().toString();
        String password = pwd.getText().toString();
        String email = regist_email.getText().toString();
        String code = realcode.getText().toString();

        DtdHttpHelper.getInstance().regist(userName, password, email, code, new DtdHttpCallback<Void>() {
            @Override
            public void onSuccess(Void result) {
                super.onSuccess(result);
                //注册成功
                startActivity(new Intent(RegistActivity.this, LoginActivity.class));
            }

            @Override
            public void onFailure(final String msg) {
                super.onFailure(msg);
                Toast.makeText(RegistActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    };

}
