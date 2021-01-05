## 基本API

#### Camera1

#### Camera2的API以及作用

###### CameraManager（摄像头管理器）
- CameraManager是属于系统的一个服务，getSystemService(Context.CAMERA_SESSION);
- 相机信息都封装到CameraCharacteristics中，通过getCameraCharacteristics()可以获取到CameraCharacteristics()类
- 根据指定的相机ID，连接到对应的摄像头上
- 提供将闪光灯设置成手电筒模式的快捷方式

###### CameraCharacteristics（摄像头属性）
- 摄像头的信息类，通过这个类可以拿到。
- 我们通过CameraManager 传入摄像头ID，获取到指定摄像头的CameraCharacteristics。
- 信息主要是：包括相机的朝向，判断闪光灯是否可用。

###### CameraDevice (代表摄像头)----> 相当于Camera 也就是当前你所连接的相机设备
- 根据指定的参数创建CameraCaptureSession。
- 根据指定的模版创建CaptureRequest。
- 关闭相机。
- 监听相机设备状态。

###### Surface
- 它是一块用于填充图像数据的内存空间
- 我们可以使用SurfaceView的Surface接受每一帧预览数据然后用于显示预览画面
- 也可以使用ImageReader的Surface接受JPEG或YUV数据。

###### CameraCaptureSession
- Camera2打开摄像头后主要是和CameraCaptireSession打交道，
- 一个CameraDevice一次只能开启一个CameraCaptureSession
- 比如我们进行预览拍照，都是通过CameraCaptureSession进行的，预览的API是setRepeatingRequest()，拍照的API是capture()

###### CaptureRequest
- 当我们发起一次预览的时候需要使用CaptureRequest(),也就是发起了一次 captureRequest请求，
- 我们进行拍照的曝光啊，对焦模式啊，都需要设置CaptureRequest进行参数的设置

###### CameraResult
- CaptureResult是每一次Capture操作的结果，里面包括了很多状态信息。
- 包括闪闪光灯状态，对焦状态，时间戳。

###### CaptureRequest.Builder
- 主要是构建了一个Map，调用了build方法后重新获取到一个CaptureRequest

#### Camera2支持的高级特性
###### 在开启相机之前检查相机信息
- 我们知道我们的相机信息都是封装在CameraCharacteristics类中，在Camera2中将相机信息与相机的实体进行剥离，
所以我们可以在不开启相机的情况下检查相机的信息。

###### 在不开启预览的情况下拍照
- 在Camera1中如果我们想拍照的话就必须先开启预览之后才能进行拍照。
- Camera2中不强制要求必须先开启预览才能拍照。

###### 一次拍摄多张不同格式和尺寸的图片
- Camera1中一次只能拍摄一张照片，更不用谈多张和不同格式了。
- Camera2不仅支持多张照片的拍摄 还支持不同格式的照片拍摄。

###### 连拍
- 使用Camera2自定义的相机可以支持连拍。

#### Camera2的功能支持情况
在一些中低端收集中使用的是HAL1，那么这样就会导致Camera2的一些高级功能没法使用，
不过Camera2中也提供了设备对于Camera2的支持情况的等级描述

- INFO_SUPPORTED_HARDWARE_LEVEL_LEGACY
- INFO_SUPPORTED_HARDWARE_LEVEL_LIMITED
- INFO_SUPPORTED_HARDWARE_LEVEL_FULL
- INFO_SUPPORTED_HARDWARE_LEVEL_3
- INFO_SUPPORTED_HARDWARE_LEVEL_EXTERNAL


- LEVEL_LEGACY: 向后兼容模式, 如果是此等级, 基本没有额外功能, HAL层大概率就是HAL1(我遇到过的都是)
- LEVEL_LIMITED: 有最基本的功能, 还支持一些额外的高级功能, 这些高级功能是LEVEL_FULL的子集
- LEVEL_FULL: 支持对每一帧数据进行控制,还支持高速率的图片拍摄
- LEVEL_3: 支持YUV后处理和Raw格式图片拍摄, 还支持额外的输出流配置
- LEVEL_EXTERNAL: API28中加入的, 应该是外接的摄像头, 功能和LIMITED类似

- 对应的支持等级排序是 LEGACY < LIMITED < FULL < LEVEL_3
- 关于设备支持的Camera2的高级功能的等级 可以通过CameraCharacteristics 
```
 val deviceLevel = cameraCharacteristics[CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL]
```



视频编码格式：h264
音频编码合适：AAC