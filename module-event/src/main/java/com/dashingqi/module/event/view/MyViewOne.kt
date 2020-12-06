package com.dashingqi.module.event.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.dashingqi.dqcommonutils.MotionEventUtils

/**
 * @author : zhangqi
 * @time : 12/5/20
 * desc :
 *
 *
 */
class MyViewOne : View {


    private val TAG = "MyViewOne"

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            MotionEventUtils.printEvent(event.action, "dispatchTouchEvent", TAG)
        }
        return super.dispatchTouchEvent(event)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            MotionEventUtils.printEvent(event.action, "onTouchEvent", TAG)
            when(event.action){
                MotionEvent.ACTION_DOWN ->{
                    parent.requestDisallowInterceptTouchEvent(true)
                }
            }
        }
        return super.onTouchEvent(event)
    }
}