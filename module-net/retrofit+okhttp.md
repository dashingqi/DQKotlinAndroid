#### OkHttp
###### 构建OkHttp
- OkHttpClient
- Request （构建请求的Request）
- Call (构建请求的Call)
- Call.enqueue/execute （发送网络请求）
- Response (Response.body)

###### 问题
1. 构建网络请求的参数比较麻烦
2. 网络请求成功后 我们拿到的response中的body来进行解析
3. 线程切换需要手动去执行
4. 会存在嵌套的网络请求


#### Retrofit
###### 构建一个Retrofit的一个标准
1. bseUrl
2. callFactory: 网络请求工厂
3. callbackExecutor:回调方法执行器 -----> 线程切换 使用了handler
2. 数据解析器
3. 网络请求适配器 CallAdapter
4.
###### 为什么要有Retrofit
1.  使用OkHttp构建网络请求比较麻烦，Retrofit使用注解+动态代理+client 就可以解决
2.  自动的线程切换
3.

##### 设计模式

###### 建造者模式：（什么情况下使用 ---> 对象比较复杂）
1. 构造函数的参数超过5个
2. 存在可选的参数

###### 外观模式
- 网络请求的外部接口

###### 工厂模式

###### 适配器模式

retrofit的核心 就是 retrofit.create()


RxJava解决嵌套的问题 ----> 链式调用