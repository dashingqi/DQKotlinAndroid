package com.dashingqi.module.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.module.recyclerview.databinding.ActivityRvAutoBinding
import kotlinx.android.synthetic.main.activity_rv_auto.*

class RvAutoActivity : AppCompatActivity() {

    val manager by lazy {
        autoRv.layoutManager as LinearLayoutManager
    }

    val viewModel by lazy {
        ViewModelProvider(this)[RvAutoViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val rvAutoBinding =
            DataBindingUtil.setContentView<ActivityRvAutoBinding>(this, R.layout.activity_rv_auto)
        rvAutoBinding.viewModel = viewModel

        autoRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                //获取到Adapter中当前设置的数据数量
                val itemCount = manager.itemCount
                //当前可见区域的最后一个ItemView的角标
                val lastVisiblePos = manager.findLastVisibleItemPosition()
                //获取到可见区域的最后一个ItemView
                val itemView = manager.getChildAt(manager.childCount - 1)
                //当itemView不为空的时候
                itemView?.let {
                    val lastIteViewTop = it.top
                    val autoRvBottom = autoRv.bottom
                    if (lastIteViewTop < autoRvBottom && lastVisiblePos == itemCount - 1) {
                        //加载更多数据
                        autoRv.post {
                            viewModel.loadMoreData()
                        }

                    }
                }
            }
        })
    }
}