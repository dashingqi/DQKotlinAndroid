package com.dashingqi.viewmodeldemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        //通过ViewModelProviders来获取奥ViewModel的实例
        viewModel = ViewModelProviders.of(this, MainViewModelFactory(countReserved))
            .get(MainViewModel::class.java)
        val viewModels = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(countReserved) as T
            }
        })
        plusOneBtn.setOnClickListener {
            viewModel.counter++
            refreshCounter()
        }

        refreshCounter()

        jump.setOnClickListener {

            startActivity(Intent(this, ViewModelActivity::class.java))
        }

    }

    private fun refreshCounter() {
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit().putInt("count_reserved", viewModel.counter).apply()
    }
}
