package com.dashingqi.uidemo.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.uidemo.Fruit
import com.dashingqi.uidemo.R

/**
 * @author : zhangqi
 * @time : 2020/5/2
 * desc :
 */
class FruitRecyclerAdapter(var data: ArrayList<Fruit>) :
    RecyclerView.Adapter<FruitRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_fruit, parent, false)
        var viewHolder = ViewHolder(view)
        viewHolder.apply {

            itemView.setOnClickListener { view ->
                var adapterPosition = adapterPosition
                var fruit = data[adapterPosition]
                Toast.makeText(parent.context, "this is ${fruit.fruitName}", Toast.LENGTH_LONG)
                    .show()
            }

        }
        return viewHolder
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var fruit = data[position]
        holder.tvFruitName.text = fruit.fruitName
    }
}