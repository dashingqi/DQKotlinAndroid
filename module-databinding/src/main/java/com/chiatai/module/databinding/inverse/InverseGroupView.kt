package com.chiatai.module.databinding.inverse

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.chiatai.module.databinding.R

/**
 * @author : zhangqi
 * @time : 12/7/20
 * desc : 使用DataBinding来自定义属性的双向绑定
 */
class InverseGroupView : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defStyle: Int) : super(
        context,
        attributeSet,
        defStyle
    )

    /**
     * 当前选中的index
     */
    var selectIndex: Int = 0

    /**
     * tag点击事件的回调事件
     */
    var onSelectChangeListener: ((Int) -> Unit)? = null

    /**
     * 用于收集回收可复用的View
     */
    var recyclerView = ArrayList<View>()

    /**
     * 用于存储拿到的数据
     */
    var mData: List<Any>? = null


    /**
     * 设置数据
     */
    fun <T : Any> setData(data: List<T>) {
        updateViewData(data)
    }

    /**
     * 更新布局的数据
     * 创建布局，将数据设置到布局上
     * data:新的数据源
     */
    private fun <T : Any> updateViewData(data: List<T>) {
        mData = data
        // 每次执行到这个方法时，需要回收一下，移除一下，因为接下来是要重新绑定数据的，
        recyclerViewMethod()
        /**
         * 遍历循环数据源，将数据绑定帮控件上
         */
        data.forEachIndexed { index, any ->
            val tagView = getReuseView()
            val tvTagView = tagView.findViewById<TextView>(R.id.tag)
            tagView.isSelected = index == selectIndex
            tvTagView.text = any as String
            //设置一下点击事件
            tagView.setOnClickListener {
                //应该是更新下布局上按钮的状态
                refreshSelectedIndex(index)
            }
            // 将View添加到父布局中
            addView(tagView)
        }
    }

    /**
     * 刷新下选中的子View
     */
    private fun refreshSelectedIndex(clickIndex: Int) {
        selectIndex = clickIndex
        for (i in 0 until childCount) {
            getChildAt(i).isSelected = i == clickIndex
        }
        onSelectChangeListener?.invoke(clickIndex)
    }

    /**
     * 获取到布局View对象
     */
    private fun newView(): View {
        return LayoutInflater.from(context).inflate(R.layout.item_tag, null, false)
    }

    /**
     * 获取到布局文件
     * 回收池中有 就拿第一个，
     * 没有的话就重新常见一个View对象
     */
    private fun getReuseView(): View {
        return if (recyclerView.isNotEmpty() && recyclerView.size > 0) {
            recyclerView.removeAt(0)
        } else {
            newView()
        }
    }

    /**
     * 首先将目前布局上已经有的子View存储到复用池中
     * 然后将这些子View从布局上移除
     */
    private fun recyclerViewMethod() {
        for (i in 0 until childCount) {
            recyclerView.add(getChildAt(i))
        }
        removeAllViews()
    }


    companion object {
        /**
         * 设置数据源
         */
        @JvmStatic
        @BindingAdapter(value = ["data"], requireAll = true)
        fun setData(inverseGroupView: InverseGroupView, data: List<String>?) {
            data?.let {
                inverseGroupView.setData(it)
            }
        }

        /**
         * 设置角标
         * 当数据发生边改的时候，会调用该方法设置数据 更新UI
         */
        @JvmStatic
        @BindingAdapter(value = ["index"], requireAll = true)
        fun setIndex(inverseGroupView: InverseGroupView, index: Int) {
            if (inverseGroupView.selectIndex == index) return
            inverseGroupView.selectIndex = index
            inverseGroupView.refreshSelectedIndex(index)
        }

        /**
         * 获取到当前选中的角标
         * event：数据改变的事件
         *
         * 当View的状态发生改变的时候（包括数据的填充，bg的改变），会调用该方法来获取到值
         */
        @JvmStatic
        @InverseBindingAdapter(attribute = "index", event = "indexChange")
        fun getIndex(inverseGroupView: InverseGroupView) = inverseGroupView.selectIndex

        /**
         * 双向数据绑定的
         * InverseBindingListener 是一个监听器，用来处理属性改变时的通知
         * 在这里我们给View设置了点击事件，当属性发生改变它会回调 onChange方法告诉DataBinding 去 @InverseBindingAdapter修饰的方法中取到值 然后设置给绑定的变量
         */
        @JvmStatic
        @BindingAdapter("indexChange")
        fun setIndexChangeListener(
            inverseGroupView: InverseGroupView,
            changeListener: InverseBindingListener?
        ) {
            if (changeListener != null) {
                inverseGroupView.onSelectChangeListener = {
                    changeListener.onChange()
                }
            } else {
                inverseGroupView.onSelectChangeListener = null
            }
        }
    }

}