package com.chiatai.module.databinding.inverse

import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 12/7/20
 * desc :
 */
class InverseViewModel : ViewModel() {

    var inverseBean = InverseBean()

    init {
        var lists = arrayListOf("tag1", "tag2", "tag3", "tag4", "tag5")
        inverseBean.tagList.addAll(lists)
    }
}