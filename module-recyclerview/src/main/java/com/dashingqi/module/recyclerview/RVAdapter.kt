package com.dashingqi.module.recyclerview

import android.util.Log
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
class RVAdapter(var itemData: ArrayList<Food> = ArrayList()) :
    RecyclerView.Adapter<RVAdapter.MyViewHolder>() {
    private val TAG = "RVAdapter"
    private var viewHolderCount = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        viewHolderCount++
        Log.d(TAG, "onCreateViewHolder ---->$viewHolderCount")
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
        Log.d(TAG, ": onBindViewHolder")
        var dataBinding = holder.viewDataBinding as RvItemBinding
        dataBinding.item = itemData[position]
        dataBinding.executePendingBindings()
    }

    class MyViewHolder(var viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

    }

    companion object {
        private const val TAG = "RVAdapter"
    }
}