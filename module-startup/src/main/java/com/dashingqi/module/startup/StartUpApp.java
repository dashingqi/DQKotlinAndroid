package com.dashingqi.module.startup;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Debug;
import android.telephony.TelephonyManager;

import androidx.core.os.TraceCompat;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dashingqi.module.startup.record.LaunchTimer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;

/**
 * @author : zhangqi
 * @time : 2020/10/8
 * desc :
 */
public class StartUpApp extends Application {


    private Context mContext;

    /**
     * Application启动 最早我们能监听到的回调时机
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //开始时间的记录
        LaunchTimer.startRecord();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        TraceCompat.beginSection("APPOnCreate");
        //init bugly
        CrashReport.initCrashReport(getApplicationContext(), "", false);
        // init um
        UMConfigure.init(this, null, "aop_um", 0, "");
        // init fresco
        Fresco.initialize(this);
        //init ARouter
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        TraceCompat.endSection();

//        @SuppressLint("ServiceCast") TelephonyManager systemService = (TelephonyManager) getSystemService(Context.TELECOM_SERVICE);
//        String deviceId = systemService.getDeviceId();

    }
}
