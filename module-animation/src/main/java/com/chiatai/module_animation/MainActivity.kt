package com.chiatai.module_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import com.dashingqi.dqcommonutils.SystemServiceUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lottileAnimation = findViewById<LottieAnimationView>(R.id.lottieAnimation)
        findViewById<Button>(R.id.startAnimation).setOnClickListener {
            lottileAnimation.playAnimation()
        }

        copy.setOnClickListener {
            var copy = SystemServiceUtil.copy("dashingqi is dashingqi")
            if (copy) {
                Log.d(TAG, ": copy success")
            }
        }
    }
}