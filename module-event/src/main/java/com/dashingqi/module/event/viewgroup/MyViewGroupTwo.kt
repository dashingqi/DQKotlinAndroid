package com.dashingqi.module.event.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.RelativeLayout
import com.dashingqi.dqcommonutils.MotionEventUtils

/**
 * @author : zhangqi
 * @time : 12/5/20
 * desc :
 */
class MyViewGroupTwo : RelativeLayout {


    private val TAG = "MyViewGroupTwo"

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        ev?.let {
            MotionEventUtils.printEvent(ev.action, "dispatchTouchEvent", TAG)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        ev?.let {
            MotionEventUtils.printEvent(ev.action, "onInterceptTouchEvent", TAG)
        }
        return super.onInterceptTouchEvent(ev)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            MotionEventUtils.printEvent(event.action, "onTouchEvent", TAG)
        }
        return super.onTouchEvent(event)
    }
}