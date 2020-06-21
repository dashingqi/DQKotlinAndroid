package com.dashingqi.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_swit_map_main.*

class SwitMapMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swit_map_main)
        var switchMapViewModel = ViewModelProvider(this)[SwitchMapViewModel::class.java]
        switchMapViewModel.transformationsLiveData.observe(this, Observer {
            it.let { value ->
                nameText.text = value
            }

        })

        setUser.setOnClickListener {
            var person = Person()
            person.firstName = "zhang"
            person.lastName = "qi"
            //当切换 true或者false观察控件显示是否发生变化了呢
            person.condition = false
            switchMapViewModel.conditionLiveData.postValue(person)
        }
    }
}