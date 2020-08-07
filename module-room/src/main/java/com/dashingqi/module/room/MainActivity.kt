package com.dashingqi.module.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.dashingqi.module.room.database.WordDatabase
import com.dashingqi.module.room.entity.Word
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dataBase = Room.databaseBuilder(this, WordDatabase::class.java, "word_database").build()
        val wordDao = dataBase.getWordDao()

        btnInsert.setOnClickListener {
            Thread {
                wordDao.insertWords(Word(1, "DashingQi1", "dashingqi1"))
                wordDao.insertWords(Word(2, "DashingQi2", "dashingqi2"))
            }.start()

        }

        btnQuery.setOnClickListener {
            Thread {
                var allWorlds = wordDao.getAll()

                if (!allWorlds.isNullOrEmpty()) {
                    allWorlds.forEach {
                        println(it)
                    }
                }
            }.start()

        }
    }
}
