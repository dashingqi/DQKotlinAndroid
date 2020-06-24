package com.dashingqi.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_live_data_main.*

class LiveDataMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_main)
        //获取到ViewModel
        var viewModelDemo2 = ViewModelProvider(this)[ViewModelDemo2::class.java]
        //注册一个观察者，用于观察LiveData，当LiveData的数据源发生改变会通知到观察者中
        viewModelDemo2.liveData.observe(this, Observer {
            it?.let { value ->
                tvText.text = value
            }

        })

        btnChange.setOnClickListener {
            viewModelDemo2.liveData.value = "i am coming "

        }


    }
}