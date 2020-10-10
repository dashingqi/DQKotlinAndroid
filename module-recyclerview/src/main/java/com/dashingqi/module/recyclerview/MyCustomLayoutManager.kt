package com.dashingqi.module.recyclerview

import android.graphics.Rect
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.max

/**
 * @author : zhangqi
 * @time : 2020/9/10
 * desc :
 */
class MyCustomLayoutManager : RecyclerView.LayoutManager() {

    /**
     * 设置RecyclerView中Item的布局参数
     */
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        return RecyclerView.LayoutParams(
            RecyclerView.LayoutParams.WRAP_CONTENT,
            RecyclerView.LayoutParams.WRAP_CONTENT
        )
    }

    /**
     * 设置能够垂直方向滑动
     */
    override fun canScrollVertically(): Boolean {
        return true
    }


    private var mSumDy = 0
    override fun scrollVerticallyBy(
        dy: Int,
        recycler: RecyclerView.Recycler?,
        state: RecyclerView.State?
    ): Int {

        // Log.d("dy =====> ", "$dy")

        var mTempDy = dy

        //已经滑动到底部了
        if (mSumDy + mTempDy < 0) {
            mTempDy = -mSumDy
        } else if (mSumDy + mTempDy > mTotalHeight - getVerticalOffSetSpace()) {
            //到底部 不能滑动的判断----> 滑动的总距离 大于 总高度减去最后一屏的高度的话 就意味着滑动到了底部
            mTempDy = mTotalHeight - getVerticalOffSetSpace() - mSumDy
        }

        /**
         * childCount是获取到可见范围内的Item数量
         *
         * 回收越界的ItemView
         *
         * 从最后一个位置开始
         */
        Log.e("childCount --->", "$childCount")
        for (position in (childCount - 1)..0) {
            Log.e("position ---> ", "$position")
            val itemView = getChildAt(position)
            if (mTempDy > 0) {
                if (getDecoratedBottom(itemView!!) - mTempDy < 0) {
                    removeAndRecycleView(itemView, recycler!!)
                    continue
                }
            } else {
                // 当前ItemView的距离rv的top减去滑动的距离 大于 rv的高度减去paddingBottom
                // 说明是滑动到屏幕之外了，就需要进行回收了
                if (getDecoratedTop(itemView!!) - mTempDy > height - paddingBottom) {
                    removeAndRecycleView(itemView, recycler!!)
                    continue
                }
            }
        }


        // 可见区域的范围
        val visibleArea = getVisibleArea(mTempDy)

        if (mTempDy >= 0) {
            //获取到可见范围内最后一个ItemView
            var lastView = getChildAt(childCount - 1)
            //获取到最后一个可见View的下一个Item的position
            val minPosition = getPosition(lastView!!) + 1

            for (position in minPosition until itemCount) {
                val rect = rectItems[position]!!
                if (Rect.intersects(visibleArea, rect)) {
                    val itemView = recycler?.getViewForPosition(position)
                    addView(itemView)
                    measureChildWithMargins(itemView!!, 0, 0)
                    layoutDecorated(
                        itemView,
                        rect.left,
                        rect.top - mSumDy,
                        rect.right,
                        rect.bottom - mSumDy
                    )
                } else {
                    break
                }
            }
        }
//        } else {
//            //获取到可见范围的第一个ItemView
//            var firstView = getChildAt(0)
//            Log.d("fistItem", "${firstView != null}")
//            val maxPosition = getPosition(firstView!!) - 1
//            Log.d("maxPosition --->", "$maxPosition")
//
//            for (position in maxPosition..0) {
//                Log.d("position ---> ", "$position")
//                val rect = rectItems[position]!!
//                if (Rect.intersects(visibleArea, rect)) {
//                    val itemView = recycler?.getViewForPosition(position)
//                    addView(itemView, 0)
//                    measureChildWithMargins(itemView!!, 0, 0)
//                    layoutDecorated(itemView, rect.left, rect.top-mSumDy, rect.right, rect.bottom-mSumDy)
//                } else {
//                    break
//                }
//            }
//        }

        mSumDy += mTempDy
        // Log.d("mSumDy ======> ", "$mSumDy")
        offsetChildrenVertical(-mTempDy)
        return dy
    }


    private var mTotalHeight = 0
    private val rectItems = mutableMapOf<Int, Rect>()

    /**
     * 摆放子View的位置
     * 针对回收复用
     * 1. 使用detachAndScrapAttachedViews(recycler)方法将可见的ViewHolder从RecyclerView中剥离
     * 2. 仅仅创建满一屏幕的ViewHolder就可以了，多了不创建。
     */
    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {

        /**
         * 当没有数据的时候，就空白页面显示
         */
        if (itemCount == 0) {
            detachAndScrapAttachedViews(recycler!!)
            return
        }

        /**
         * 将可见的ViewHolder从RecyclerView中剥离出来
         */
        detachAndScrapAttachedViews(recycler!!)

        /**
         * 获取到第一个可见ItemView
         */
        val firstItemView = recycler.getViewForPosition(0)
        //测量一下这个ItemView
        measureChildWithMargins(firstItemView, 0, 0)

        /**
         * 每一个Item的高度相同
         */
        val firstItemViewHeight = getDecoratedMeasuredHeight(firstItemView)
        val firstItemViewWidth = getDecoratedMeasuredWidth(firstItemView)

        //计算一屏幕能显示多少个ItemView，就创建多少个ViewHolder
        val visibleCount = getVerticalOffSetSpace() / firstItemViewHeight

        //Y轴上的偏移量
        var offsetY = 0

        /**
         * 将所有ItemView的宽和高存储到rect 与 position 形成 key-value
         */
        for (position in 0 until itemCount) {
            val rect = Rect(0, offsetY, firstItemViewWidth, offsetY + firstItemViewHeight)
            rectItems[position] = rect
            offsetY += firstItemViewHeight
        }

        //使用visibleCount ---> 仅仅创建可见的ViewHolder
        for (position in 0..visibleCount) {
            val rect = rectItems[position]!!
            val childView = recycler?.getViewForPosition(position)
            //添加 ItemView
            addView(childView)
            //测量一下ItemView
            measureChildWithMargins(childView!!, 0, 0)
            //摆放这个ItemView
            layoutDecorated(childView, 0, rect.top, rect.width(), rect.bottom)
        }

        //如果item的总高度不满一个屏幕的话，就拿RV的高度
        mTotalHeight = max(offsetY, getVerticalOffSetSpace())
    }

    private fun getVerticalOffSetSpace(): Int {
        //这里的height获取的事rv的高度
        return height - paddingTop - paddingBottom
    }

    /**
     * 当前可见区域的范围
     */
    private fun getVisibleArea(tempDy: Int): Rect {
        return Rect(
            paddingLeft,
            paddingTop + tempDy + mSumDy,
            width + paddingRight,
            getVerticalOffSetSpace() + mSumDy + tempDy
        )
    }
}