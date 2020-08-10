package com.forlost.zhongtuo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

import androidx.multidex.MultiDexApplication;

import com.forlost.zhongtuo.helper.ApplicationHelper;

import java.util.List;

public class MyApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //所有的全局方法都放到ApplicationHelper
        if (isMainProcess()) {
            ApplicationHelper.getInstance().init(this);
        }

    }

    private boolean isMainProcess() {
        ActivityManager am = ((ActivityManager) getSystemService(Context.ACTIVITY_SERVICE));
        if (am == null) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> processInfos = am.getRunningAppProcesses();
        String mainProcessName = getPackageName();
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo info : processInfos) {
            if (info.pid == myPid && mainProcessName.equals(info.processName)) {
                return true;
            }
        }
        return false;
    }
}
