package com.chiatai.module_kotlin_appoint

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import java.io.Serializable
import java.math.BigDecimal
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

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

// == 和 != 可以用于可空运算数，这些运算数事实上会先检查运算数是否为null，比较 a==b 会检查 a是否为非空，如果不是 就调用 a.equals(b)
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

/**
 * Bundle put 的扩展函数
 */
fun <T> Bundle.put(key: String, value: T) {
    when (value) {
        is Boolean -> putBoolean(key, value)
        is String -> putString(key, value)
        is Int -> putInt(key, value)
        is Short -> putShort(key, value)
        is Long -> putLong(key, value)
        is Byte -> putByte(key, value)
        is ByteArray -> putByteArray(key, value)
        is Char -> putChar(key, value)
        is CharArray -> putCharArray(key, value)
        is CharSequence -> putCharSequence(key, value)
        is Float -> putFloat(key, value)
        is Bundle -> putBundle(key, value)
        is Parcelable -> putParcelable(key, value)
        is Serializable -> putSerializable(key, value)
        else -> throw IllegalStateException("Type of property $key is not supported")
    }
}


fun <T:Any> fragmentArgument():ReadWriteProperty<Fragment,T> = FragmentArgumentDelegate()

fun <T:Any> fragmentNullArgument():ReadWriteProperty<Fragment,T?> = FragmentNullArgumentDelegate()

/**
 * SharedPreferences的扩展函数
 */

fun SharedPreferences.string(
    defaultValue: String = "",
    key: (KProperty<*>) -> String = KProperty<*>::name
): ReadWriteProperty<Any, String> = object : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return getString(key(property), defaultValue) ?: ""
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        edit().putString(key(property), value).apply()
    }
}


