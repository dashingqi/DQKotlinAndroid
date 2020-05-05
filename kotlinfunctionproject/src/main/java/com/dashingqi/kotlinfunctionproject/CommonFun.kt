package com.dashingqi.kotlinfunctionproject

import android.view.View
import android.widget.Button
import java.lang.StringBuilder

/**
 * @author : zhangqi
 * @time : 2020/5/5
 * desc :
 */

fun <T> joinToString(
    collection: Collection<T>,
    separator: String = "::: ",
    preFix: String = "{",
    postFix: String = "}"
): String {
    val result = StringBuilder(preFix)
    for ((index, value) in collection.withIndex()) {
        if (index > 0) result.append(preFix)
        result.append(value)
    }

    result.append(postFix)
    return result.toString()
}

// 扩展函数
fun String.lastChar(): Char = this.get(this.length - 1)


fun String.getLastChar(): Char = get(length - 1)

fun String.lengths(): CharSequence = this.subSequence(0, this.length - 2)

//使用扩展函数来声明joinToString
fun <T> Collection<T>.joinToStrings(
    separator: String = "--> ",
    preFix: String = "(",
    postFix: String = ")"
): String {
    var result = StringBuilder(preFix)
    for ((index, value) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(value)
    }
    result.append(postFix)
    return result.toString()
}

fun View.showOff() = println("I am a view")
fun Button.showOff() = println("I am a button")


val String.lastChars: Char
    get() = get(length - 1)