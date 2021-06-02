package com.dashingqi.module.system.info

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * @author zhangqi61
 * @since 6/2/21
 */
class ChangeSimReceiver : BroadcastReceiver() {
    private  val TAG = "MainActivity"
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive: ")
    }
}