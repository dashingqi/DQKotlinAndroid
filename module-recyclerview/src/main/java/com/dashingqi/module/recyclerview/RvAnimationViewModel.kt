package com.dashingqi.module.recyclerview

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 * @author : zhangqi
 * @time : 2020/9/1
 * desc :
 */
class RvAnimationViewModel : ViewModel() {

    val items = ObservableArrayList<String>()
    val itemBinding = ItemBinding.of<String>(BR.item, R.layout.item_anim_view)

    init {
        for (index in 0 until 80) {
            items.add("Item${index}")
        }
    }
}