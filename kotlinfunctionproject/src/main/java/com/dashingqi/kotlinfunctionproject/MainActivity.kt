package com.dashingqi.kotlinfunctionproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

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

    }

    private fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
    ): String {
        var result = StringBuilder(prefix)
        for ((index, value) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(value)
        }

        result.append(postfix)
        return result.toString()
    }
}
