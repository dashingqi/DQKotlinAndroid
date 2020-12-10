package com.dashingqi.module.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import com.dashingqi.dqcommonutils.MotionEventUtils

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        ev?.let {
            MotionEventUtils.printEvent(ev.action, "dispatchTouchEvent", TAG)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            MotionEventUtils.printEvent(event.action, "onTouchEvent", TAG)
        }
        return super.onTouchEvent(event)
    }
}