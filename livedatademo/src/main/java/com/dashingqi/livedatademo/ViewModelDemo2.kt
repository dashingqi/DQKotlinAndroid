package com.dashingqi.livedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 2020/6/20
 * desc :
 */
class ViewModelDemo2 : ViewModel() {

    var liveData = MutableLiveData<String>()
}