package com.dashingqi.module.life

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * @author : zhangqi
 * @time : 12/27/20
 * desc :
 */
class MyActivityLifecycleCallbacks(
    var onActivityCreatedAction: ((Activity, Bundle?) -> Unit)? = null,
    var onActivityStartedAction: ((Activity) -> Unit)? = null,
    var onActivityResumedAction: ((Activity) -> Unit)? = null,
    var onActivityPausedAction: ((Activity) -> Unit)? = null,
    var onActivityStoppedAction: ((Activity) -> Unit)? = null,
    var onActivitySaveInstanceStateAction: ((Activity, Bundle) -> Unit)? = null,
    var onActivityDestroyedAction: ((Activity) -> Unit)? = null

) : Application.ActivityLifecycleCallbacks {

    private var mCount=0
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        onActivityCreatedAction?.invoke(activity, savedInstanceState)
    }

    override fun onActivityStarted(activity: Activity) {
        mCount++
        onActivityStartedAction?.invoke(activity)
    }

    override fun onActivityResumed(activity: Activity) {
        onActivityResumedAction?.invoke(activity)
    }

    override fun onActivityPaused(activity: Activity) {
        onActivityPausedAction?.invoke(activity)
    }

    override fun onActivityStopped(activity: Activity) {
        mCount--
        onActivityStoppedAction?.invoke(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        onActivitySaveInstanceStateAction?.invoke(activity, outState)
    }

    override fun onActivityDestroyed(activity: Activity) {
        onActivityDestroyedAction?.invoke(activity)
    }

    /**
     * 这里我们把mCount的实际数值返回回去
     */
    fun getCount():Int = mCount
}