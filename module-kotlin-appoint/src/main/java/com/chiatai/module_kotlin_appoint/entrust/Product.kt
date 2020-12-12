package com.chiatai.module_kotlin_appoint.entrust

/**
 * @author : zhangqi
 * @time : 12/12/20
 * desc :
 */
class Product {

    // 这是我们使用by关键字将属性price委托给了 PriceDelegate委托类
    var price: String  by PriceDelegate()
}