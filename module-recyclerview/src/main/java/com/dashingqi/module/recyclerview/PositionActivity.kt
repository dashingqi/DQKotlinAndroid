package com.dashingqi.module.recyclerview

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.dqcommonutils.DensityUtils
import com.dashingqi.module.recyclerview.databinding.ActivityPositionBinding
import kotlinx.android.synthetic.main.activity_position.*

class PositionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val positionDataBinding = DataBindingUtil.setContentView<ActivityPositionBinding>(
            this,
            R.layout.activity_position
        )
        positionDataBinding.viewModel = ViewModelProvider(this)[PositionViewModel::class.java]

        positionRv.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                // 获取可见区域内，ItemView在适配器中的角标( 实际的角标 ----> view绑定的数据角标是多少，这里获取到的position就是多少)
                val childAdapterPosition = parent.getChildAdapterPosition(view)
                Log.d("childAdapterPosition = ", "$childAdapterPosition")

                //可见区域内的 Item数量
                val childCount = parent.childCount
                Log.d("childCount = ", "$childCount")

                for (index in 0 until childCount) {
                    //获取可见区域内的ItemView
                    val itemView = parent.getChildAt(index)
                    Log.d("itemView --> ", "$itemView")
                }

                if (childAdapterPosition != 0) {
                    outRect.top = DensityUtils.dip2pxInt(parent.context, 16f)
                }
            }
        })

        positionRv.post {
            val manager = positionRv.layoutManager as LinearLayoutManager
            val firstVisibleItemPosition = manager.findFirstVisibleItemPosition()
            Log.d("firstVisibleItemPosit", "$firstVisibleItemPosition")
        }

        positionRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manager = recyclerView.layoutManager as LinearLayoutManager

                // 获取到当前可见视图中，第一条数据在Adapter中的角标位置，如果在ItemDecoration设置了Rect的间距，那么这个可见包括这个Rect
                val firstVisibleItemPosition = manager.findFirstVisibleItemPosition()
                Log.d("firstVisibleItemPosit", "$firstVisibleItemPosition")

                //获取到当前可见视图中，最后一条数据在Adapter中的角标位置，同样设置了Rect，那么这个可见包括设置的rect的区域
                val lastVisiblePos = manager.findLastVisibleItemPosition()
                Log.d("lastVisiblePos", "$lastVisiblePos")

                //获取到可见范围内，第一个显示完整的ItemView，对应在Adapter中的position，这个完整区域是报错设置的rect区域
                val firstCompletePos = manager.findFirstCompletelyVisibleItemPosition()
                Log.d("firstCompletePos", "$firstCompletePos")

                //获取到可见范围内，最后一个显示完整的ItemView，对应在Adapter中的position，这个完整区域是报错设置的rect区域
                val lastCompletePos = manager.findLastCompletelyVisibleItemPosition()
                Log.d("lastCompletePos", "$lastCompletePos")

                //获取到的是 所有Item的数量
                val itemCount = manager.itemCount
                Log.d("itemCount", "$itemCount")

                // manager获取的childCount 等同于 rv.childCount 获取到的是可见区域内的ItemView数量
                val childCount = manager.childCount
                Log.d("childCount ", "$childCount")
            }
        })
    }
}