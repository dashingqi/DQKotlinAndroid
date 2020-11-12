package com.chiatai.module_kotlin_appoint

import androidx.fragment.app.Fragment

/**
 * @author : zhangqi
 * @time : 2020/11/10
 * desc :
 */
class DelegateFragment : Fragment() {

    private var intValue :Int by fragmentArgument()
    private var intValue1:String? by fragmentNullArgument()

    companion object {
        fun newInstance(int1: Int, str2: String) {
            DelegateFragment().apply {
                    this.intValue = int1
                    this.intValue1 = str2
            }
        }
    }
}