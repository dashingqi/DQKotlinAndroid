package com.dashingqi.coroutines

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * @author zhangqi61
 * @since 6/8/21
 */
abstract class ScopeActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}