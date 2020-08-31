package com.dashingqi.module.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.dashingqi.module.recyclerview.databinding.ActivityPhotoWallBinding
import kotlinx.android.synthetic.main.activity_photo_wall.*

class PhotoWallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding = DataBindingUtil.setContentView<ActivityPhotoWallBinding>(
            this,
            R.layout.activity_photo_wall
        )
        rv.addItemDecoration(PhotoWallItemDecoration())
        dataBinding.viewModel = PhotoWallViewModel()
    }
}