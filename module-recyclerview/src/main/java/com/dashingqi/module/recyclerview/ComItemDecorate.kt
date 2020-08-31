package com.dashingqi.module.recyclerview

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.dqcommonutils.DensityUtils

/**
 * @author : zhangqi
 * @time : 2020/8/31
 * desc :
 */
class ComItemDecorate : RecyclerView.ItemDecoration() {

    var drawPaint: Paint = Paint()

    init {
        drawPaint.isAntiAlias = true
        drawPaint.color = Color.RED
    }

    /**
     * outRect 是一个为0的Rect，填充在Item的四周
     * view：指代着每一个Item
     */
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        // 让item的rect的底部 高度设置为16f
        outRect.bottom = DensityUtils.dip2pxInt(parent.context, 16f)

    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        // item数
        val childItemCount = parent.childCount

        for (index in 0..childItemCount-1) {
            val itemView = parent.getChildAt(index)
            val top = itemView.top
            val left = parent.paddingLeft
            val right = parent.paddingRight
            val bottom = itemView.top + DensityUtils.dip2pxInt(parent.context, 16f)
            val rect = Rect(top, left, right, bottom)
            c.drawRect(rect, drawPaint)
        }
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
    }
}