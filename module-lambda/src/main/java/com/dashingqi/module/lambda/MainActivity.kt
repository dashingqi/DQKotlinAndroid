package com.dashingqi.module.lambda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import com.dashingqi.module.lambda.Sequence.SequenceActivity
import com.dashingqi.module.lambda.Site.OS
import com.dashingqi.module.lambda.Site.SiteVisit
import com.dashingqi.module.lambda.country.Country
import com.dashingqi.module.lambda.invoke.InvokeData
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {


    var function: ((a: Int, b: Int) -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //匿名函数
//        val result = fun(arg1: Int, arg2: Int): Int {
//            return arg1 + arg2
//        }
//
//        var result1 = test { arg1: Int, arg2: Int -> arg1 + arg2 }
//
//        var result2 = test { arg1, arg2 -> arg1 + arg2 }
//
//        println("result1 ----> $result1, result2 ----> $result2")

//        lambdaTestOne()
//        lambdaTestTwo()
//        lambdaTestThree()
//        testLambdaReturnValue()

//        testFour()

//        testAsParameter()

        testAsReturnValue()
        //具体的lambda表达式体
        function = { a, b ->
            println("a == $a, b=== $b")
        }

        btnStandMethod.setOnClickListener {
            function?.invoke(4, 5)
//            Intent(this, KotlinStandMethod::class.java).apply {
//                startActivity(this)
//            }
        }

        btnInLineMethod.setOnClickListener {
            Intent(this, InLineActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnSequenceOperate.setOnClickListener {
            Intent(this, SequenceActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnJavaMethodInterface.setOnClickListener {
            Intent(this, JavaMethodInterfaceActivity::class.java).apply {
                startActivity(this)
            }
        }

        //测试自己定义的filter函数
        val newStr = "abfcdsd1323asdas".filter { it in 'a'..'z' }

        println("newString ----> $newStr")

        testSite()

        invokeMethod()

    }


    //具名函数
    fun sum(args1: Int, args2: Int): Int {
        return args1 + args2
    }

    //匿名函数也可以作为参数使用，定义一个传入匿名函数参数的函数
    fun test(action: (Int, Int) -> Int): Int {
        return action(1, 2)
    }

    // action:(Int,Int),它的意思是传入一个Lambda表达式是传入两个int，返回一个int，在这个函数中调用action(1,2)的意思是执行这个lambda表达式，传入的参数是1和2


    //当lambda表达式只有一个参数的时候，你可以在你的代码中将其省略，并用it来代替，这是一个很有用的特性


    /**
     * 这是一个测试lambda表达式的函数
     *  用来测试无参数有返回值的lambda表达式
     */
    private fun lambdaTestOne() {
        { println("this is test one") }()
    }

    /**
     * 这是用来测试lambda表达式 有参数有返回值的函数
     */
    private fun lambdaTestTwo() {
        val sum = { a: Int, b: Int -> a + b }(4, 5)
        println("sum === $sum")
    }

    /**
     * 我们将一个lambda表达式赋值给一个变量
     * 我们通过变量来调用lambda表达式
     */
    private fun lambdaTestThree() {
        val sum = { a: Int, b: Int -> a + b }
        println("totalSum === ${sum(10, 10)}")
    }

    /**
     * 这是测试lambda表达式的返回值类型的
     */
    private fun testLambdaReturnValue() {
        println("=========================")

        val result1 = {
            println("输出语句1"); "字符串"
        }()

        println("返回值：$result1")
        println("返回值类型：${result1.javaClass}")


        println("=========================")

        val result2 = {
            println("输出语句1");
            println("输出语句2");
            18
        }()

        println("返回值 $result2")
        println("返回值类型 ${result2.javaClass}")

        println("=========================")

        val result3 = {
            println("输出语句1")
            println("输出语句2")
            true
        }()

        println("返回值 $result3")
        println("返回值类型 ${result3.javaClass}")

    }

    /**
     * 这是用来练习子啊Lambda表达式的实际返回值后面书写语句
     */
    private fun testFour() {
        val result = { a: Int, b: Int ->
            a + b
            "我是int"
        }(5, 6)

        println("result ---> $result")
    }


    /**
     * 这是用来测试Lambda作为参数的测试
     */
    private fun testAsParameter() {
        //定一个Int数组
        val list = 1..20
        //筛选能被10整除的
        println("==========================")
        //没有使用it关键字之前
        println(list.pickNUm(2) { y: Int -> y % 10 == 0 })
        //使用关键字之后
        println(list.pickNUm(2) { it % 10 == 0 })
    }

    /**
     * function: (Int) -> Boolean
     *
     * function: 形式参数名，可以任意修改
     *
     * (Int) -> Boolean 形式参数类型 这里描述的是一个函数类型，函数的参数是Int类型 函数的返回值是Boolean类型的
     */
    private fun IntRange.pickNUm(need: Int, function: (Int) -> Boolean): List<Int> {

        //声明一个集合
        val resultList = mutableListOf<Int>()

        // this 指向定义的区间范围（IntRange）
        for (i in this) {
            if (function(i)) {
                resultList.add(i)
            }
        }
        return resultList
    }


    fun testAsReturnValue() {
        val normalPrice = getPrice(USER.NORMAL)(400.0)
        println("normalPrice ----> $normalPrice")

        val vipPrice = getPrice(USER.VIP)(400.0)
        println("vipPrice ----> $vipPrice")
    }

    /**
     * lambda表达式作为返回值
     *
     * (Double) -> double
     *
     * (Double) 是作为Lambda表达式的参数类型
     *
     * -> Double 是作为返回返回值类型也就是 getPrice()函数
     */
    private fun getPrice(userType: USER): (Double) -> Double {

        if (userType == USER.NORMAL) {
            return { it }
        }

        return { price -> 0.88 * price }

    }


    /**
     * 刚开始仅仅就是查找世界上属于欧洲的国家
     */
    private fun filterCountry(country: List<Country>): List<Country> {
        val countries = mutableListOf<Country>()

        for (c in country) {
            if (c.continitent == "EU") {
                countries.add(c)
            }
        }
        return countries
    }


    /**
     * 后来又对非洲产生出来兴趣了，继续改造,增加一个字段
     */
    private fun filterCountry(country: List<Country>, continitent: String): List<Country> {
        val countries = mutableListOf<Country>()

        for (c in country) {
            if (c.continitent == continitent) {
                countries.add(c)
            }
        }
        return countries
    }

    /**
     * 然后在之前的基础上，又要对人口有要求了，就继续改造了
     */

    private fun filterCountry(
        country: List<Country>,
        continitent: String,
        popular: Int
    ): List<Country> {
        val countries = mutableListOf<Country>()

        for (c in country) {
            if (c.continitent == continitent && c.popular > popular) {
                countries.add(c)
            }
        }
        return countries
    }

    /**
     * 按照这样的设置，函数的参数会随着筛选条件的增加在不断的扩大，需要使用函数类型参数
     *
     * (Int)-> Unit
     *
     * 使用 -> 来链接参数类型和返回值类型
     * 使用括号来包裹参数类型
     * 返回值类型即使是Unit ，也必须要显示指出
     * 如果是没有参数类型的 ,参数类型部分就保留小括号
     *
     */

    private fun filterCountry(country: List<Country>, filter: (Country) -> Boolean): List<Country> {
        val countries = mutableListOf<Country>()

        for (c in country) {
            if (filter(c)) {
                countries.add(c)
            }
        }
        return countries
    }

    /**
     * 实现一个filter函数，过滤掉字符串中不属于 a..z
     */

    private fun String.filter(method: (value: Char) -> Boolean): String {
        var values = StringBuilder()
        //这里面的this 指代的是String --->
        for (index in this.indices) {
            if (method(get(index))) values.append(get(index))
        }
        return values.toString()
    }


    private fun testSite() {
        val log2 = listOf(
            SiteVisit("/", 34.0, OS.WINDOW),
            SiteVisit("/", 22.0, OS.MAC),
            SiteVisit("/login", 12.0, OS.WINDOW),
            SiteVisit("/signup", 8.0, OS.IOS),
            SiteVisit("/", 16.3, OS.ANDROID)
        )

        val data = log2.averageDuration { it.os in setOf(OS.ANDROID, OS.MAC) }
    }

    private fun List<SiteVisit>.averageDuration(predicate: (SiteVisit) -> Boolean): Double {
        val data = filter(predicate).map(SiteVisit::duration)
        println("data ---> $data")
        return data.average()
    }


    private fun invokeMethod() {
        var invokeData = InvokeData("this is name")
        invokeData()
    }


    private fun lambdaNoParams() {

        //声明一个lambda表达式
        var function = { println("test") }
        //执行lambda表达式
        function()
    }

    private fun lambdaWithParams() {
        var function = { a: Int, b: Int -> println("test") }
    }


}
