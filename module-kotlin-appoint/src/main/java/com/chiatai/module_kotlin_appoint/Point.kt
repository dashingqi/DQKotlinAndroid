package com.chiatai.module_kotlin_appoint

/**
 * @author : zhangqi
 * @time : 2020/11/8
 * desc :
 */
data class Point(val x: Int, val y: Int) {

    override fun equals(other: Any?): Boolean {

        if (other === this) return true

        if (other !is Point) return false

        return other.x == x && other.y == y
    }
}