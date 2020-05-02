package com.dashingqi.livedatademo

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myViewModel: MainViewModel
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getPreferences(Context.MODE_PRIVATE)
        val count = sp.getInt("count", 0)
        myViewModel =
            ViewModelProviders.of(this, MianViewModelFactory(count)).get(MainViewModel::class.java)
        btnPlusAdd.setOnClickListener {
            myViewModel.plusOne()
        }

        btnClear.setOnClickListener {
            myViewModel.clear()
        }

        myViewModel.counter.observe(this, Observer {
            tv.text = myViewModel.counter.value.toString()
        })
    }

    override fun onPause() {
        super.onPause()
        sp.edit().putInt("count", myViewModel.counter.value ?: 0).apply()
    }
}
