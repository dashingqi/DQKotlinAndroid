package com.chiatai.module.databinding.inverse

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData

/**
 * @author : zhangqi
 * @time : 12/7/20
 * desc :
 */
class InverseBean {

    var index = DiffLiveData<Int>(0)

    var tagList = ObservableArrayList<String>()
}