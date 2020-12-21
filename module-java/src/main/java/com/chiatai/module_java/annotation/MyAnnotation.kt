package com.chiatai.module_java.annotation

/**
 * @author : zhangqi
 * @time : 12/21/20
 * desc :
 */
class MyAnnotation {

    @FormUrlEncode(value = "String")
    fun getAnnotation(@Query time: String,@Query date:String) {
    }

}