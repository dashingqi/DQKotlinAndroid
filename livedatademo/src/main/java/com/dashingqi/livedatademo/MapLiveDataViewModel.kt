package com.dashingqi.livedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 2020/6/20
 * desc :
 */
class MapLiveDataViewModel : ViewModel() {

    var userLiveData = MutableLiveData<Person>()

    /**
     * 使用Transformations#map转换成一个新的LiveData
     * 第一个参数是我们要进行转化的LiveData。里面包装了我们需要的数据
     * 第二个参数是我们要进行转化的函数
     * 这样当userLiveData的数据源发生变化的时候，我们transformLiveData的观察者就能收到转化后的数据源了
     */
    var transformLiveData = Transformations.map(userLiveData) { person ->
        person.name
    }
}