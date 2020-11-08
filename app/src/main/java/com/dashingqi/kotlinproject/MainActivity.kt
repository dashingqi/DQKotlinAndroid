package com.dashingqi.kotlinproject

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dashingqi.kotlinproject.compare.CompareMain
import com.dashingqi.kotlinproject.compare.PersonComapre
import java.lang.StringBuilder
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //声明不可变的引用  val引用自身是不可变的，但是它指向的对象是可变的。
        val language = arrayListOf("Java")
        //改变引用执行的对象
        language.add("Kotlin")


        val a: Int
        a = 43

        //val声明的变量只能进行唯一一下赋值

        val message: String
        if (5 > 4) {
            message = "hahah"
        } else {
            message = "heihei"
        }

        //调用构造方法不需要关键字new
        val person = Person("zhangqi", 23);

        //直接访问属性，但是调用的是getter
        println(person.name);
        println(person.age)


        val persons =
            arrayOf(
                com.dashingqi.kotlinproject.compare.Person(
                    67,
                    "zhangqi"
                ), com.dashingqi.kotlinproject.compare.Person(63, "dashingqi")
            )
        Log.d(TAG, "比较之前${get(persons)}")

        //使用了自定义比较器，Person类完全不用做任何修改
        Arrays.sort(persons, PersonComapre())
        Log.d(TAG, "比较之后${get(persons)}")
    }

    fun get(array: Array<com.dashingqi.kotlinproject.compare.Person>): String {
        return StringBuilder().apply {
            array.forEach {
                this.append(it.toString())
            }
        }.toString()
    }
}
