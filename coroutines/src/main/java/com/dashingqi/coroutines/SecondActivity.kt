package com.dashingqi.coroutines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.*

class SecondActivity : ScopeActivity() {

    var globalJob: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val stringExtra:String = intent.getStringExtra("")
        launch(Dispatchers.Main) {
            delay(5000)
            Toast.makeText(
                this@SecondActivity, "MainScope toast",
                Toast.LENGTH_LONG
            ).show()
        }

        globalJob = GlobalScope.launch(Dispatchers.Main) {
            delay(5000)
            Toast.makeText(
                this@SecondActivity, "GlobalScope toast",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        globalJob?.let {
            it.cancel()
        }
    }
}