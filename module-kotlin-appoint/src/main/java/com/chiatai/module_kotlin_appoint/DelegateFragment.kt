package com.chiatai.module_kotlin_appoint

import androidx.fragment.app.Fragment

/**
 * @author : zhangqi
 * @time : 2020/11/10
 * desc :
 */
class DelegateFragment : Fragment() {

    private var int1: Int by argument()


    companion object {
        fun newInstance(int1: Int, str2: String) {
            DelegateFragment().apply {
                this.int1 = int1
            }
        }
    }
}