package com.dashingqi.module.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dashingqi.dqcommonutils.DensityUtils

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.module.recyclerview
 * @ClassName: PhotoWallItemDecoration
 * @Author: DashingQI
 * @CreateDate: 2020/8/31 11:45 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/31 11:45 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class PhotoWallItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        var childPosition = parent.getChildAdapterPosition(view)
        when {
            childPosition % 4 == 0 -> {
                outRect.left = 0
                outRect.right = DensityUtils.dip2pxInt(parent.context, 0.5f)
            }
            childPosition % 4 == 1 -> {
                outRect.left = DensityUtils.dip2pxInt(parent.context, 0.5f)
                outRect.right = DensityUtils.dip2pxInt(parent.context, 0.5f)
            }
            childPosition % 4 == 2 -> {
                outRect.left = DensityUtils.dip2pxInt(parent.context, 0.5f)
                outRect.right = DensityUtils.dip2pxInt(parent.context, 0.5f)
            }
            childPosition % 4 == 3 -> {
                outRect.left = DensityUtils.dip2pxInt(parent.context, 0.5f)
                outRect.right = 0
            }
        }

        outRect.bottom = DensityUtils.dip2pxInt(parent.context, 1f)

    }
}