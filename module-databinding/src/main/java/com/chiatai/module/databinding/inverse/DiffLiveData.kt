package com.chiatai.module.databinding.inverse

import androidx.lifecycle.MutableLiveData
import java.util.*

/**
 * @author : zhangqi
 * @time : 12/6/20
 * desc : 如果当前LiveData中携带的值和将要设置的值是一致的，就不进行设置值的操作了
 */
class DiffLiveData<T>(value:T) : MutableLiveData<T>(value) {

    override fun setValue(value: T?) {
        if (Objects.equals(value, getValue())) return
        super.setValue(value)
    }

    override fun postValue(value: T?) {
        if (Objects.equals(value, getValue())) return
        super.postValue(value)
    }
}