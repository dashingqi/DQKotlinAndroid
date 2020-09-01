package com.dashingqi.module.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.module.recyclerview.databinding.ItemAnimViewBinding

/**
 * @author : zhangqi
 * @time : 2020/9/1
 * desc :
 */
class RvAnimationAdapter(var datas: ArrayList<String>, var recyclerView: RecyclerView) :
    RecyclerView.Adapter<RvAnimationAdapter.MyViewHolder>() {

    /**
     * 用来记录当前是向上滑动的
     */
    var isScrollUp = false

    /**
     * 用来记录当前是向下滑动的
     */
    var isScrollDown = false

    /**
     * 动画
     */
    private val animation by lazy {
        AnimationUtils.loadAnimation(recyclerView.context, R.anim.item_anim_translate)
    }

    private val animationUpToDown by lazy {
        AnimationUtils.loadAnimation(recyclerView.context, R.anim.item_anim_up_to_down)
    }

    private val animationDownToUp by lazy {
        AnimationUtils.loadAnimation(recyclerView.context, R.anim.item_anim_down_to_up)
    }

    init {
        //为RV添加滑动事件的监听
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                isScrollUp = dy > 0
                isScrollDown = dy < 0
            }
        })


    }


    class MyViewHolder(var dataBinding: ItemAnimViewBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val dataBinding = DataBindingUtil.inflate<ItemAnimViewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_anim_view,
            parent,
            false
        )

        return MyViewHolder(dataBinding)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemDataBinding = holder.dataBinding as ItemAnimViewBinding
        itemDataBinding.item = datas[position]
        itemDataBinding.executePendingBindings()
    }

    /**
     * 当创建好的View依附到Window上时回调的
     */
    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        for (index in 0 until recyclerView.childCount) {
            //获取到Item
            val itemView = recyclerView.getChildAt(index)
            //清除每一个Item上的动画
            itemView?.clearAnimation()
        }

        // 当向上滑动的时候
        if (isScrollUp) {
            holder.itemView.startAnimation(animationDownToUp)
        }

        //当向下滑动的时候
        if (isScrollDown) {
            holder.itemView.startAnimation(animationUpToDown)
        }
    }
}