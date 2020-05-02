## 知识点记录
#### ViewModel的作用
- 帮助Activity分担一部分工作，专门用于存放与界面相关的数据。
  - 这样做的好处就是，在一定程度上可以减少Activity中的逻辑。
> 手机发生屏幕旋转的时候，Activity会被重建，在Activity中的数据也会丢失。
- ViewModel在手机屏幕发生旋转的时候，不会被重新建立，这样还保留之前的数据。只有当Activity退出的时候才会跟着Activity一起销毁
#### ViewModel的使用
- ViewModel实例的创建
    ```
    val viewModel =  ViewModelProviders.of(this).get(MainViewModel::class.java);
    ```
#### 向ViewModel传递参数
- 使用ViewModelProvider.Factory可以搞定
