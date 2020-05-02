package com.dashingqi.uidemo.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dashingqi.uidemo.Fruit
import com.dashingqi.uidemo.R
import kotlinx.android.synthetic.main.activity_list.*

class ActivityList : AppCompatActivity() {

    private val fruits = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initFruits()
        var fruitListAdapter = FruitListAdapter(fruits)
        fruitList.adapter = fruitListAdapter
        fruitList.setOnItemClickListener { _, _, position, _ ->
            var fruit = fruits[position]
            Toast.makeText(this, "this is ${fruit.fruitName}", Toast.LENGTH_LONG).show()
        }
    }

    private fun initFruits() {
        repeat(2) {
            fruits.add(Fruit("apple"))
            fruits.add(Fruit("orange"))
            fruits.add(Fruit("banana"))
            fruits.add(Fruit("pear"))
            fruits.add(Fruit("Grape"))
            fruits.add(Fruit("Strawberry"))
            fruits.add(Fruit("cherry"))
            fruits.add(Fruit("Mango"))
        }
    }
}
