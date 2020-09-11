package com.dashingqi.module.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dashingqi.module.recyclerview.databinding.ActivityMyCustomerlayoutManagerBinding
import kotlinx.android.synthetic.main.activity_my_customerlayout_manager.*

class MyCustomerLayoutManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_customerlayout_manager)
        val dataBinding = DataBindingUtil.setContentView<ActivityMyCustomerlayoutManagerBinding>(
            this,
            R.layout.activity_my_customerlayout_manager
        )
        val viewModel = ViewModelProvider(this)[MyCustomerLayoutManagerViewModel::class.java]
        dataBinding.setVariable(BR.viewModel, viewModel)

        val adapter = RVAdapter(viewModel.items)
        rv.layoutManager = MyCustomLayoutManager()
        rv.adapter = adapter

    }
}