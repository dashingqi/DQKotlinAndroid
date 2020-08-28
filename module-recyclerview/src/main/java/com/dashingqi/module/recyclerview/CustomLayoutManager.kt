package com.dashingqi.module.recyclerview

import android.util.Log
import androidx.recyclerview.widget.RecyclerView

/**
 * @author : zhangqi
 * @time : 2020/8/27
 * desc :
 */
class CustomLayoutManager : RecyclerView.LayoutManager() {

    private var sumDy = 0
    private var mTotalHeight = 0

    /**
     * 该方法是RecyclerView中Item的布局参数
     */
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }

    /**
     * 父类中该方法是一个空实现，需要我们自定义LayoutManager时候，需要重写该方法
     * 布局item
     * getDecoratedMeasuredHeight 获取的是 item+decoration的高度
     * getMeasuredHeight 获取的是item的高度
     */
    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        var offsetY = 0
        for (position in 0 until itemCount) {
            var itemView = recycler?.getViewForPosition(position)
            itemView?.let {
                addView(it)
                //测量一下view
                measureChildWithMargins(itemView!!, 0, 0)
                var decoratedHeight = getDecoratedMeasuredHeight(it)
                var decoratedWidth = getDecoratedMeasuredWidth(it)
                layoutDecorated(it, 0, offsetY, decoratedWidth, offsetY + decoratedHeight)
                offsetY = offsetY.plus(decoratedHeight)
            }
        }

        /**
         * 当item不满一屏的时候，
         */

        Log.d("getVerticalSpace --> ", "${getVerticalSpace()}")
        mTotalHeight = offsetY.coerceAtLeast(getVerticalSpace())
    }

    /**
     * 用于RecyclerView显示Item的真实高度
     */
    private fun getVerticalSpace(): Int {
        return height - paddingBottom - paddingTop
    }

    /**
     * 设置可以垂直滑动
     */
    override fun canScrollVertically(): Boolean {
        return true
    }

    /**
     * 设置垂直滑动的距离
     *
     * dy ---> 垂直方向滑动的距离
     *
     * dy>0  手指从下向上滑动
     *
     * dy<0 手指从上向下滑动
     *
     * 异常判断
     * 什么时候到顶：
     * 向下滑动多少，就向上滑动多少 才能到顶部
     * 当向上滑动与向下滑动的距离和小于0的时候，就是到顶的时候
     * 什么到底：
     * 获取到item的总高度   减去  最后一屏item的高度 就是 到底了
     */
    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        var tempDy = dy
        if (sumDy + tempDy < 0) {
            tempDy = -sumDy
        } else if (sumDy + dy > mTotalHeight - getVerticalSpace()) { //之前滑动的总和+当前的滑动+一屏幕的高度 大于 总高度的话 就表明 滑动到了底部
            tempDy = mTotalHeight - getVerticalSpace() - sumDy
        }
        sumDy += tempDy

        Log.d("tag:::", "dy----> $dy")
        offsetChildrenVertical(-tempDy)
        return dy
    }
}