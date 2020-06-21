package com.dashingqi.lifecycledemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class ExtendsActivity : Activity(), LifecycleOwner {
    private var lifecycleRegistry: LifecycleRegistry? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extends)
        //第一步：新建LifecycleRegister
        lifecycleRegistry = LifecycleRegistry(this)
        //第二步：设置lifecycleRegister的各种状态
        lifecycleRegistry!!.currentState = Lifecycle.State.CREATED
        //第三步：通知给对应的观察者对象
        lifecycle.addObserver(Java8Observer())

    }

    override fun onStart() {
        super.onStart()
        lifecycleRegistry!!.currentState = Lifecycle.State.STARTED
    }

    override fun onStop() {
        super.onStop()
        lifecycleRegistry!!.currentState = Lifecycle.State.CREATED
    }

    /**
     * 实现了LifecycleOwner接口，实现了该方法，返回了lifecycleRegistry对象
     */
    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry!!
    }
}