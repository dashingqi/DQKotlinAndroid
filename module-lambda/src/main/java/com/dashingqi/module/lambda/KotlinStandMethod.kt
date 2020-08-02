package com.dashingqi.module.lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * kotlin中标准库的高阶函数
 */
class KotlinStandMethod : AppCompatActivity() {

    /**
     * 定义一个集合
     */
    private val list = listOf<Int>(1, 3, 4, 56, -56)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koltin_stand_method)

//        findMethod()
//        firstAndLastMethod()
//        singleMethod()
        takeWhileMethod()

        filterMethod()

        countMethod()
    }

    /**
     * find()方法
     * find()方法用于查找并返回指定条件的第一个元素，没有找到符合条件的元素就返回NULL
     */
    private fun findMethod() {
        // 找到大于3的元素
        println("===========find 方法的练习=============")

        println("找到大于3的元素：${list.find { it > 3 }}")

        println("找到等于57的元素：${list.find { it == 57 }}")

        //运行结果
        /**
         *  2020-08-02 19:30:41.457 28142-28142/com.dashingqi.module.lambda I/System.out: 找到大于3的元素：4
         *  2020-08-02 19:30:41.457 28142-28142/com.dashingqi.module.lambda I/System.out: 找到等于57的元素：null
         */
    }

    /**
     * first和last方法的测试
     * first方法 用于查找并返回指定条件的第一个元素
     * last方法用于查找并返回指定条件的最后一个元素
     *
     * 如果这两个方法在查找的时候没有找到匹配的元素会在运行时抛出异常
     */
    private fun firstAndLastMethod() {

        println("=========first方法练习=============")
        println(
            "大于0的元素：${list.first { it > 0 }}"
        )

        println("=========last方法练习")

        println("大于0的元素：${list.last { it > 0 }}")

        println("等于5的元素：${list.first { it == 5 }}")


        /**
         * 运行结果
         *
         * 2020-08-02 19:39:47.926 28438-28438/com.dashingqi.module.lambda I/System.out: =========first方法练习=============
         * 2020-08-02 19:39:47.926 28438-28438/com.dashingqi.module.lambda I/System.out: 大于0的元素：1
         * 2020-08-02 19:39:47.926 28438-28438/com.dashingqi.module.lambda I/System.out: =========last方法练习
         * 2020-08-02 19:39:47.926 28438-28438/com.dashingqi.module.lambda I/System.out: 大于0的元素：56
         *
         * 使用first查找没有符合条件的元素，在运行时抛出如下异常
         * java.util.NoSuchElementException: Collection contains no element matching the predicate.
         */
    }

    /**
     * single()方法用于在当前的集合中查找满足指定条件的一个元素。
     * 需要注意的是，满足条件的元素只能有一个，多个或者没有都会抛出异常
     */
    private fun singleMethod() {

        println("==============single方法的练习==============")
        println("大于4的元素：${list.single { it > 4 }}")

        println("大于1的元素：${list.single { it > 1 }}")


        /**
         * 运行结果
         * ==============single方法的练习==============
         * 2020-08-02 19:46:55.768 28789-28789/com.dashingqi.module.lambda I/System.out: 大于4的元素：56
         *
         * java.lang.RuntimeException:
         * Unable to start activity ComponentInfo{com.dashingqi.module.lambda/com.dashingqi.module.lambda.KotlinStandMethod}:
         * java.lang.IllegalArgumentException: Collection contains more than one matching element.
         */
    }


    /**
     * takeWhile()方法 可以查找多个满足条件的元素
     * takeWhile()方法 首先会匹配集合中的第一个元素，如果符合条件的话就继续查找，不符合条件就停止查找返回一个[]
     */
    private fun takeWhileMethod() {
        println("============takeWhile()方法============")

        println("大于1的元素：${list.takeWhile { it > 1 }}")

        println("大于0的元素：${list.takeWhile { it > 0 }}")


        /**
         * 运行结果
         * 2020-08-02 19:55:00.571 29109-29109/com.dashingqi.module.lambda I/System.out: ============takeWhile()方法============
         * 2020-08-02 19:55:00.571 29109-29109/com.dashingqi.module.lambda I/System.out: 大于1的元素：[]
         * 2020-08-02 19:55:00.571 29109-29109/com.dashingqi.module.lambda I/System.out: 大于0的元素：[1, 3, 4, 56]
         */

    }

    /**
     * filter()方法同takeWhile方法的功能，只不过没有了takeWhile()第一个元素不匹配就返回[]的限制
     */
    private fun filterMethod() {

        println("============filter()方法==============")
        println("大于1的元素：${list.filter { it > 1 }}")


        /**
         * 运行结果
         *
         * 2020-08-02 19:58:44.499 29580-29580/com.dashingqi.module.lambda I/System.out: ============filter()方法==============
         * 2020-08-02 19:58:44.499 29580-29580/com.dashingqi.module.lambda I/System.out: 大于1的元素：[3, 4, 56]
         */
    }

    /**
     * count方法用于查找符合提交的元素个数
     */
    private fun countMethod() {

        println("============count==============")
        println("查找大于1的元素个数：${list.count { it > 1 }}")
        println("查找小于-69的元素个数：${list.count { it < -69 }}")

        /**
         * 运行结果
         *
         * 2020-08-02 20:02:05.487 29911-29911/com.dashingqi.module.lambda I/System.out: ============count==============
         * 2020-08-02 20:02:05.487 29911-29911/com.dashingqi.module.lambda I/System.out: 查找大于1的元素个数：3
         * 2020-08-02 20:02:05.487 29911-29911/com.dashingqi.module.lambda I/System.out: 查找小于-69的元素个数：0
         */

    }
}