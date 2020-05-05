## 函数的定义与调用
#### 创建集合
- 代码实操
   ```kotlin
        var hashSetOf = hashSetOf(1, 2, 3)
        //kotlin中的 ::class.java相当于Java中的getClass()方法
        println("hashSetOf == $hashSetOf set == ${hashSetOf::class.java}")
        var arrayListOf = arrayListOf(1, 2, 6, 8)
        println("arrayListOf === $arrayListOf")
        var hashMapOf = hashMapOf(1 to "one", 2 to "two", 3 to "three")
        println("hashMapOf === $hashMapOf") 
   ```
- kotlin没有采用自己的集合类，而是采用标准的Java集合类
- 获取列表中的最后一个元素和拿到数字列表中的最大值
    ```kotlin
        var string = arrayListOf("one", "two", "three")
        println("last == ${string.last()}")

        var numbers = arrayListOf(1, 56, 34, 6734)
        println("max == ${numbers.max()}")  
    ```
#### 让函数更好调用好
- 打印集合的内容
   ```kotlin
      var arrayListOf = arrayListOf(1, 2, 6, 8)
      println("arrayListOf === $arrayListOf")
      
     // 运行结果
     // arrayListOf === [1, 2, 6, 8]
     //集合默认都有一个默认的toString()实现，输出的格式化样式是固定的
   ```

###### kotlin中如何改这个样式
- kotlin中有工具来简化函数的声明，我们手动实现这个工具函数（joinToString()）

