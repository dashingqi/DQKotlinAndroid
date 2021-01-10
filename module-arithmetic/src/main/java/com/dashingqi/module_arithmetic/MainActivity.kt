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

        var arrayOf = arrayOf(1, 4, 7, 8, 4, 7, 3, 4, 523, 341, 3, 2)
        var maxProfit = ArithmeticFile.maxProfit(arrayOf.toIntArray())
        Log.d(TAG, "maxProfit = $maxProfit")
    }
}
