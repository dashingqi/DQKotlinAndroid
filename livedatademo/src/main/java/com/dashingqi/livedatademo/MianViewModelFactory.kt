package com.dashingqi.livedatademo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author : zhangqi
 * @time : 2020/4/5
 * desc :
 */
class MianViewModelFactory(val count:Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(count) as T
    }
}