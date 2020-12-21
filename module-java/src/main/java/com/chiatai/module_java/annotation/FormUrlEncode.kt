package com.chiatai.module_java.annotation


/**
 * @author : zhangqi
 * @time : 12/21/20
 * desc :
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class FormUrlEncode(val value: String)

