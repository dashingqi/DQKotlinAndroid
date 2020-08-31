package com.dashingqi.module.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dashingqi.module.recyclerview.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //绑定ViewModel
        mainBinding.viewModel = FoodViewModel()
        rv.addItemDecoration(ComItemDecorate())

        btnJump.setOnClickListener {
            Intent(this, GridLayoutManagerActivity::class.java)
                .apply {
                    startActivity(this)
                }
        }
    }

}
