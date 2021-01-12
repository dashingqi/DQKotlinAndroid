
#### JS调用原生
- setJavaScriptEnabled（true）
- 本地声明一个类，类中使用@JavaScriptInterface 注解修饰被js调用的方法
- 同时将这个类添加到 webView中 addJavaScriptInterface(new Object(),"android");

js调用Android的方法不是在主线程中，是在WebView的core线程，所以我们需要切换到UI线程中

#### 原生调用JS
- mmWebView.loadUrl(String.format("javascript:onLoginResult('%s')", new Gson().toJson(waLoginResult))


#### JSBridge
- 提供native与非native双向通信的桥梁  就是 js可以调用原生 ，原生可以调用js的一个东西
###### 原理

###### 通信原理
JS调用原生
- 注入API：通过 WebView 提供的接口，向 JavaScript 的 Context（window）
中注入对象或者方法，让 JavaScript 调用时，直接执行相应的 Native 代码逻辑，达到 JavaScript 调用 Native 的目的。

原生调用JS
- 通过WebView提供的接口 执行拼接 JavaScript 字符串
- 使用loadurl并不能得到执行后的结果
