#### HashMap
###### 底层结构
- 1.7 是数组+单链表
- 1.8 数组+单链表+红黑树
###### 位置的确认
- int index = Hash(key)+(length-1)
###### 扩容
- 扩容因子 * 当前数组长度（需要扩容的条件）
- 新建一个长度是当前容量两倍的数组
###### 插入
- 1.7 是头插入 （两个线程同时并发操作 一个数组 ，此时正巧都会进行扩容）
https://blog.csdn.net/littlehaes/article/details/105241194
- 1.8 是尾插入 ---> 可以解决 get请求时候 死循环的问题

#### 反射
- 反射就是把类对象的各个部分给解剖成Java对象
- 正常我们的 .java文件 经过编译器 编译成.class文件 这个.class在 java中对应这个类对象（需要和类的对象作为区分）
- Java本身是面向对象的语言，它也会把类对象抽象成 一个类 Class
- Class （Field，Method，Constructor）

#### equals 和 hashcode

####### equals
是Object中的一个方法，所有集成Object的类都会有该方法，在Object类中该方法是用来比较两个实例的内存地址值是否相等
对于其他重写equals方法的类中
先比较内存地址值是否一样
再者比较类型是否一致
最后比较值是否一样

###### hashcode
是Object中的native方法，继承Object类都会有这个方法。
会针对不同的对象返回不同的整数（通过该对象的内存地址转换成一个整数）

为何要一起重写？
主要为了效率考虑

先调用这个对象的hashCode方法获取到一个值，根据这个值计算出这个元素所在的位置，如果位置上没有元素就放置上去
如果有了就调用equals()进行比较

重写规则

x.equasl(y) == true 那么x.hashCode == y.hashCode
x.equasl(y) == false 那么x.hashCode == y.hashCode 也可以不相等
如果 x.hascode != y.hashcode 那么 x.equals(y)==false

hashcode 是系统用来快速检索对象而使用的。

#### GC Root的类型

- 虚拟机栈（局部变量表）中引用的对象
- 活跃的线程对象
- 方法去中静态引用指向的对象
- native方法中jni引用的对象

#### 运行时数据区域分区，哪些是线程私有的，哪些线程共享
- 私有： 程序计数器，虚拟机栈，，本地方法栈
- 共享：堆，方法区

#### 栈帧的数据结构
- 局部变量表
- 操作数栈
- 动态连接
- 返回地址

#### 方法区存放什么数据
- 类的信息
- 常量
- 静态变量


#### Java中的wait()和sleep()的区别
- 调用了wait 就释放了锁
- 调用了sleep没有释放所，只是阻塞了线程执行


#### kotlin中的  in 和 out

out --> 协变 当你的泛型作为方法的返回值的时候  使用out
in ---> 逆变 当你的泛型作为方法的参数的时候，使用in





