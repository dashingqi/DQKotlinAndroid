package com.dashingqi.module.recyclerview.diff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import com.dashingqi.module.recyclerview.Food
import com.dashingqi.module.recyclerview.FoodViewModel
import com.dashingqi.module.recyclerview.R
import kotlinx.android.synthetic.main.activity_diff_util.*

class DiffUtilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diff_util)
        var foodViewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        val adapter = DiffUtilAdapter(foodViewModel.items)
        foodRv.adapter = adapter

        diffData.setOnClickListener {
            val newList = ArrayList<Food>()
            adapter.datas.forEach {
                it.name = "1"
                newList.add(it)
            }
            var calculateDiff =
                DiffUtil.calculateDiff(DiffUtilCallBack(adapter.datas, newList), true)
            calculateDiff.dispatchUpdatesTo(adapter)

        }
    }
}