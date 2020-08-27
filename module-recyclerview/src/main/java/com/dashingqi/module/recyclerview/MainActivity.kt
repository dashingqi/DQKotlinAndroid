package com.dashingqi.module.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var data = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configRv()
    }

    private fun configRv() {
        for (index in 0..60) {
            data.add("item $index")
        }
        rv.layoutManager = CustomLayoutManager()
        rv.adapter = RVAdapter(data)
    }
}
