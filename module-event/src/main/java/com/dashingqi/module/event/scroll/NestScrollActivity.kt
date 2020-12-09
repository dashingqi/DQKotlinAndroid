package com.dashingqi.module.event.scroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dashingqi.module.event.R
import kotlinx.android.synthetic.main.activity_nest_scroll.*

class NestScrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nest_scroll)
        initRvData()
    }

    private fun initRvData() {
        var dataList = ArrayList<String>()

        for (index in 0..30) {
            dataList.add("$index")
        }

        val scrollAdapter = NestScrollAdapter(dataList)
        rv.adapter = scrollAdapter
    }
}