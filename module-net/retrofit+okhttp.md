#### OkHttp
###### 构建OkHttp
- OkHttpClient
- Request （构建请求的Request）
    - Header
    - Body
    - 参数
    
- Call (构建请求的Call)
- Call.enqueue/execute （发送网络请求）---> 将请求任务放到一个线程池中
- Response (Response.body)
- 在进行数据解析时候需要拿到Response中的Body进行解析后，在进行数据展示，数据展示的时候需要手动切换线程

###### 使用上的一些问题问题

1. 构建网络请求的参数比较麻烦 （body，请求头以及参数）
2. 网络请求成功后 我们需要手动拿到的response中的body来进行解析
3. 线程切换需要手动去执行，无法自动切换
4. 会存在嵌套的网络请求


#### Retrofit

网络请求是基于Http请求的，
Retrofit是不具有网络请求的功能，OkHttp是具有网络请求的功能
Retrofit是对于OkHttp的一层封装
优化网络请求的使用过程
解决业务最后一公里的问题

动态代理---> invoke函数中可以获取到接口实现类调用的方法信息 ----> 这样就可以统一配置请求的参数（构建Request ）
接口中的方法是没有用的，有用的是配置上的参数（注解对应的）

###### 构建一个Retrofit的一个标准
1. bseUrl
2. callFactory: 网络请求工厂 ----> OkHttpClient
3. callbackExecutor:回调方法执行器 -----> 线程切换 使用了handler
4. 数据转换器 converterFactory
5. 网络请求适配器 adapterFactory ----> 适配器工程 RxJavaCallAdapterFactory / Call
也可以自定适配器 就是将OkHttp的Call转换成Retrofit的Call

###### 为什么要有Retrofit
1.  使用OkHttp构建网络请求比较麻烦，Retrofit使用注解+动态代理+client 就可以解决
2.  自动的线程切换

##### 设计模式

###### 建造者模式：（什么情况下使用 ---> 对象比较复杂）
1. 构造函数的参数超过5个
2. 存在可选的参数

###### 外观模式
- 网络请求的外部接口

###### 工厂模式
抽象工厂模式

###### 适配器模式

retrofit的核心 就是 retrofit.create()


RxJava解决嵌套的问题 ----> 链式调用