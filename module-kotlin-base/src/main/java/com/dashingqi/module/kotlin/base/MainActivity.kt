package com.dashingqi.module.kotlin.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    //声明一个name属性
    private lateinit var name: String

    private val age: Int by lazy {

        println("init age params")
        9
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("age ====> $age")

        name = "123"
    }
}
