package com.dashingqi.coroutines

/**
 * @author zhangqi61
 * @since 6/24/21
 */
class Method {

    fun method() {

        Thread(object : Runnable {
            override fun run() {

            }

        })


        Thread({

        })

        Thread {

        }

        MyThread(object :MyRunnable{
            override fun runTask(str: String) {

            }
        })
    }
}