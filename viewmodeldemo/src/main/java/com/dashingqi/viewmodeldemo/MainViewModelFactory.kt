package com.dashingqi.viewmodeldemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * @author : zhangqi
 * @time : 2020/4/5
 * desc :
 */
class MainViewModelFactory(val countReserved: Int) : ViewModelProvider.Factory {
    //create方法中创建了我们的ViewModel的实例
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(countReserved) as T
    }
}