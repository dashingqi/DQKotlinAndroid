package com.dashingqi.livedatademo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * @author : zhangqi
 * @time : 2020/6/21
 * desc :
 */
class SwitchMapViewModel:ViewModel() {

    var conditionLiveData = MutableLiveData<Person>()

    val transformationsLiveData = Transformations.switchMap(conditionLiveData){
         if (it.condition){
            MutableLiveData(it.firstName)
        }else{
           MutableLiveData(it.lastName)
       }
    }
}