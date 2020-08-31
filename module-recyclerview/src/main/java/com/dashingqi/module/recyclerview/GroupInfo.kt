package com.dashingqi.module.recyclerview

/**
 * @author : zhangqi
 * @time : 2020/8/31
 * desc :
 *
 * groupId 分组的ID
 * groupTitle 每组的标题
 * position 每一个条目的位置
 */
class GroupInfo(var groupId: Int, var groupTitle: String) {
    var position: Int = 0
    fun isFirst(): Boolean {
        return position == 0
    }
}