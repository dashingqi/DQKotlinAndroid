package com.dashingqi.kotlinfunctionproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var hashSetOf = hashSetOf(1, 2, 3)
        println("hashSetOf == $hashSetOf set == ${hashSetOf::class.java}")
        var arrayListOf = arrayListOf(1, 2, 6, 8)
        println("arrayListOf === $arrayListOf")
        var hashMapOf = hashMapOf(1 to "one", 2 to "two", 3 to "three")
        println("hashMapOf === $hashMapOf")

        var string = arrayListOf("one", "two", "three")
        println("last == ${string.last()}")

        var numbers = arrayListOf(1, 56, 34, 6734)
        println("max == ${numbers.max()}")

        var joinToString = joinToString(numbers, "/", "%", "%")
        println("joinToString == $joinToString")
        var defaultParamList = joinToString(numbers)
        println(defaultParamList)

        Log.d(TAG, "${"kotlin".lastChar()}")

        var lists = arrayListOf(1, 2, 3, 4, 6, 8, 3, 43)
        println("lists ---> ${lists.joinToStrings()}")

        var button = Button(this)
        button.showOff()

        var view = View(this)
        view.showOff()

        var views: View = Button(this)
        views.showOff()

    }

//    private fun <T> joinToString(
//        collection: Collection<T>,
//        separator: String = "--> ",
//        prefix: String = "「",
//        postfix: String = "」"
//    ): String {
//        var result = StringBuilder(prefix)
//        for ((index, value) in collection.withIndex()) {
//            if (index > 0) result.append(separator)
//            result.append(value)
//        }
//
//        result.append(postfix)
//        return result.toString()
//    }
}
