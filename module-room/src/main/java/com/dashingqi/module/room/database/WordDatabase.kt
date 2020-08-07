package com.dashingqi.module.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dashingqi.module.room.dao.WordDao
import com.dashingqi.module.room.entity.Word

/**
 * @author : zhangqi
 * @time : 2020/8/7
 * desc :
 */
@Database(entities = [Word::class], version = 1, exportSchema = true)
//三个参数分别对应数据库中的表，数据库的版本，以及导出方式
abstract class WordDatabase : RoomDatabase() {

    abstract fun getWordDao(): WordDao
}