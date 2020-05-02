package com.dashingqi.uidemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.dashingqi.uidemo.databinding.ActivityMainBinding
import com.dashingqi.uidemo.listview.ActivityList
import com.dashingqi.uidemo.recyclerview.ActivityRecyclerView
import com.dashingqi.uidemo.talk.TalkMessageAdapter
import com.dashingqi.uidemo.talk.TalksActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var contentView: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentView =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        btnProgress.setOnClickListener(this)
        btnShowAlertDialog.setOnClickListener(this)
        btnListView.setOnClickListener(this)
        btnRecyclerView.setOnClickListener(this)
        btnMake9Pic.setOnClickListener(this)
        btnJumpToTalk.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnProgress -> {
                pb.progress = pb.progress + 10
            }
            R.id.btnShowAlertDialog -> {
                showAlertDialog()
            }
            R.id.btnListView -> {
                jumpToListActivity()
            }

            R.id.btnRecyclerView -> {
                jumpToRecyclerActivity()
            }

            R.id.btnMake9Pic -> {
                imgSrc.setBackgroundResource(R.drawable.message_left_original)
            }
            R.id.btnJumpToTalk -> {
                startActivity(Intent(this, TalksActivity::class.java))
            }
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("this is dialog")
            setMessage("this is message")
            setCancelable(false)
            setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            setPositiveButton("OK") { dialog, which ->
                Toast.makeText(this@MainActivity, "ok,ok", Toast.LENGTH_LONG).show()
            }
            show()
        }
    }

    private fun jumpToListActivity() {
        Intent(this, ActivityList::class.java).apply {
            startActivity(this)
        }
    }

    private fun jumpToRecyclerActivity() {
        Intent(this, ActivityRecyclerView::class.java).apply {
            startActivity(this)
        }
    }

}
