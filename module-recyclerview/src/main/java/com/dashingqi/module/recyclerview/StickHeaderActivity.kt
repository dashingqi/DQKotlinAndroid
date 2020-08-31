package com.dashingqi.module.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dashingqi.module.recyclerview.databinding.ActivityStickHeaderBinding
import kotlinx.android.synthetic.main.activity_stick_header.*

class StickHeaderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityStickHeaderBinding>(
            this,
            R.layout.activity_stick_header
        )
        dataBinding.viewModel = StickHeaderViewModel()

        val callback = object : StickHeaderItemDecoration.StickHeaderCallBack {
            override fun getGroupInfo(position: Int): GroupInfo {
                // 5个为一组
                var currentGroup = position / 20
                var groupPosition = position % 20
                var groupInfo = GroupInfo(currentGroup, "第${currentGroup}组")
                groupInfo.position = groupPosition
                groupInfo.groupLength =20
                return groupInfo
            }
        }

        rv.addItemDecoration(StickHeaderItemDecoration(callback))
    }
}