package com.chiatai.module_kotlin_appoint.entrust

import android.util.Log

/**
 * @author : zhangqi
 * @time : 12/12/20
 * desc :
 */
class RealPlayer(var name:String):IPlayer {
    private  val TAG = "RealPlayer"
    override fun match() {

        Log.d(TAG, "$name 开始匹配！");

    }

    override fun upgrade() {
        Log.d(TAG, "$name 开始排位升级啦！ ");
    }
}