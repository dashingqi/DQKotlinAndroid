package com.dashingqi.module.compose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val image = imageResource(R.drawable.ic_launcher_background)
            Column{
                Text("hello,this is dashingqi")
                Text("哈哈哈哈哈，这就是我")


                Row {
                    Text("this is me ")
                    Text("en，i know it")
                }
            }
        }
    }

    @Preview
    @Composable
    fun helloWorld() {
        Text(text = "Hello World")
    }
}