package com.dashingqi.uidemo.talk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.dashingqi.uidemo.R
import kotlinx.android.synthetic.main.activity_talks.*

class TalksActivity : AppCompatActivity(), View.OnClickListener {

    val datas = ArrayList<Message>()

    //学习使用延迟初始化 lateinit
    private lateinit var talkAdapter: TalkMessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_talks)
        initData()
        talkAdapter = TalkMessageAdapter(datas)
        talkRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@TalksActivity)
            adapter = talkAdapter

        }

        btnSendMessage.setOnClickListener(this)
    }

    private fun initData() {
        datas.add(Message("Hello guy", Message.TYPE_RECEIVE))
        datas.add(Message("Hello who is that", Message.TYPE_SEND))
        datas.add(Message("this is tom,nice talking to you", Message.TYPE_RECEIVE))
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSendMessage -> {
                var content = editMessage.text.toString()
                datas.add(Message(content, Message.TYPE_SEND))
                talkAdapter?.notifyItemInserted(datas.size - 1)
                talkRecyclerView.scrollToPosition(datas.size - 1)
                editMessage.setText("")
            }
        }
    }

}
