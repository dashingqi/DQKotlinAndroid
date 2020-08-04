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
    private val list = listOf<Int>(1, 3, 4, 4, 3, 1, 56, -56)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_koltin_stand_method)

//        findMethod()
//        firstAndLastMethod()
//        singleMethod()
//        takeWhileMethod()
//
//        filterMethod()
//
//        countMethod()
//
//        maxByMethod()
//        minByMethod()
//        distinctByMethod()
//        repeatMethod()
        //runMethod()
//        mapMethod()
//        allMethod()
//        anyMethod()
//        groupByMethod()
        groupByMethodTest()
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

    /**
     * 练习使用 maxBy()方法，用于获取集合中元素最大的元素
     */
    private fun maxByMethod() {
        println("================maxBy================")
        println("查找集合中最大的元素：${list.maxBy { it }}")
    }

    /**
     * 练习使用minBy()方法，用于获取集合中最小的元素
     */
    private fun minByMethod() {

        println("==================minBy===============")
        println("查找集合中最小的元素：${list.minBy { it }}")

    }

    /**
     * distinctBy()对集合中的元素去重
     */
    private fun distinctByMethod() {
        println("===================distinctBy================")
        println("去重集合中的元素：${list.distinctBy { it }}")
    }

    /**
     * repeat()函数，用于重复执行某一条语句
     */
    private fun repeatMethod() {

        println("==========repeat函数===========")
        repeat(1) {
            println("重复执行这条语句1次")
        }

        repeat(2) {
            println("重复执行这条语句2次")
        }


        /**
         * 执行结果
         * 2020-08-03 09:22:32.750 11639-11639/com.dashingqi.module.lambda I/System.out: ==========repeat函数===========
         * 2020-08-03 09:22:32.750 11639-11639/com.dashingqi.module.lambda I/System.out: 重复执行这条语句1次
         * 2020-08-03 09:22:32.750 11639-11639/com.dashingqi.module.lambda I/System.out: 重复执行这条语句2次
         * 2020-08-03 09:22:32.750 11639-11639/com.dashingqi.module.lambda I/System.out: 重复执行这条语句2次
         */

    }

    /**
     * T.run()方法的练习
     */
    private fun runMethod() {

        var list = ArrayList<String>()
        val listSize = list.run {
            add("test1")
            add("test2")
            add("test3")
            //可以使用return语句来结束程序的运行，执行return会导致下面两个println()打印语句也不会执行
            // return
            // 使用 return@方法名 来结束当前方法的执行，下面两个println()打印语句会执行的，只是让当前所在的方法结束执行
            //return@run

            size
        }

        println("list ----> $list")

        println("size -----> $listSize")

    }

    /**
     * map()方法 可以操作集合中的每一个元素，然后把结果收集到一个新集合中
     * 但是不改变原集合中的元素
     */
    private fun mapMethod() {
        println("===============map()方法==================")
        println(
            "操作集合list ${list.map { it * 3 }}"
        )

        println("原集合  =======> $list")
    }

    /**
     * all()方法 如果你对所有元素都满足判断式感兴趣，就可以使用all函数
     */
    private fun allMethod() {
        println("================all()====================")
        println("all method perform ----> ${list.all { it > 4 }}")

        /**
         *  运行结果
         *  2020-08-04 00:23:58.312 2140-2140/com.dashingqi.module.lambda I/System.out: ================all()====================
         *  2020-08-04 00:23:58.312 2140-2140/com.dashingqi.module.lambda I/System.out: all method perform ----> false
         */
    }

    /**
     * any()方法，如果你要检查集合中是否存在一个匹配元素，就使用any
     */
    private fun anyMethod() {
        println("================any()====================")
        println("any method perform ------> ${list.any { it > 4 }}")

        /**
         *
         * 2020-08-04 00:23:58.313 2140-2140/com.dashingqi.module.lambda I/System.out: ================any()====================
         * 2020-08-04 00:23:58.313 2140-2140/com.dashingqi.module.lambda I/System.out: any method perform ------> true
         */
    }

    /**
     * groupBy()方法 会根据给定的条件 分成符合条件和不符合条件的两组数据 用一个map来装载
     */
    private fun groupByMethod() {
        println("================groupBy==================")
        println("groupBy perform ----> ${list.groupBy { it < 4 }}")

        /**
         * 运行结果
         * 2020-08-04 00:31:38.083 2560-2560/com.dashingqi.module.lambda I/System.out: ================groupBy==================
         * 2020-08-04 00:31:38.083 2560-2560/com.dashingqi.module.lambda I/System.out: groupBy perform ----> {true=[1, 3, 3, 1, -56], false=[4, 4, 56]}
         */
    }

    private fun groupByMethodTest() {
        var people = listOf(Person("person1", 22), Person("person2", 34), Person("Person3", 25))
        val ageList = people.groupBy { it.age }
        println("ageList -------> $ageList")

        var strList = listOf("ab", "abc", "c")

        val strGroupByList = strList.groupBy(String::first)

        println("strGroupList -------> $strGroupByList")
    }


    /**
     * 处理嵌套集合中的元素
     */
}