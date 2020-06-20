package com.dashingqi.viewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 2020/6/20
 * desc :
 */
class ViewModelDemo(var str: String) : ViewModel() {

    var liveData = MutableLiveData<Int>(4)

    var liveDataStr = MutableLiveData(str)
}