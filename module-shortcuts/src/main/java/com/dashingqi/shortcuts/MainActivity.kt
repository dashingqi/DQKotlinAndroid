package com.dashingqi.shortcuts

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configShortCuts()
    }

    private fun configShortCuts() {
        //首先做下版本检查 高于7.1才进行代码的注册
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {

                val backIntent = Intent(this,BackActivity::class.java)?.apply {
                    action = "com.dashingqi.shortcut.back"
                }

                val activityTwoIntent = Intent(this,TwoActivity::class.java)?.apply {
                    action = "android.intent.action.VIEW"
                }

                val orderIntents = arrayOf(backIntent,activityTwoIntent)
                val orderShortCuts = ShortcutInfo.Builder(this, "ActivityTwo")
                    .setShortLabel("ActivityTwo")
                    .setLongLabel("ActivityTwo")
                    .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                    .setIntents(orderIntents)
                    .build()

                var shortCutService = getSystemService(ShortcutManager::class.java)
                shortCutService.dynamicShortcuts = listOf(orderShortCuts)
        }
    }
}