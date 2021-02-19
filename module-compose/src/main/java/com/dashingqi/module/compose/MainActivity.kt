package com.dashingqi.module.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Space
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.Spacing


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Spacing(left = 16.dp,top = 16.dp)) {
                Text("hello,this is dashingqi")
                Text("哈哈哈哈哈，这就是我")
                Row {
                    Text("this is me ")
                    Text("en，i know it")
                }

                Row() {

                }
            }
        }
    }
}