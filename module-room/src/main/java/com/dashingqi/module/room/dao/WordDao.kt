package com.dashingqi.module.room.dao

import androidx.room.*
import com.dashingqi.module.room.entity.Word

/**
 * @author : zhangqi
 * @time : 2020/8/7
 * desc :
 */
@Dao
//Database access object 访问数据库操作接口

interface WordDao {

    @Query("SELECT * FROM word")
    fun getAll(): List<Word>

    //插入数据
    @Insert
    fun insertWords(vararg word: Word)

    //更新数据
    @Update
    fun updateWord(vararg word: Word)

    //删除某一条数据
    @Delete
    fun deleteWords(word: Word)

}