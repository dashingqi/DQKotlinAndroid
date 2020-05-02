package com.dashingqi.viewmodeldemo

import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 2020/4/5
 * desc : 主构造函数
 */
class MainViewModel(countReserved: Int) : ViewModel() {
    var counter = countReserved
}