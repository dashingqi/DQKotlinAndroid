package com.dashingqi.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        //重点是下面这个方法
        lifecycle.addObserver(Java8Observer())
    }
}