package com.dashingqi.module.recyclerview

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import me.tatarka.bindingcollectionadapter2.ItemBinding

/**
 *
 * @ProjectName: KotlinProject
 * @Package: com.dashingqi.module.recyclerview
 * @ClassName: PgotoWallViewModel
 * @Author: DashingQI
 * @CreateDate: 2020/8/31 11:31 PM
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/8/31 11:31 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class PhotoWallViewModel : ViewModel() {
    private var imgUrls = mutableListOf(
        "https://img.fulaishiji.com/images/goods/19883/big/03957c4d-6869-4cef-ad3e-824852f9da2b_800x800.png",
        "https://img.fulaishiji.com/images/goods/19307/big/e2635d9a-d5eb-4acf-b08c-44483a8554e2_800x800.jpg",
        "https://img.fulaishiji.com/images/goods/17249/big/3389ee28-5b14-4b55-8f5d-64a00d5deb37_800x800.jpg",
        "https://img.fulaishiji.com/images/goods/12461/big/b0be6cbd-3164-470b-b355-d9b41b0ce0e6_800x800.jpg",
        "https://img.fulaishiji.com/images/goods/16743/big/65843bf9-7ba1-48d0-884e-aefeebf9b635_964x964.jpg",
        "https://img.fulaishiji.com/images/goods/12534/big/3dabd1b5-f37f-4320-9832-fccbdc8e1ecf_800x800.jpg",
        "https://img.fulaishiji.com/images/goods/14897/big/e1c774c9-7003-4a4a-9e12-1bdf1d729457_800x800.jpg",
        "https://img.fulaishiji.com/images/goods/12753/middle/95f064c5-8bfc-44d6-a7d8-5058cb3f93e7_800x800.jpg",
        "https://img.fulaishiji.com/images/goods/10396/middle/e174305c-b32c-4b9d-a0b1-a14de0ae011a_3648x3648.jpg",
        "https://img.fulaishiji.com/images/goods/17824/middle/19d6253c-1ef9-48f0-b63f-d01d2f354eee_2728x2728.jpg",
        "https://img.fulaishiji.com/images/goods/17337/middle/9974521a-34c4-4daf-9c07-717dface9cce_800x800.jpg",
        "https://img.fulaishiji.com/images/goods/13223/middle/a0a32982-3af5-45ae-9252-a554503ec829_800x800.jpg",
        "https://img.fulaishiji.com/images/goods/19906/middle/41dca304-69b2-490f-b001-0b99fa4fcc60_1008x1008.jpg",
        "https://img.fulaishiji.com/images/goods/19653/middle/c31cca8b-7468-4d5f-a06c-8427a7d01656_800x800.jpg"
    )

    val items = ObservableArrayList<String>()
    val itemBinding = ItemBinding.of<String>(BR.item, R.layout.item_photo_wall)

    init {
        for (index in 0 until 200) {
            val position = (Math.random() * (imgUrls.size - 1)).toInt()
            items.add(imgUrls[position])
        }
    }
}