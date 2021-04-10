####  智能的操作
- 修改打包后输出的目录
- 提高打包速度

#### build.gradle脚本

在gradle中一个原子性的操作叫做task，可以将task理解为Gradle脚本中的最小可执行单元
在AS中，gradle构建脚本默认的名字是build.gradle，当我们在终端中执行gradle命令时，Gradle会去当前目录下寻找名字是build.gradle的文件

###### 输出Hello World

```
task helloWorld{
    doLast{
        println "Hello World!"
    }
}
```
###### gradle常用的命令

- 执行一个task : gradle taskName
- 获取脚本中所有的task : gradle tasks --all

#### Gradle脚本构建的生命周期

gradle构建的时候都会执行3个不同的生命周期阶段

- 初始化
Gradle为每一个项目创建一个Project实例，在多项目构建中，Gradle会找出哪些项目依赖需要参与到构建中。

- 配置
执行所有项目的构建脚本，也就是执行每个项目中的build.gradle文件
此时我们配置的task任务也会在这个阶段执行

- 执行

gradle脚本按照顺序依次执行task


## mac中配置gradle命令

#### 使用AndroidStudio自带的gradle
[参考配置链接](https://blog.csdn.net/sweetzhangxue/article/details/75419452)

#### 从官网下载gradle，自己配置

###### 官网历史版本下载地址
[gradle历史版本下载](https://services.gradle.org/distributions/)
###### 解压到全英文路径下
###### 将gradle配置到 .bash_profiler文件中
- touch ~/.bash_profiler
在用户目录下创建 .bash_profiler文件（如果存在就不会创建了）
- open ~/.bash_profiler
打开.bash_profiler文件
- 配置gradle命令
export GRADLE_HOME="/Users/username/material/Gradle/gradle-6.7.1"
export PATH=$PATH:$GRADLE_HOME/bin
- source ~/.bash_profiler    
让配置的命令生效
- 检查gradle命令配置是否生效
gradle -v (在Terminal中执行)
- 检查效果
```

------------------------------------------------------------
Gradle 6.7.1
------------------------------------------------------------

Build time:   2020-11-16 17:09:24 UTC
Revision:     2972ff02f3210d2ceed2f1ea880f026acfbab5c0

Kotlin:       1.3.72
Groovy:       2.5.12
Ant:          Apache Ant(TM) version 1.10.8 compiled on May 10 2020
JVM:          13.0.2 (Oracle Corporation 13.0.2+8)
OS:           Mac OS X 10.16 x86_64

```  

#### gradle 与./gradlew 
当我们配置好了gradle命令的时候我们可以在终端的任意位置去执行build.gradle文件中的task
但是我们的./gradlew 只能依赖于当前AS中的Project来说
当我们在用户目录下新建一个build.gradle文件 写入task(helloWorld) 我们可以通过使用gradle来执行脚本 gradle helloWorld
但是我们不能使用./gradlew

###### ./gradlew（其中./gradlew.bat 是win下执行的脚本）
这个在AS中的实际意义也是执行一个脚本，只不过我们不能在终端任意位置使用，只能在AS的Project环境下使用这个
**执行原理如下**
- 1. 解析gradle-wrapper.properties文件，获取项目需要的 gradle 版本下载地址。
- 2. 判断本地用户目录下的~/.gradle目录下是否存在该版本，不存在该版本，走第3点，存在走第4点。
- 3. 下载gradle-wrapper.properties指定版本，并解压到用户目录的下 ~/.gradle文件下。
- 4. 利用 ~/.gradle目录下对应的版本的 gradle 进行相应自动编译操作。

#### 在项目和module的build.gradle脚本文件执行task
```groovy
task updateTask {
        doLast {
            println "perform update"
        }
    }
```
###### 使用gradle执行updateTask
gradle updateTask
```groovy
// project下的执行结果
> Task :updateTask
perform update
:updateTask spend 1ms

//module下的执行结果
> Task :module-gradle:updateTask
perform update
:module-gradle:updateTask spend 0ms

```

###### 使用./gradlew执行updateTask
./gradlew updateTask
```groovy
> Task :updateTask
perform update
:updateTask spend 1ms

> Task :module-gradle:updateTask
perform update
:module-gradle:updateTask spend 0ms

```

#### Task Actions

一个Task是由一个序列Action组成的，当运行一个Task的时候，这个Task里面的Action序列会按照顺序依次执行。
Task里的Action只会在该Task真正运行时执行，Gradle里通过doFirst、doLast来为Task增加Action。

- doFirst：task执行时最先执行的操作。
- doLast: task执行时最后执行的操作。

```groovy
task task1{
    println "this is task1"
}

task task2{
    println "this is task2"
}

task1.doFirst{
    println "task1 doFirst"
}

task1.doLast{
    println "task1 doLast"
}

task2.doLast{
    println "task2 doLast"
}
```
使用gradle命令执行 task ---> task1,执行结果如下

```groovy
> Task :module-gradle:task1
task1 doFirst
task1 doLast
:module-gradle:task1 spend 46ms
```

对于task的Actions只会在Task执行的时候才会执行


#### Gradle优势
###### 项目自动化
###### 构建工具
- APK的构建过程
###### 优势点
有着约定优于配置的方法、强大的依赖管理
构建脚本使用Groovy或者Kotlin编写，
是Android官方构建工具。

#### Groovy
Groovy是Apache下的一种基于JVM的面向对象语言，既可以用于面向对象编程，也可以用作纯粹的脚本语言

###### 变量的定义
Groovy中用def关键字来定义变量,
我们可以不指定变量的类型，默认的访问修饰符是public
def a = 1;
def int b = 2;
def c = "Hello World"

###### 方法的定义
方法使用返回值类型或者def关键字定义，方法可以接受任意数量的参数
def add(int c,int d){
    println c+d
}

def minus(e,f){
    println e-f
}

如果指定了方法返回类型，可以不需要使用def关键字

int add(int a,int b){
    return a-b
}

如果不使用return，方法的返回值为最后一段代码的执行结果
int add(int a,int b){
    a+b
}

###### 类
class Person {
    String name
    Integer age = 20

    def increaseAge(Integer years) {
        this.age += years
    }
}

def p = new Person()
p.increaseAge 5
print p.age

Groovy中的类和Java中的类很相似

默认类的修饰符是public
类不需要与它的源文件有相同的名称，但还是建议采用相同的名称
没有可见性修饰符的字段会自动生成对应的setter和getter方法

###### 语句
- 断言
```groovy
task method1{
    doLast {
        assert 1+2 == 6
    }
}
```

- for循环
Groovy支持Java的for(int i=0;i<n;i++)和for(int i:array)形式的循环语句，
另外还支持for in loop形式。
支持遍历范围、列表、Map、数组和字符串多种类型

- for in loop 形式（遍历范围）
def x = 20
for (i in 0..4) {
    x += i
}
println x

- 遍历列表
for(i in [0,1,2,3,4]) {
    x += i
}

- 遍历map
```groovy
def map = ['a': 1, 'b': 2, 'c': 3]
for(v in map.values()){
    x += v
}
```

- switch语句
```groovy
def y = 16
def value = ""

switch (y) {
    case "ok":
        value = "found ok"
        break
    case [1, 23, 4, 5, 'list']:
        value = 'list'
        break
    case 10..19:
        value = "range"
        break
    case Integer:
        value = "integer"
        break
    default:
        value = "default"
        break
}

println value
```

#### 字符串
###### 单引号字符串
单引号可以定义一个字符串常量，但是不支持插值，
在Groovy中双引号字符串支持插值
###### 双引号字符串
双引号字符串支持插值，插值值得就是替换字符串中的占位符，占位符表达式位${}或者$
```groovy
def name = 'dashingqi'
//插值
println "hello ${name}"
println "hello $name"
```
###### 三引号字符串
三引号字符串的特点是可以保留文本的换行和缩进格式，不支持插值。
```groovy
def name1 = '''
       zhangqi
            dashingqi
       zhangqi'''
println name1

```


###### GString
在Groovy中，String是不可变的，GSting是可变的，
GString类型就是双引号字符串中包含了插值，就是GString类型

#### List

```groovy
def number = [1,2,3,4]
def linkedList instanceof list

println number[1]
// 索引-1是列表末尾的第一个元素。
println number[-1]

```

#### Map
创建Map使用[],需要同时制定Key和Value，默认的实现类位LinkedHashMap

```groovy

def names = [one:'zhangqi',two:'dashingqi',three:'zdq']
println names['one']
println names['two']


def key = 'name'
// 此时键对应的值是key这个字符串
def person = [key:'张琦']
if(person.containsKey(key)){
    println person['key']
}
// 此时键对应的值是变量key对应的name这个值
person = [(key):"DashingQi"]
if(person.containsKey('name')){
    println person[key]
}
```

#### 闭包

闭包的定义
{params -> statements}
params：参数部分
statements：语句部分


```groovy

def code = { 123 }
def isOddNumber = { i -> i % 2 != 0 }
println isOddNumber(5)
println code()

```

#### 文件

###### 文件读取

```groovy
// 声明一个文件地址
def filePath = '/Users/zhangqi/downloads/Test.java'

// 获取文件对象
def file = new File(filePath)
// 读取文件
file.eachLine { it ->
    println it
}

// println(file.text) 简洁的写法
```

###### 文件写入

```groovy

file.withWriterAppend { it ->
    it.println("class Test {")
    it.println("    public static void main(String args[]) {")
    it.print("\n")
    it.println("     }")
    it.println("}")

}
println(file.text)

```









