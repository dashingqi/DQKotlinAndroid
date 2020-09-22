package com.dashingqi.module.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_my_layout.*

/**
 * @author : zhangqi
 * @time : 2020/9/22
 * desc :
 */
class MyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_my_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initClickListener()
    }

    private fun initClickListener() {
        btnMy.setOnClickListener {
            Navigation.findNavController(btnMy)
                .navigate(R.id.action_myFragment_to_settingFragment)
        }
    }
}