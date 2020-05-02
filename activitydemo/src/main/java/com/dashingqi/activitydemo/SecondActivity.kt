package com.dashingqi.activitydemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //同样使用了Kotlin的语法糖
        //intent 实际是调用了 getIntent() 获得到的是 启动该Activity的Intent
        var stringExtra = intent.getStringExtra("transfer_data")
        Log.d(TAG, "transferData $stringExtra")

        btn_return_data.setOnClickListener { listener ->
            val intent = Intent()
            intent.putExtra("data_return", "ni hao hn,hai hao ma")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}