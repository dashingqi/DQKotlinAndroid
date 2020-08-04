package com.dashingqi.module.lambda.Sequence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dashingqi.module.lambda.Person
import com.dashingqi.module.lambda.R
import kotlinx.android.synthetic.main.activity_sequence.*

class SequenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sequence)

        btnAsSequence.setOnClickListener {
            asSequenceMethod()
        }

        btnGenerateSequence.setOnClickListener {
            generateSequenceMethod()
        }


    }

    /**
     * 序列的使用
     * 在我们平常的链式调用中
     * var nameStartWith = people.map{it.name}.filter{it.startWith("a")}
     * 在这个中间 map需要使用一个集合来保存数据
     * filter操作也需要一个集合老保存最终的结果值
     * 中间需要创建两个临时的集合来保存数据，如果数据量少的情况下还好，如果大数据量这样操作的话，性能上不好，占用内存
     * 这时候就需要序列出场了---> 为了提高效率可以把操作变成使用序列而不是列表（集合）
     */
    private fun asSequenceMethod() {
        val people = listOf(
            Person("person1", 23),
            Person("person2", 22),
            Person("person3", 26),
            Person("person4", 21),
            Person("person5", 20)
        )

        var peopleIs22 = people.map { it.age }.filter { it == 23 }

        println("peopleIs22 ---> $peopleIs22")


        var peopleSequenceIs22 = people.asSequence().map {
            println("map is perform")
            it.age
        }.filter {
            println("filter is perform")
            it == 23
        }.toList()

        println("peopleSequenceIs22 -----> $peopleSequenceIs22")
    }

    /**
     * 创建序列
     */
    private fun generateSequenceMethod() {
        val generateSequenceResult = generateSequence(1) { it * 3 }
        val resultSequence = generateSequenceResult.takeWhile { it<=100 }

        println("generateSequenceResult ---> ${resultSequence.sum()}")
    }
}