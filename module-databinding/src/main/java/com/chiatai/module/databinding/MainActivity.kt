package com.chiatai.module.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.chiatai.module.databinding.databinding.ActivityMainBinding
import com.chiatai.module.databinding.inverse.InverseViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var activityBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        activityBinding.lifecycleOwner = this
        val inverseViewModel = ViewModelProvider(this).get(InverseViewModel::class.java)
        activityBinding.viewModel = inverseViewModel

        inverseViewModel.inverseBean.index.observe(this, Observer {
            it?.let {
                Log.e("inverse", "index == $it")
            }
        })

    }
}
