package com.dashingqi.module.recyclerview

import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author : zhangqi
 * @time : 2020/9/2
 * desc :
 */
class MyItemTouchHelperCallback(var touchHelperListener: MyItemTouchHelperCallbackListener) :
    ItemTouchHelper.Callback() {

    /**
     * 移动的标识
     * 就是当我们滑动或者拖拽的时候，需要我们告诉系统方向
     */
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val layoutManager = recyclerView.layoutManager
        if (layoutManager is LinearLayoutManager) {
            val linearLayoutManager: LinearLayoutManager = layoutManager as LinearLayoutManager
            val orientation: Int = linearLayoutManager.getOrientation()

            /**
             * 拖拽
             */
            var dragFlag = 0

            /**
             * 滑动删除
             */
            var swipeFlag = 0

            // 为了方便理解，相当于分为横着的ListView和竖着的ListView
            // 如果是横向的布局
            if (orientation == LinearLayoutManager.HORIZONTAL) {
                swipeFlag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                dragFlag = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            } else if (orientation == LinearLayoutManager.VERTICAL) {
                // 如果是竖向的布局
                dragFlag = ItemTouchHelper.UP or ItemTouchHelper.DOWN
                swipeFlag = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
            }
            //第一个参数是拖拽flag，第二个是滑动的flag
            return if (viewHolder.itemViewType == BLACK_VIEW_TYPE) {
                makeMovementFlags(dragFlag, swipeFlag)
            }else{
                makeMovementFlags(0, 0)
            }
        }
        return 0
    }

    /**
     * 移动
     */
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        if (viewHolder.itemViewType!=target.itemViewType){
            return false
        }
        if (touchHelperListener != null)
            return touchHelperListener.onMove(viewHolder.adapterPosition, target.adapterPosition)
        return false
    }

    /**
     * 侧边滑动删除
     */
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (touchHelperListener!=null){
                touchHelperListener.onSwiped(viewHolder.adapterPosition)
            }
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        var y = dY
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            viewHolder?.let {
                if (it.itemView.top + dY <= recyclerView.top) {
                    y = (recyclerView.top - viewHolder.itemView.top).toFloat()
                }
            }
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    /**
     * 回调事件
     */
    interface MyItemTouchHelperCallbackListener {
        fun onSwiped(adapterPosition: Int)
        fun onMove(currentPosition: Int, targetPosition: Int): Boolean
    }
}