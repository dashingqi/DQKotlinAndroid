package com.dashingqi.module_arithmetic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var balancedSplitStr = ArithmeticFile.balancedSplitStr("RLLLLRRRLR")
        Log.d(TAG, "size ---> $balancedSplitStr")

        var balancedStringSplit1 = ArithmeticBackUpFile.balancedStringSplit1("RLLLLRRRLR")
        Log.d(TAG, "size balanced ---> $balancedStringSplit1");

        ArithmeticFile.numWaterBottles(10,3)
    }
}
