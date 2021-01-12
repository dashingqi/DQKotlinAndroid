
#### ContentProvider

####### ContentProvider的跨进程通信的原理

ContentProvider跨进程传输实际上传输的是ContentProvider.Transport对象，
Transport是一个binder本地对象(BBinder)，实现了IContentProvider接口，
IContentProvider包含了ContentProvider的所有操作，query、insert等。
调用端进程拿到的是ContentProviderProxy对象，通过跨进程调用对端的接口。

ContentProvider基于binder进行进程间通信，具有较高的安全性。由于其使用共享内存传输数据，也因此具备较高的传输效率。

