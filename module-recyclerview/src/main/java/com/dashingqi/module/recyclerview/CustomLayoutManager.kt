package com.dashingqi.module.recyclerview

import androidx.recyclerview.widget.RecyclerView

/**
 * @author : zhangqi
 * @time : 2020/8/27
 * desc :
 */
class CustomLayoutManager : RecyclerView.LayoutManager() {
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
    }


    /**
     * 开启能够垂直滑动
     */
    override fun canScrollVertically(): Boolean {
        return true
    }

    /**
     * 方法中的 dy表示每次手指滑动的位移
     * 当dy>0 表示从上向下滑动
     * 当dy<0 表示从下向上滑动
     */

    var mSumDy = 0
    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {
        var tempDy = dy
        if (mSumDy+dy<0){
            tempDy = -mSumDy
        }
        mSumDy += tempDy
        offsetChildrenVertical(-tempDy)
        return dy
    }
}