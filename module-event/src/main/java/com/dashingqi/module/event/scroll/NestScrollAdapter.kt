package com.dashingqi.module.event.scroll

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.module.event.databinding.ItemScrollLayoutBinding

/**
 * @author : zhangqi
 * @time : 12/9/20
 * desc :
 */
class NestScrollAdapter(var data: ArrayList<String> = ArrayList()) :
    RecyclerView.Adapter<NestScrollAdapter.MyViewHolder>() {


    inner class MyViewHolder(var itemBinding: ItemScrollLayoutBinding) :
        RecyclerView.ViewHolder(itemBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val scrollItemBinding =
            ItemScrollLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(scrollItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemBinding = holder.itemBinding
        itemBinding.item = data[position]
        itemBinding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}