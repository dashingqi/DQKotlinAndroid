package com.dashingqi.kotlinproject.属性委托

import androidx.fragment.app.Fragment

/**
 * @author : zhangqi
 * @time : 2020/11/10
 * desc : 使用属性委托进行传递参数到fragment中
 */
class DelegateFragment : Fragment() {

    var value1: Int?
        get() = arguments?.getInt(Args.args1)
        set(value) {
            value?.let {
                arguments?.putInt(Args.args1, it)
            } ?: arguments?.remove(Args.args1)
        }

    var value2: String?
        get() = arguments?.getString(Args.args2)
        set(value) {
            value?.let {
                arguments?.putString(Args.args2, value)
            } ?: arguments?.remove(Args.args2)
        }


    companion object {
        object Args {
            const val args1 = "args1"
            const val args2 = "args2"
        }

        fun newInstance(value1: Int, value2: String) {
            DelegateFragment().apply {
                this.value1 = value1
                this.value2 = value2
            }
        }
    }
}