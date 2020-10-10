package com.chiatai.module_window


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.WindowManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)

//        //使用setFlags
//        window.setFlags(
//            WindowManager.LayoutParams.FLAGS_CHANGED,
//            WindowManager.LayoutParams.SOFT_INPUT_MASK_ADJUST
//        )
//
//        //使用addFlags
//        window.addFlags(WindowManager.LayoutParams.FLAGS_CHANGED)
//
//
//        //使用LayoutParams指定Flag
//        val layoutParams = WindowManager.LayoutParams()
//        layoutParams.flags = WindowManager.LayoutParams.FLAGS_CHANGED
//        val textView = TextView(this)
//        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        windowManager.addView(textView, layoutParams);
//    }
    }
}
