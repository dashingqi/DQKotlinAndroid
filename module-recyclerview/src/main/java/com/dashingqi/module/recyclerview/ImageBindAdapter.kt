package com.dashingqi.module.recyclerview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * @author : zhangqi
 * @time : 2020/8/30
 * desc :
 */
object ImageBindAdapter {

    @JvmStatic
    @BindingAdapter(value = ["imageUrl"], requireAll = false)
     fun setImageUrl(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }
}