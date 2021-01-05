package com.dashingqi.module.camera

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    //获取到CameraManager的实例
    private val cameraManager: CameraManager by lazy {
        getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }

    companion object {
        private const val REQUEST_PERMISSION_CODE: Int = 1
    }


    //前置摄像头的ID
    private var frontCameraId = ""

    //后置摄像头的ID
    private var backCameraId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //获取到相机ID列表
        var cameraIdList = cameraManager.cameraIdList
        Log.d("cameraIdListSize == ", "${cameraIdList.size}")

        //根据相机ID获取CameraCharacteristics

        cameraIdList.forEach { cameraId ->
            //获取到摄像头的信息类 CameraCharacteristics
            var cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraId)
            if (cameraCharacteristics.isHardwareLevelSupported(REQUEST_PERMISSION_CODE)) {
                if (cameraCharacteristics[CameraCharacteristics.LENS_FACING] == CameraCharacteristics.LENS_FACING_FRONT) {
                    frontCameraId = cameraId
                } else if (cameraCharacteristics[CameraCharacteristics.LENS_FACING] == CameraCharacteristics.LENS_FACING_BACK) {
                    backCameraId = cameraId
                }
            }

        }

    }

    /**
     * 判断相机的Hardware Level 是否大于等于指定的Level
     *
     */

    fun CameraCharacteristics.isHardwareLevelSupported(requiredLevel: Int): Boolean {
        val storeLevels = intArrayOf(
            CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY,
            CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED,
            CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_FULL,
            CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL_3
        )

        //指定的Hardware Level 必须是 FULL以及以上
        val deviceLevel = this[CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL]

        if (requiredLevel == deviceLevel) {
            return true
        }

        for (storeLevel in storeLevels) {
            if (requiredLevel == storeLevel) {
                return true
            } else if (deviceLevel == storeLevel) {
                return false
            }
        }

        return false
    }
}