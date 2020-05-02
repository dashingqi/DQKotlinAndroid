package com.dashingqi.activitydemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_one.*

class ActivityOne : AppCompatActivity() {
    private val TAG = "ActivityOne"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one)
        Log.d(TAG, "onCreate: ")



        btn_start_activity_two.setOnClickListener { listener ->
            startActivity(Intent(this, ActivityTwo::class.java))
        }

        btn_start_dialog_activity.setOnClickListener { listener ->
            startActivity(Intent(this, DialogActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: ")
    }
}
