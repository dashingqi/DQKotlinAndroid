package com.chiatai.module_kotlin_appoint

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.annotation.RequiresApi
import com.chiatai.module_kotlin_appoint.sp.SPDelegate
import java.math.BigDecimal
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val p1 = Point(10, 20)
        val p2 = Point(30, 40)

        // p1 + p2  ----->  p1.plus(p2)
        println("Point= ${p1 + p2}")

        var times = 'a'.times(4)
        Log.d("times ", "times = $times")

        val list = arrayListOf<Int>(1, 2)

        list += 3

        Log.d("list = ", "$list")

        Log.d("array = ", "${listOf(5, 6, 7, 8)}")

        val newList = list + listOf(7, 8, 9)
        Log.d("newList = ", "$newList")

        Log.d("tag", "${-p1}")

        Log.d("tag", "${+p1}")

        var bd = BigDecimal.ZERO

        // 后加 先返回 bg的值 在进行++ 打印的bd值之后在进行 ++ 此时 bd = 1
        Log.d(TAG, "${bd++}")

        // 前缀加 先进行++ 在返回值 进行打印
        Log.d(TAG, "${++bd}")

        Log.d(TAG, "${Point(10, 20) == Point(10, 20)}")
        Log.d(TAG, "${Point(10, 20) != Point(5, 5)} ")
        Log.d(TAG, "${null == Point(10, 2)} ")

        // 排序运算符 compareTo    实现了Comparable接口

        val person1 = Person("zhang", "qi")
        val person2 = Person("hei", "ha")
        // a>=b ----> a.compareTo(b)>=0
        Log.d(TAG, "${person1 > person2}: ")

        var i = p1[0]
        Log.d(TAG, "i == $i")

        val mutablePoint = MutablePoint(50, 70)
        mutablePoint[0] = 60
        Log.d(TAG, "mutablePoint == $mutablePoint")


        val rectangle = Rectangle(Point(20, 90), Point(100, 1000))

        val rectanglePoint = Point(0, 999)

        Log.d(TAG, "is in ? = ${rectanglePoint in rectangle} ")

        // a in b  ----> b.contains(a) in约定
        Log.d(TAG, "${Point(50, 800) in rectangle}: ")

        val now = LocalDate.now()

        val vacation = now..now.plusDays(10)
        Log.d(TAG, " week - > ${now.plusWeeks(1) in vacation}")

        //解构声明和组件函数

        val point2 = Point(50, 60)

        // val x = point2.x
        // val y = point2.y
        val (x, y) = point2

        Log.d(TAG, "x = $x y =$y ")


        val (name, extension) = separateFile("java.kt")

        Log.d(TAG, "name = $name extension = $extension")

        val map = mutableMapOf<String, String>(Pair("zhang", "java"), Pair("dashing", "ios"))

        val map1 = mapOf<String, String>("zhangqi" to "android", "dashingqi" to "ios")

        printMap(map)

        printMap(map1)

        //



        var spValue: String by SPDelegate("spValue", "12")
//
        spValue = "134"
        Log.e(TAG, "onCreate: ${spValue}")


    }
}