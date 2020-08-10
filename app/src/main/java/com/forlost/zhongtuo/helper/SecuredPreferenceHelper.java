package com.forlost.zhongtuo.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class SecuredPreferenceHelper {
    private static SecuredPreferenceHelper sInstance;
    private SharedPreferences sharedPreferences;

    private SecuredPreferenceHelper() {

    }

    public static SecuredPreferenceHelper getInstance() {
        if (sInstance == null) {
            synchronized (SecuredPreferenceHelper.class) {
                if (sInstance == null) {
                    sInstance = new SecuredPreferenceHelper();
                }
            }
        }
        return sInstance;
    }


    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public void init(Context context) {
        try {
            KeyGenParameterSpec keyGenParameterSpec = new KeyGenParameterSpec.Builder(
                    "_androidx_security_master_key_",
                    KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT
            )
                    .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                    .setKeySize(256)
                    .build();
            MasterKey masterKey = new MasterKey.Builder(context).setKeyGenParameterSpec(keyGenParameterSpec).build();
            sharedPreferences = EncryptedSharedPreferences.create(
                    context,
                    "ztmt_s_p",
                    masterKey,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
