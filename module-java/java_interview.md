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
