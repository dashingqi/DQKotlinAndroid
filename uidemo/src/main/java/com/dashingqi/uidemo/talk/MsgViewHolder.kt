package com.dashingqi.uidemo.talk

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.uidemo.R
/**
 * @author : zhangqi
 * @time : 2020/5/2
 * desc :
 * 密封类
 */
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view)

class LeftViewHolder(view: View) : MsgViewHolder(view) {
    var leftTextView: TextView = view.findViewById(R.id.leftMsg)
}

class RightViewHolder(view: View) : MsgViewHolder(view) {
    var rightTextView: TextView = view.findViewById(R.id.rightMsg)
}