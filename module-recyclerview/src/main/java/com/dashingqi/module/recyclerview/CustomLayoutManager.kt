package com.dashingqi.module.recyclerview

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author : zhangqi
 * @time : 2020/8/27
 * desc :
 */
class CustomLayoutManager : RecyclerView.LayoutManager() {

    private var sumDy = 0
    private var mTotalHeight = 0
    var mSumDy = 0


    private var itemReacts = ArrayList<Rect>()

    /**
     * 该方法返回的是RecyclerView中Item的布局参数
     */
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }

    /**
     * 用于RecyclerView显示Item的真实高度
     */
    fun getVerticalSpace(): Int {
        return height - paddingBottom - paddingTop
    }

    /**
     * 设置可以垂直滑动
     */
    override fun canScrollVertically(): Boolean {
        return true
    }

    /**
     * 父类中该方法是一个空实现，需要我们自定义LayoutManager时候，需要重写该方法
     * 布局item
     * getDecoratedMeasuredHeight 获取的是 item+decoration的高度
     * getMeasuredHeight 获取的是item的高度
     */
    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        if (itemCount == 0) { //没有item ，界面就空着吧
            detachAndScrapAttachedViews(recycler!!)
            return
        }
        /**
         * 将所有View从RecyclerView中剥离出来
         */
        detachAndScrapAttachedViews(recycler!!)
        //申请一个ViewHolder
        var childView = recycler?.getViewForPosition(0)
        //先测量
        measureChildWithMargins(childView, 0, 0)
        //然后获取到宽，高
        var measuredHeight = getDecoratedMeasuredHeight(childView)
        var measuredWidth = getDecoratedMeasuredWidth(childView)

        //计算屏幕中可见的Item个数
        var itemVisible = getVerticalSpace() / measuredHeight

        var offsetY = 0

        for (position in 0 until itemCount) {
            var itemView = recycler?.getViewForPosition(position)
            itemView?.let {
                addView(it)
                //测量一下view
                measureChildWithMargins(it, 0, 0)
                var decoratedHeight = getDecoratedMeasuredHeight(it)
                var decoratedWidth = getDecoratedMeasuredWidth(it)
                layoutDecorated(it, 0, offsetY, decoratedWidth, offsetY + decoratedHeight)
                offsetY = offsetY.plus(decoratedHeight)
            }


            //遍历每一个item的位置，用Rect来保存
            for (position in 0 until itemCount) {
                var rect = Rect(0, offsetY, measuredWidth, measuredHeight + offsetY)
                itemReacts.add(rect)
                offsetY += measuredHeight
            }


            //遍历当前屏幕显示出来的item
            for (position in 0 until itemVisible) {
                var rect = itemReacts[position]
                var itemView = recycler.getViewForPosition(position)
                //添加View 因为之前调用了detachAndScrapAttachedViews()方法，所以需要将View添加一下
                addView(itemView)
                //测量
                measureChildWithMargins(itemView, 0, 0)
                //布局 任何View的 layout() 过程都是依赖 measure()过程后的信息
                layoutDecoratedWithMargins(itemView, rect.left, rect.top, rect.right, rect.bottom)

            }

            /**
             * 当item不满一屏的时候，
             */

            Log.d("getVerticalSpace --> ", "${getVerticalSpace()}")
            mTotalHeight = offsetY.coerceAtLeast(getVerticalSpace())
        }
    }


    /**
     * 开启能够垂直滑动
    /


    /**

     * 方法中的 dy表示每次手指滑动的位移
     * 当dy>0 表示从上向下滑动
     * 当dy<0 表示从下向上滑动
    */



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
     *
     * getChildAt() :获取到某个可视位置的View，它的位置索引并不是Adapter中的位置索引，二是当前在屏幕上可见范围内的位置索引
     * getChildCount()：获取到的是当前RecyclerView中显示的view的个数
     * getItemCount():获取到Adapter中所有View的个数
     * getPosition():用于获取某个View在Adapter中的位置索引
     *
     */

    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {

        var tempDy = dy
        if (mSumDy + dy < 0) {
            tempDy = -mSumDy
        }
        mSumDy += tempDy
        offsetChildrenVertical(-tempDy)
        return dy


        if (itemCount > 0) {
            var tempDy = dy
            // 处理滑动到顶部
            if (sumDy + tempDy < 0) {
                tempDy = -sumDy
            } else if (sumDy + dy > mTotalHeight - getVerticalSpace()) { //之前滑动的总和+当前的滑动+一屏幕的高度 大于 总高度的话 就表明 滑动到了底部
                tempDy = mTotalHeight - getVerticalSpace() - sumDy
            }

            //遍历要显示所有的item
            for (position in (itemCount - 1)..0) {
                var itemView = getChildAt(position)
                if (tempDy > 0) {
                    //向上滑动 ,处理向上滑动，滑动到屏幕之外itemView的回收处理
                    if (getDecoratedBottom(itemView!!) - tempDy < 0) {
                        removeAndRecycleView(itemView!!, recycler!!)
                        continue
                    }

                } else {
                    //向下滑动
                }
            }

            // 获取到屏幕位置
            var visibleArea = getVisibleArea(tempDy)
            if (tempDy >= 0) {
                //向上滑动
                var lastChildView = getChildAt(childCount - 1)
                //获取到最后一View的index+1开始
                var mPoints = getPosition(lastChildView!!) + 1

                for (position in mPoints until itemCount) {
                    var itemRect = itemReacts[position]
                    if (Rect.intersects(visibleArea, itemRect)) {
                        var childView = recycler?.getViewForPosition(position)
                        addView(childView)
                        measureChildWithMargins(childView!!, 0, 0)
                        layoutDecoratedWithMargins(
                            childView,
                            itemRect.left,
                            itemRect.top - sumDy,
                            itemRect.right,
                            itemRect.bottom - sumDy
                        )
                    }
                }
            } else {
                val firstView: View? = getChildAt(0)
                val maxPos = getPosition(firstView!!) - 1

                for (i in maxPos downTo 0) {
                    val rect: Rect = itemReacts.get(i)
                    if (Rect.intersects(getVisibleArea(tempDy), rect)) {
                        val child: View = recycler!!.getViewForPosition(i)
                        addView(
                            child,
                            0
                        ) //将View添加至RecyclerView中，childIndex为1，但是View的位置还是由layout的位置决定
                        measureChildWithMargins(child, 0, 0)
                        layoutDecoratedWithMargins(
                            child,
                            rect.left,
                            rect.top - sumDy,
                            rect.right,
                            rect.bottom - sumDy
                        )
                    } else {
                        break
                    }
                }
            }
            sumDy += tempDy
            Log.d("tag:::", "dy----> $dy")
            offsetChildrenVertical(-tempDy)
        }

        return dy
    }

    /**
     * 获取到屏幕可见的区域
     */
    private fun getVisibleArea(tempDy: Int): Rect {
        return Rect(
            paddingLeft,
            paddingTop + sumDy + tempDy,
            width + paddingRight,
            getVerticalSpace() + sumDy + tempDy
        )
    }
}