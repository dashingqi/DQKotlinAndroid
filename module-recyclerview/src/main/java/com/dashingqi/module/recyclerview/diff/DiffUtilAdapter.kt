package com.dashingqi.module.recyclerview.diff

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.module.recyclerview.Food
import com.dashingqi.module.recyclerview.databinding.RvItemBinding

/**
 * @author : zhangqi
 * @time : 12/11/20
 * desc :
 */
class DiffUtilAdapter(var datas: ArrayList<Food> = ArrayList()) :
    RecyclerView.Adapter<DiffUtilAdapter.DiffUtilViewHolder>() {


    class DiffUtilViewHolder(var itemBinding: RvItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffUtilViewHolder {
        return DiffUtilViewHolder(
            RvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DiffUtilViewHolder, position: Int) {
        Log.d("onBindViewHolder", "perfrom")
        var itemBinding = holder.itemBinding
        itemBinding.item = datas[position]
        itemBinding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}