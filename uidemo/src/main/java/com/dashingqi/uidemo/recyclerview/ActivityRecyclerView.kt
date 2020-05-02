package com.dashingqi.uidemo.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dashingqi.uidemo.Fruit
import com.dashingqi.uidemo.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class ActivityRecyclerView : AppCompatActivity() {


    private val fruits = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initFruits()
        fruitRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ActivityRecyclerView)
            adapter = FruitRecyclerAdapter(fruits)
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
