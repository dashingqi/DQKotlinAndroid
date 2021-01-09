package com.chiatai.module_animation

import android.animation.ValueAnimator
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

        // 创建了一个值从 0到4000的动画
        var animator = ValueAnimator.ofInt(0, 400)
        //设置执行时间
        animator.duration = 1000

        animator.addUpdateListener { animation ->

            var value = animation.animatedValue as Int
            hello.layout(value, value, value + hello.width, value + hello.height)
            Log.d("value = ", "$value")
        }

        //开始动画
        //animator.start()

        var floatAnimator = ValueAnimator.ofFloat(0f, 400f, 100f, 300f)
        floatAnimator.addUpdateListener { animation ->
            var floatValue = animation.animatedValue as Float
            var intValue = floatValue.toInt()
            hello.layout(intValue,intValue,intValue+hello.width,intValue+hello.height)
        }
        floatAnimator.duration = 2000
        floatAnimator.start()
    }
}