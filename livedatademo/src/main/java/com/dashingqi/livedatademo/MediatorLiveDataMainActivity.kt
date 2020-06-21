package com.dashingqi.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_mediator_live_data_main.*

class MediatorLiveDataMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mediator_live_data_main)
        var mediatorLiveDataViewModel =
            ViewModelProvider(this)[MediatorLiveDataViewModel::class.java]
        mediatorLiveDataViewModel.mediatorLiveData.observe(this, Observer {
            text.text = it
        })

        setLiveData1.setOnClickListener {
            mediatorLiveDataViewModel.liveData1.postValue("liveData1")
        }

        setLiveData2.setOnClickListener {
            mediatorLiveDataViewModel.liveData2.postValue("liveData2")
        }
    }
}