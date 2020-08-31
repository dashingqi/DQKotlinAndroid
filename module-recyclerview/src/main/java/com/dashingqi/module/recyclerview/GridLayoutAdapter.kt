package com.dashingqi.module.recyclerview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.grid_layout_item.view.*

/**
 * @author : zhangqi
 * @time : 2020/8/30
 * desc :
 */
class GridLayoutAdapter(var foodList: ArrayList<Food> = ArrayList()) :
    RecyclerView.Adapter<GridLayoutAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var itemView = View.inflate(parent.context, R.layout.grid_layout_item, null)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tvName.text = foodList[position].name
        holder.itemView.tvDesc.text = foodList[position].desc
        Glide.with(holder.itemView.context).load(foodList[position].imgUrl)
            .into(holder.itemView.ivCover)
    }

    class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    }
}