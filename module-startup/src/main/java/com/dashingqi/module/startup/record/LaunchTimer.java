package com.dashingqi.module.startup.record;

import android.util.Log;

/**
 * @author : zhangqi
 * @time : 2020/10/8
 * desc :
 */
public class LaunchTimer {
    private static final String TAG = "LaunchTimer";

    private static long sTime;

    public static void startRecord() {
        sTime = System.currentTimeMillis();
    }

    public static void endRecord(String tag) {
        long endTime = System.currentTimeMillis() - sTime;
        Log.d(TAG, tag + " cost == " + endTime);
    }

    public static void endRecord() {
        endRecord("");
    }
}
