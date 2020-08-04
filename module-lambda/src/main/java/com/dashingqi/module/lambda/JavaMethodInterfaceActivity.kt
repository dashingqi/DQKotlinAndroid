package com.dashingqi.module.lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_java_method_interface.*
import java.lang.StringBuilder

/**
 * Java函数式接口
 */
class JavaMethodInterfaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_method_interface)

        btnClickListener.setOnClickListener { view ->

            when (view.id) {
                R.id.btnClickListener -> {
                    println("btnCLickListener id click")
                    createAllDoneFunction().run()
                }
            }
        }

        btnWith.setOnClickListener {
            withMethod()
        }
        btnApply.setOnClickListener {
            applyMethod()
        }
    }

    fun createAllDoneFunction(): Runnable {
        return Runnable { println("runnable method perform") }
    }


    private fun withMethod() {
        val result = StringBuilder()
//
//        for (letter in 'A'..'Z') {
//            result.append(letter)
//        }

        with(result) {
            for (letter in 'a'..'z') {
                append(letter)
            }
        }

        println("result ---> ${result.toString()}")
    }

    private fun applyMethod() {
        val value = StringBuilder().apply {
            for (letter in 'c'..'a') {
                append(letter)
            }
        }

        println("value ---> ${value.toString()}")
    }


}