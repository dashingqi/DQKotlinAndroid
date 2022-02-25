package com.dashingqi.module.recyclerview

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 * @author : zhangqi
 * @time : 2020/9/1
 * desc :
 */
class HorizontalScrollPageViewModel : ViewModel() {

    private var imgUrls = mutableListOf(
        "http://img.kaiyanapp.com/b85656fae5c5fc73f8a2305cb425816d.jpeg?imageMogr2/quality/60/format/jpg",
        "http://img.kaiyanapp.com/725db3b482499ef5fa99067d19f18756.jpeg?imageMogr2/quality/60/format/jpg",
        "http://img.kaiyanapp.com/74e0d5abcfe9bc23fda7859a9dd00030.png?imageMogr2/quality/60/format/jpg",
        "http://img.kaiyanapp.com/b86cde300d0a39bce5a8c8dff07f5f07.jpeg?imageMogr2/quality/60/format/jpg",
        "http://img.kaiyanapp.com/773b626d3cb9efe9ec195f04ad3fd981.png?imageMogr2/quality/60/format/jpg",
        "http://img.kaiyanapp.com/1bdfab6993bc3a76d461a43517fa2df6.jpeg?imageMogr2/quality/60/format/jpg",
        "http://img.kaiyanapp.com/7e15a8691026407bb2774de088515831.jpeg?imageMogr2/quality/60/format/jpg"
    )

    val items = ObservableArrayList<String>()
    val itemBinding = ItemBinding.of<String>(BR.item, R.layout.item_scroll_page)

    val notifyChangeTop = ObservableBoolean(false)

    init {
        for (index in 0 until imgUrls.size) {
            items.add(imgUrls[index])
        }
    }

    fun changeMarginTop(){
        notifyChangeTop.set(true)
    }

}