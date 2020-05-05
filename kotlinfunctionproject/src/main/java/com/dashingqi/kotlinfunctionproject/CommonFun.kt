package com.dashingqi.kotlinfunctionproject

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