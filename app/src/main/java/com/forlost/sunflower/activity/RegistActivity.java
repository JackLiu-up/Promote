package com.forlost.sunflower.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.forlost.sunflower.R;
import com.forlost.sunflower.ui.base.AdBaseActivity;
import com.forlost.sunflower.ui.base.MyBaseActivity;


public class RegistActivity extends MyBaseActivity {
    public static final int RQ_QRCODE_FOR_LOGIN = 101;
    public static final String TAG = "RegistActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
    }
}
