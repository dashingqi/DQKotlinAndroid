package com.dashingqi.uidemo.talk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.uidemo.R
import java.lang.IllegalArgumentException

/**
 * @author : zhangqi
 * @time : 2020/5/2
 * desc :
 */
class TalkMessageAdapter(var data: ArrayList<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val leftTextView: TextView = view.findViewById(R.id.leftMsg)
    }

    inner class RightMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rightTextView: TextView = view.findViewById(R.id.rightMsg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == Message.TYPE_RECEIVE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            LeftMessageViewHolder(view)
        } else {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
            RightMessageViewHolder(view)
        }

    override fun getItemViewType(position: Int) = data[position].type

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LeftMessageViewHolder -> {
                holder.leftTextView.text = data[position].content
            }
            is RightMessageViewHolder -> {
                holder.rightTextView.text = data[position].content
            }
            else -> throw  IllegalArgumentException()
        }
    }
}