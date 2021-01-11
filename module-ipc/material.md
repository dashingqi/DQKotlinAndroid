
#### material

###### IPC通信方式
- Bundle
- Messenegr
- 文件共享
- AIDL
- Socket
- ContentProvider

###### Binder
Binder是Android中的一个类，实现了IBinder接口，

Binder的优势

Binder本身是C/S架构，
Binder的性能更好，只需要一次数据拷贝
Binder更安全，可以得到对方的身份标识（UID/GID）

系统根据AIDL文件自动生成的的类

IXXXX extends IInterface

Stub extends Binder 实现了 我们的接口类 IXXXX

asInterface() 将服务端的Binder对象转换成客户端所需的AIDL接口类型对象

asBinder() 返回当前的Binder对象

onTransact() 运行在服务端的Binder线程池中，远程请求会通过系统底层封装后交由此方法来处理。

in：数据由客户端流向服务端
out：数据由服务端流向了客户端

inout：双向的,就是既能流向服务端也能流向客户端