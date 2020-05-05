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
  ```kotlin
    private fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
      ): String {
          var result = StringBuilder(prefix)
          for ((index, value) in collection.withIndex()) {
              if (index > 0) result.append(separator)
              result.append(value)
          }

          result.append(postfix)
          return result.toString()
    }
  ```
###### 默认值的参数
> Java中一个类中有太多的重载函数，看起来很不爽，kotlin中的默认值参数了解一下

- Kotlin中可以在声明函数的时候，指定参数的默认值，这样可以避免创建重载函数
- 参数的默认值是被编码到调用的函数中，不是调用的地方。
- @JvmOverloads注解
  - 该注解可以让编译器生成Java重载函数，从最后一个开始省略每个参数

#### 顶层函数和属性
###### 顶层函数
> 我的理解就是Java中通用的工具类函数，
- 在Kotlin中这些函数不属于任何一个类，但是属于包下的成员，其他包要使用，必须的导包
- 步骤
  - 创建一个.kt文件
  - 在该文件中声明一个函数，那么该函数就是一个顶层函数
  - 在kotlin中可以直接使用，
  - 在Java中调用的话，需要把默认参数补其，同时需要以静态函数的形式调用
    ```kotlin
         CommonFun.joinToString(list,"","","")
    ```
- 修改顶层函数所在的文件名
  - 使用 file:@JvmName("name")
  - 这行代码要放在文件的第一行也就是文件的开头
###### 顶层属性
- 和顶层函数一样，顶层属性也是独立放在一个文件中。
- 顶层属性和其他任意属性一样，都是通过访问器暴露给Java使用的（val声明的只有getter，var声明的有getter和setter）
- Java中 public static final 修饰的 等同于 kotlin中 const val
#### 扩展函数和属性
> 扩展函数就是一个类的成员函数，不过定义在类的外面。
> 扩展函数不能访问私有的或者是受保护的成员
- 代码实操（计算一个字符串的最后一个字符）
    ```kotlin
    fun String.getLastChar():Char = this.get(this.length-1)
   // 这个函数中 接受者类型是 String 接受者对象是 this 也就是引用；其中我们要扩展的函数是String中的get
- 代码实操-调用
    ```kotlin
    //我们可以想调用其他函数一样来调用这个扩展函数
    println("kotlin".getLastChar()) 
    ```
###### 导入扩展函数
> 定义的扩展函数不会在整个项目中都生效，如果想要使用就必须的导入它。
- 用和导入类一样的语法来导入单个函数
    ```kotlin
    import CommonFun.lastChar    
- 用 * 导入
  ```
    import CommonFun.* 
- 使用关键字来修改导入的类或者函数的名称
  ```
    import CommonFun.lastChar as last 
  ```
###### Java中调用扩展函数
> 实质上扩展函数就是一个静态函数，把调用对象作为了它第一个参数
- 代码实操-调用
  ```java
  CommonFun.lastChar("Kotlin");
  ```
###### 作为扩展函数的工具函数
- 将joinToString改造成扩展函数
   ```kotlin
     //使用扩展函数来改造joinToString
  fun <T> Collection<T>.joinToStrings(
       separator: String = "，",
       preFix: String = "(",
       postFix: String = ")"
   ): String {
       var result = StringBuilder(preFix)
       for ((index, value) in withIndex()) {
           if (index > 0) result.append(separator)
           result.append(value)
       }
       result.append(postFix)
       return result.toString()
   }
   ```
###### 不可重写的扩展函数
> 扩展函数不是类的一部分，是声明在类之外的。
> 定义的同名的扩展函数被调用通常由变量的静态类型决定的
> 扩展函数并不存在重写，kotlin会把它们当作静态函数对待
- 代码实操
  ```kotlin
   var button = Button(this)
   button.showOff()
   //运行结果 i am a button
   var view = View(this)
   view.showOff()
   // 运行结果 i am a view
   
   var view:View = Button(this)
   view.showOff()
   //运行结果 i am a view
   // 当你在调用一个类型为View的变量的showOff函数时，对应的扩展函数会被调用，尽管实际上这个变量现在是一个Button对象
  ```
###### 扩展属性
- 将定义好的扩展函数 lastChar 改造成扩展属性
  ```kotlin
   val String.lastChars: Char
   get() = get(length - 1) 
  ```
