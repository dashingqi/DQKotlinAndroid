package com.dashingqi.module.recyclerview

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.dqcommonutils.DensityUtils
import com.dashingqi.module.recyclerview.databinding.ActivityRvAnimationBinding
import kotlinx.android.synthetic.main.activity_rv_animation.*

class RvAnimationActivity : AppCompatActivity() {

    private val animationDownToUp by lazy {
        AnimationUtils.loadAnimation(this, R.anim.item_anim_down_to_up)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityRvAnimationBinding>(
            this,
            R.layout.activity_rv_animation
        )


        val viewModel = ViewModelProvider(this)[RvAnimationViewModel::class.java]
        dataBinding.viewModel = viewModel
        var adapter = RvAnimationAdapter(viewModel.items, animRv)
        animRv.adapter = adapter


//        var animation = AnimationUtils.loadAnimation(this, R.anim.item_anim_translate)
//        val layoutAnimationController = LayoutAnimationController(animation)
//        //设置顺序
//        layoutAnimationController.order = LayoutAnimationController.ORDER_NORMAL
//        animRv.layoutAnimation = layoutAnimationController


        animRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                val childPosition = parent.getChildAdapterPosition(view)
                if (childPosition != 0) {
                    outRect.top = DensityUtils.dip2pxInt(parent.context, 16f)
                }
            }
        })
    }
}