package com.dashingqi.module.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dashingqi.module.recyclerview.databinding.ActivityMainBinding
import com.dashingqi.module.recyclerview.diff.DiffUtilActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //绑定ViewModel
        val foodViewModel = ViewModelProvider(this)[FoodViewModel::class.java]
        mainBinding.viewModel = foodViewModel
        rv.addItemDecoration(ComItemDecorate())

        btnJump.setOnClickListener {
            Intent(this, GridLayoutManagerActivity::class.java)
                .apply {
                    startActivity(this)
                }
        }

        btnStickHeader.setOnClickListener {
            Intent(this, StickHeaderActivity::class.java)
                .apply {
                    startActivity(this)
                }
        }

        btnPhotoWall.setOnClickListener {
            Intent(this, PhotoWallActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnHoriScrollPager.setOnClickListener {
            Intent(this, HorizontalScrollPageActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnLayoutControllerAnim.setOnClickListener {
            Intent(this, RvAnimationActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnPosition.setOnClickListener {
            Intent(this, PositionActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnRvAuto.setOnClickListener {
            Intent(this, RvAutoActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnCustomerLayoutManager.setOnClickListener {
            Intent(this, MyCustomerLayoutManagerActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnDiffUtil.setOnClickListener {
            Intent(this, DiffUtilActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnDragRect.setOnClickListener {
            Intent(this, RVDragRectActivity::class.java).apply {
                startActivity(this)
            }
        }

    }

    private fun isRight(intent:Intent){
        intent?.getStringExtra("")
    }

}
