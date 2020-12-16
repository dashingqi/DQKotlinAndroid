package com.dashingqi.activitydemo

import android.app.Activity
import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_toast)
        var background = tvDrawable.background
        Log.d(TAG, "$background")
        val msg = 1
        Log.d(TAG, "${sum(1, 2)}")
        println("-----> ${1}")
        arrayExample()

        // Kotlin编程的项目，在gradle中新增了 apply plugin: 'kotlin-android-extensions' 这个插件，
        // 该插件会根据布局文件中定义的控件Id自动生成一个相同变量名称的变量，
        // lambda表达式
        btn_toast.setOnClickListener { listener ->
            //Toast.makeText(this, "展示 吐司", Toast.LENGTH_SHORT).show()
            Thread(Runnable {
                var name = Thread.currentThread().name
                Log.d("tag", "$name")
                btn_toast.text = "子线程"
            }).start()
        }

        btn_finish.setOnClickListener { listener ->
            finish()
        }

        btn_show_intent.setOnClickListener { listener ->

            //Kotlin中的SecondActivity::class.java 相当于Java中的 SecondActivity.class的写法
            var intent = Intent()


            //intent.setClass(this, SecondActivity::class.java)

            //setClassName
//            intent.setClassName(
//                "com.dashingqi.activitydemo",
//                "com.dashingqi.activitydemo.SecondActivity"
//            )
//
//
//            //setComponent()
            intent.component = ComponentName(this, SecondActivity::class.java)
            intent.data = Uri.parse("http")

            startActivity(intent)
        }

        btn_use_hide_intent.setOnClickListener { listener ->

            var intent = Intent("com.dashingqi.kotlin.second_activity")
            startActivity(intent)


        }

        btn_use_local_browser.setOnClickListener { listener ->
            var intent = Intent(Intent.ACTION_VIEW)
            // Kotlin中的语法糖 intent.setData()
            intent.data = Uri.parse("https://www.baidu.com")
            startActivity(intent)
        }

        btn_call_phone.setOnClickListener { listener ->
            //使用Kotlin中的with标准函数来改造
            val withIntent = with(Intent(Intent.ACTION_DIAL)) {
                data = Uri.parse("tel:1008611")
                putExtra("data", "data")
                putExtra("bundle", Bundle())
                startActivity(this)
            }
            //startActivity(withIntent)

//            val intent = Intent(Intent.ACTION_DIAL)
//            intent.data = Uri.parse("tel:1008611")
//            startActivity(intent)

        }

        btn_transfer_data.setOnClickListener { listener ->
            //使用Kotlin中的标准函数 run来改造
            Intent(this, SecondActivity::class.java).run {
                putExtra("transfer_data", "i love yhn")
                startActivity(this)
            }
//            val intent = Intent(this, SecondActivity::class.java)
//            intent.putExtra("transfer_data", "i love yhn")
//            startActivity(intent)
        }

        btn_start_activity_result.setOnClickListener { listener ->
            //使用Kotlin中的标准函数apply来改造
            Intent(this, SecondActivity::class.java).apply {
                startActivityForResult(this, 1)
            }
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivityForResult(intent, 1)
        }

        btn_taste_activity_life.setOnClickListener { listener ->
            startActivity(Intent(this, ActivityOne::class.java))
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    //当 data对象不为null的情况下 在进行调用
                    val data = data?.getStringExtra("data_return")
                    Log.d(TAG, ": data = $data");
                }
            }
        }
    }

    /**
     * 使用menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    /**
     * 当菜单中的menu的item被点击
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> Toast.makeText(this, "点击了Add", Toast.LENGTH_LONG).show()
            R.id.remove -> Toast.makeText(this, "点击了Remove", Toast.LENGTH_LONG).show()
        }
        return true
    }


    private fun sum(a: Int, b: Int): Int = a + b

    //数组
    private fun arrayExample() {
        //[1,2,3] 第一种创建方式：使用arrayOf()
        val a = arrayOf(1, 2, 3)
        println("----> ${a[0]}")   //输出结果：1
        //[0,2,4]
        val b = Array(3) { i -> (i * 2) }
        println("----> ${b[1]}")   //输出结果：2
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, ": onStart");
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ");
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ");
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ");
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }
}

