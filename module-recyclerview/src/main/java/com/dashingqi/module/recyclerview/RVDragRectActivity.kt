package com.dashingqi.module.recyclerview

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.dqcommonutils.DensityUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_position.*
import java.util.*

class RVDragRectActivity : AppCompatActivity(), MyItemTouchHelperCallback.MyItemTouchHelperCallbackListener {
    val data = mutableListOf<Int>()
    private var rvDragRectAdapter: RVDragRectAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvdrag_rect)
        val rv = findViewById<RecyclerView>(R.id.rv)
        val notify = findViewById<Button>(R.id.notify)
        rv.layoutManager = LinearLayoutManager(this)
        rv.addItemDecoration(object : RecyclerView.ItemDecoration() {
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

        val itemTouchHelperCall = MyItemTouchHelperCallback(this)
        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCall)
        data.add(0)
        data.add(0)
        data.add(0)
        data.add(0)
        data.add(0)
        data.add(1)
        data.add(1)
        data.add(1)
        data.add(1)

        rvDragRectAdapter = RVDragRectAdapter(data, this, itemTouchHelper)
        rv.adapter = rvDragRectAdapter
        itemTouchHelper.attachToRecyclerView(rv)

        notify.setOnClickListener {
            val subList = data.subList(1, data.size - 1)
            val removeAll = data.removeAll(subList)
            data.add(0)
            data.add(0)
            data.add(0)
            data.add(0)
            data.add(1)
            data.add(1)
            data.add(1)
            data.add(1)
            rvDragRectAdapter?.notifyItemRangeChanged(1, data.size - 2)
        }
    }

    override fun onSwiped(adapterPosition: Int) {

    }

    override fun onMove(currentPosition: Int, targetPosition: Int): Boolean {
        if (!data.isNullOrEmpty()){
            Collections.swap(data, currentPosition, targetPosition)
            // 通知数据变化，同时给一个动画
            rvDragRectAdapter?.notifyItemMoved(currentPosition, targetPosition)
            return true
        }
        return false
    }
}