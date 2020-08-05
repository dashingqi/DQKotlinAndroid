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

        setStr(null)
    }


    /**
     * 这里声明的String属性是不能存储 null引用（空类型的）
     * 如果想要str能存储null引用，就得在String后面加上 ?
     *
     */
    private fun setStr(str: String?): Int? {
        return str?.length
    }
}
