package com.dashingqi.module_arithmetic

/**
 * @author : zhangqi
 * @time : 1/29/21
 * desc :
 */
class Config {

    /**
     * 饿汉
     */
    companion object {
        val instance by lazy(LazyThreadSafetyMode.NONE) {
            Config()
        }

        private var mInstance: Config? = null

        /**
         * 饿汉的线程安全
         */
        @Synchronized
        fun get(): Config {
            if (mInstance == null) mInstance = Config()

            return mInstance!!
        }


        /**
         * 双重检查模式
         */

        val dslInstance by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Config()
        }

        /**
         * 静态内部类的实现方式
         */
        fun getMyInstance() = Helper.instance

        object Helper {
            val instance = Config()
        }
    }


}