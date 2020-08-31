package com.dashingqi.module.recyclerview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.dqcommonutils.DensityUtils

/**
 * @author : zhangqi
 * @time : 2020/8/31
 * desc :
 */
class StickHeaderItemDecoration(var callBack: StickHeaderCallBack) : RecyclerView.ItemDecoration() {

    val mPaint = Paint()

    val mTextPaint = Paint()

    init {
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.color = Color.RED

        mTextPaint.style = Paint.Style.FILL_AND_STROKE
        mTextPaint.color = Color.WHITE
        mTextPaint.isAntiAlias = true

    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val childPosition = parent.getChildLayoutPosition(view)
        if (callBack != null) {
            var groupInfo = callBack.getGroupInfo(childPosition)
            if (groupInfo.isFirst()) {
                outRect.top = DensityUtils.dip2pxInt(parent.context, 30f)
            }
        }
    }

    /**
     * 在ItemView之下绘制的
     */
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

    }

    /**
     * 在ItemView之上绘制的
     *
     * StickHeader效果的分析
     * 1. 当前的ItemView不是屏幕上第一个可见View，但是组内第一个可见ItemView，所以需要保持它绘制StickHeader的View
     * 2. 当前的ItemView不是屏幕上的第一个可见View，也不是组内第一个可见IteView，就不需要保持它绘制StickHeaderView
     * 3. 当前的ItemView是屏幕上的第一个可见View，不管是不是组内的第一个可见ItemView，都需要它绘制StickHeader的View
     */
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        //首先画一个矩形 ，矩形高度为30
        var childCount = parent.childCount
        for (index in 0 until childCount) {
            val itemView = parent.getChildAt(index)
            val position = parent.getChildAdapterPosition(itemView)
            Log.d("ItemDecoration ----> ", "position ---> $position + ----> $itemView")
            if (callBack != null) {
                var groupInfo = callBack.getGroupInfo(position)
                val rectLeft = parent.paddingLeft
                val rectRight = parent.width - parent.paddingRight
                // 不是屏幕第一个可见的ItemView，但是是组内第一个可见的ItemView
                if (index != 0) {
                    if (groupInfo.isFirst()) {
                        //要绘制标题栏的顶部坐标
                        val top = itemView.top - DensityUtils.dip2pxInt(parent.context, 30f)
                        //要绘制标题栏的底部坐标
                        val bottom = itemView.top
                        drawRecAndText(
                            rectLeft,
                            top,
                            rectRight,
                            bottom,
                            c,
                            groupInfo.groupTitle,
                            parent.context
                        )
                    }

                } else {
                    // 屏幕第一个可见的ItemView
                    var top = parent.paddingTop
                    var tempTop = 0
                    //是组内最后一个可见的ItemView
                    if (groupInfo.isLast()) {
                        //拿到要绘制标题栏的顶部坐标
                        tempTop = itemView.bottom - DensityUtils.dip2pxInt(parent.context, 30f)
                        if (tempTop < top) {
                            top = tempTop
                        }
                    }
                    val bottom = top + DensityUtils.dip2pxInt(parent.context, 30f)
                    drawRecAndText(
                        rectLeft,
                        top,
                        rectRight,
                        bottom,
                        c,
                        groupInfo.groupTitle,
                        parent.context
                    )
                }
            }
        }
    }

    private fun drawRecAndText(
        rectLeft: Int,
        rectTop: Int,
        rectRight: Int,
        rectBottom: Int,
        c: Canvas,
        title: String,
        context: Context
    ) {
        val rect = Rect(rectLeft, rectTop, rectRight, rectBottom)
        c.drawRect(rect, mPaint)
        mTextPaint.textSize = DensityUtils.dip2px(context, 14f)
        //在矩形中间画一个文字
        c.drawText(
            title,
            rect.centerX().toFloat(), rect.centerY().toFloat(), mTextPaint
        )
    }

    /**
     * 分组回调
     */
    interface StickHeaderCallBack {
        /**
         * 分组规则的回调
         */
        fun getGroupInfo(position: Int): GroupInfo
    }
}