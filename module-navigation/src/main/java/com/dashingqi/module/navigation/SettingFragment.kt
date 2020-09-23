package com.dashingqi.module.navigation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_setting_layout.*

/**
 * @author : zhangqi
 * @time : 2020/9/22
 * desc :
 */
class SettingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting_layout, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBackListener()
//        val name = SettingFragmentArgs.fromBundle(requireArguments()).name!!
//        Log.d("tag name == ", name)

    }


    private fun initBackListener() {
        btnSetting.setOnClickListener {
//            Navigation.findNavController(btnSetting)
//                .popBackStack()
        }
    }
}