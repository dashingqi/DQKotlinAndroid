package com.dashingqi.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_view_model.*

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        //获取到ViewModel
        var viewModelDemo = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return ViewModelDemo("test") as T
            }

        }).get(ViewModelDemo::class.java)
        Log.d("viewModelDemo -->", viewModelDemo.toString())
        Log.d("liveData --> ", viewModelDemo.liveData.toString())
        text.text = viewModelDemo.liveData.value.toString()
        tvStr.text = viewModelDemo.liveDataStr.value
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }
}