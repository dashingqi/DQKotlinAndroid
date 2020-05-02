package com.dashingqi.uidemo.talk

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author : zhangqi
 * @time : 2020/5/2
 * desc :
 */
class TalkMessageAdapter(var data: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    inner class RightMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}