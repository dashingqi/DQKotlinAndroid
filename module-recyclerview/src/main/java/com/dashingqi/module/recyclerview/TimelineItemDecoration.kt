package com.dashingqi.module.recyclerview

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * @author : zhangqi
 * @time : 2020/8/31
 * desc :
 */
class TimelineItemDecoration : RecyclerView.ItemDecoration() {

    private val paint: Paint = Paint()

    private val offset = 120

    init {
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.RED
    }


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val position = parent.getChildAdapterPosition(view)
        //当是第一条数据的时候，不设置outRect的顶部
        val topOffset = offset
        if (position != 0) {
            outRect.top = topOffset
        }

        outRect.left = offset
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        // 条目个数
        val childItemCount = parent.childCount
        for (position in 0 until childItemCount) {
            // 对应的ItemView
            val itemView = parent.getChildAt(position)

            val index = parent.getChildAdapterPosition(itemView)

            // 第一个条目 没有做outRect的top拉伸
            var dividerTop = itemView.top - offset
            if (index == 0) {
                dividerTop = itemView.top
            }

            val dividerBottom = itemView.bottom

            val dividerLeft = parent.paddingLeft

            val dividerRight = parent.width - parent.paddingRight
            //画中心圆

            val radiusX = dividerLeft + offset / 2

            val radiusY = (dividerBottom - dividerTop) / 2 + dividerTop

            c.drawCircle(radiusX.toFloat(), radiusY.toFloat(), radiusX / 2f, paint)

            // 画第一条直线

            val oneLineStartX = dividerLeft + radiusX

            val oneLineStartY = dividerTop

            val oneLineEndX = dividerLeft + radiusX

            val oneLineEndY = dividerTop + (dividerBottom - dividerTop) / 2 - radiusX / 2

            c.drawLine(
                oneLineStartX.toFloat(), oneLineStartY.toFloat(),
                oneLineEndX.toFloat(), oneLineEndY.toFloat(), paint
            )

            // 画第二条直线

            val twoLineStartX = dividerLeft + radiusX
            val twoLineStartY = (dividerBottom - dividerTop) / 2  + dividerTop
            val twoLineEndX = dividerLeft + radiusX
            val twoLineEndY = dividerBottom

            c.drawLine(
                twoLineStartX.toFloat(),
                twoLineStartY.toFloat(), twoLineEndX.toFloat(), twoLineEndY.toFloat(), paint
            )


        }

    }
}