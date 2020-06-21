package com.dashingqi.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_map_live_data_main.*

class MapLiveDataMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_live_data_main)
        var viewModel = ViewModelProvider(this)[MapLiveDataViewModel::class.java]
        var person = Person()
        person.name = "DashingQi"
        person.sex = "man"

        viewModel.transformLiveData.observe(this, Observer {
            it?.let { value ->
                tvText.text = value
            }

        })
        setUser.setOnClickListener {
            viewModel.userLiveData.postValue(person)
        }


    }
}