package com.chiatai.module_animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lottileAnimation = findViewById<LottieAnimationView>(R.id.lottieAnimation)
        findViewById<Button>(R.id.startAnimation).setOnClickListener {
            lottileAnimation.playAnimation()
        }
    }
}