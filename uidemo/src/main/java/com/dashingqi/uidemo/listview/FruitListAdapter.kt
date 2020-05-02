package com.dashingqi.uidemo.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.dashingqi.uidemo.Fruit
import com.dashingqi.uidemo.R

/**
 * @author : zhangqi
 * @time : 2020/5/2
 * desc :
 */
class FruitListAdapter(var data: List<Fruit>) : BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View
        var viewHolder: ViewHolder
        if (convertView == null) {
            view = LayoutInflater.from(parent?.context).inflate(R.layout.item_fruit, parent, false)
            var tvFruitNamed: TextView = view.findViewById(R.id.fruitName)
            viewHolder = ViewHolder(tvFruitNamed);
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var fruit: Fruit = getItem(position) as Fruit
        if (fruit != null) {
            viewHolder.fruitName.text = fruit.fruitName
        }
        return view
    }

    override fun getItem(position: Int): Any = data.get(position)

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int = data.size

    inner class ViewHolder(val fruitName: TextView)
}