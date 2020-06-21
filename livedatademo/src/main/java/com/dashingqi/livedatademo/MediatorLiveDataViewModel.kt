package com.dashingqi.livedatademo

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 2020/6/21
 * desc :
 */
class MediatorLiveDataViewModel : ViewModel() {
    var liveData1 = MutableLiveData<String>()
    var liveData2 = MutableLiveData<String>()

    var mediatorLiveData = MediatorLiveData<String>()


    init {
        mediatorLiveData.addSource(liveData1) {
            Log.d("perform livedata1", it)
            mediatorLiveData.postValue(it)
        }

        mediatorLiveData.addSource(liveData2) {
            Log.d("perform livedata2", it)
            mediatorLiveData.postValue(it)
        }
    }
}