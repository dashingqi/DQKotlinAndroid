#### 悬浮窗怎么实现
- Activity的显示都是通过WindowManger， getSystemService(WINDOW_SERVICE)
- 这个WindowManager extends ViewWindow
- ViewWindow中有addView()的方法，我们可以通过这个方法将悬浮窗添加到桌面上。


#### ANR的类型

KeyDispatchTimeOut 5秒
ServiceTimeOut 前台 20 后台 200
BroadcastTimeOut 前台10秒，后台 60秒
ContentProviderTimeout 10秒