package com.dashingqi.module.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author : zhangqi
 * @time : 2020/8/7
 * desc :
 */
@Entity
data class Word(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "english_world") val world: String,
    @ColumnInfo(name = "chinese_world") val chineseMeaning: String
) {
    override fun toString(): String {
        return "[ id ===> $id , english_world ===> $world , chinese_world ===> $chineseMeaning ]"
    }
}