package com.dashingqi.livedatademo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 2020/4/5
 * desc :
 */
class MainViewModel(countReserved: Int) : ViewModel() {
    //为外界提供不可变的LiveData，实际还是获取的事 MutableData的实例，只不过只能进行取数据取操作，
    val counter: LiveData<Int> get() = _counter
    //MutableLiveData是一个可变的LiveData
    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }
}