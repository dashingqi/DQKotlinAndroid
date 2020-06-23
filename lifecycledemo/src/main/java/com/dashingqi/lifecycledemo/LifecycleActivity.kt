package com.dashingqi.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lifecycle.*

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        //重点是下面这个方法
        btn.setOnClickListener {
            lifecycle.addObserver(MyObserver(lifecycle))
        }


    }
}