package com.dashingqi.module.storage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var filesPath = filesDir.absolutePath
        var cachePath = cacheDir.absolutePath
        Log.d(TAG, "filesPath = $filesPath:cachePath = $cachePath ");

    }
}