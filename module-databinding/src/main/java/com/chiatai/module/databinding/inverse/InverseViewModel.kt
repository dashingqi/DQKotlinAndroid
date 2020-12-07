package com.chiatai.module.databinding.inverse

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 12/7/20
 * desc :
 */
class InverseViewModel : ViewModel() {

    var inverseBean = InverseBean()

    var etText = MutableLiveData<String>("")

    var checkBoxStatus = MutableLiveData<Boolean>(false)

    init {
        var lists = arrayListOf("tag1", "tag2", "tag3", "tag4", "tag5")
        inverseBean.tagList.addAll(lists)
    }
}