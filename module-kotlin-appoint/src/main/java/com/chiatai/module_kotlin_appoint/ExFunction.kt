package com.chiatai.module_kotlin_appoint

import android.util.Log
import java.math.BigDecimal

/**
 * @author : zhangqi
 * @time : 2020/11/8
 * desc :
 */

private const val TAG = "ExFunction"

// =================== 重载算数运算符 ===========================
operator fun Point.plus(other: Point): Point {
    return Point(
        x + other.x, y + other
            .y
    )
}

operator fun Point.times(scale: Double): Point {
    return Point(x * scale.toInt(), y * scale.toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

// 取负数
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

//  取正数
operator fun Point.unaryPlus(): Point {
    return Point(+x, +y)
}

// ++
operator fun BigDecimal.inc() = this + BigDecimal.ONE

// --
operator fun BigDecimal.dec() = this - BigDecimal.ONE


//  =================== 重载比较运算符 =======================
// 在Kotlin中 如果使用  == 运算符 它将被转换成 equals 方法调用
// 使用 != 运算符也会被转换成 equals函数调用

// == 和 != 可以用于可空运算书数，这些运算数事实上会先检查运算数是否为null，比较 a==b 会检查 a是否为非空，如果不是 就调用 a.equals(b)
// 否则两个参数都是空引用，结果才是true

// a == b  -----> a?.equals(b) ?: (b==null)

//等号运算符 "equals"


operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}


operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else -> IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

// 构建一个区间，检查坐标是否属于这个区间  in 的约定

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x && p.y in upperLeft.y until lowerRight.y
}

fun separateFile(fileName: String): NameComponents {
    val (name, extension) = fileName.split(".", limit = 2)
    return NameComponents(name, extension)
}

fun printMap(map: Map<String, String>) {
    for ((key, value) in map) {
        Log.d(TAG, " key == $key  value == $value")
    }
}
//惰性初始化是当第一次访问该属性的时候，才根据需要创建该属性

