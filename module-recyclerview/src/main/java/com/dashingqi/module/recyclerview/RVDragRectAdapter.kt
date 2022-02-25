package com.dashingqi.module.recyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

/**
 * @author zhangqi61
 * @since 2022/2/15
 */
const val BLACK_VIEW_TYPE = 0
const val WHITE_VIEW_TYPE = 1

class RVDragRectAdapter(
    var data: MutableList<Int> = mutableListOf(),
    var context: Context,
    var itemTouchHelper: ItemTouchHelper
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == BLACK_VIEW_TYPE) {
            val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_black, parent, false)
            BlackViewHolder(itemView, viewType)
        } else {
            val itemView = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_white, parent, false)
            WhiteViewHolder(itemView, viewType, context)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemViewType(position: Int): Int {
        val value = data[position]
        return if (value == 0) {
            BLACK_VIEW_TYPE
        } else {
            WHITE_VIEW_TYPE
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    @SuppressLint("ClickableViewAccessibility")
   inner class WhiteViewHolder(itemView: View, viewType: Int, context: Context) : RecyclerView.ViewHolder(itemView) {
        private var mLastX = 0
        private var mLastY = 0

        init {
            val density = context.resources.displayMetrics.density
            val whiteLayout = itemView.findViewById<ConstraintLayout>(R.id.white_layout)
            whiteLayout.setOnTouchListener { v, event ->
                if (adapterPosition < 0) false
                if (viewType == BLACK_VIEW_TYPE) {
                    when (event.actionMasked) {
                        MotionEvent.ACTION_DOWN -> {
                            mLastX = event.x.toInt()
                            mLastY = event.y.toInt()
                            whiteLayout.alpha = 0.2f
                            whiteLayout.parent.requestDisallowInterceptTouchEvent(true)
                        }
                        MotionEvent.ACTION_MOVE -> {
                            val x = event.x.toInt()
                            val y = event.y.toInt()
                            val rect = Rect()
                            whiteLayout.getGlobalVisibleRect(rect)
                            if (!rect.contains(x, y)) {
                                whiteLayout.parent.requestDisallowInterceptTouchEvent(false)
                            }
                            if (abs(mLastX - x) > density * 5 || abs(mLastY - y) > density * 5) {
                                whiteLayout.parent.requestDisallowInterceptTouchEvent(false)
                                itemTouchHelper.startDrag(this)
                            }
                        }
                        MotionEvent.ACTION_CANCEL,
                        MotionEvent.ACTION_UP -> {
                            whiteLayout.alpha = 1.0f
                            whiteLayout.parent.requestDisallowInterceptTouchEvent(false)
                        }
                    }
                }
                false
            }
        }

    }

    class BlackViewHolder(itemView: View, viewType: Int) : RecyclerView.ViewHolder(itemView) {

    }
}