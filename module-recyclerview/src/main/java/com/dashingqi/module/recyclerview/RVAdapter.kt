package com.dashingqi.module.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.module.recyclerview.databinding.RvItemBinding

/**
 * @author : zhangqi
 * @time : 2020/8/27
 * desc :
 */
class RVAdapter(var itemData: ArrayList<String> = ArrayList()) :
    RecyclerView.Adapter<RVAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemBinding = DataBindingUtil.inflate<RvItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.rv_item,
            parent,
            false
        )
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return itemData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var dataBinding = holder.viewDataBinding as RvItemBinding
        dataBinding.item = itemData[position]
        dataBinding.executePendingBindings()
    }

    class MyViewHolder(var viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

    }
}