package com.dashingqi.module.recyclerview.diff

import androidx.recyclerview.widget.DiffUtil
import com.dashingqi.module.recyclerview.Food

/**
 * @author : zhangqi
 * @time : 12/11/20
 * desc :
 */
class DiffUtilCallBack(
    var oldList: ArrayList<Food> = ArrayList(),
    var newList: ArrayList<Food> = ArrayList()
) :
    DiffUtil.Callback() {

    /**
     * 返回老数据集的大小
     */
    override fun getOldListSize(): Int = oldList.size

    /**
     * 返回新数据集的大小
     */
    override fun getNewListSize(): Int = newList.size

    /**
     * 用来判断当前用于判断新旧集合在同一个位置上的Item是否是同一个
     */
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

    /**
     * 当areItemTheSame相同的时候才会调用这个方法，用来判断对应的位置上的数据是否相等
     */
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }
}