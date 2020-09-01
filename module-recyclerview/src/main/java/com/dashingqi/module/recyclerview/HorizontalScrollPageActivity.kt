package com.dashingqi.module.recyclerview

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.dqcommonutils.DensityUtils
import com.dashingqi.module.recyclerview.databinding.ActivityHorizontalScrollPageBinding
import kotlinx.android.synthetic.main.activity_horizontal_scroll_page.*

class HorizontalScrollPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityHorizontalScrollPageBinding>(
            this,
            R.layout.activity_horizontal_scroll_page
        )

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(scrollPageRv)
        scrollPageRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
               val childPosition =  parent.getChildAdapterPosition(view)
                if (childPosition==0) {
//                    outRect.left = DensityUtils.dip2pxInt(parent.context, 16f)
                }else{
                    outRect.left = DensityUtils.dip2pxInt(parent.context, 6f)
                }

//                if (childPosition == 6){
//                    outRect.left = DensityUtils.dip2pxInt(parent.context, 16f)
//                }
            }
        })
        dataBinding.viewModel = HorizontalScrollPageViewModel()
    }
}