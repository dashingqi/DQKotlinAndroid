#### 基本API

##### Camera1

##### Camera2的API以及作用
###### CameraManager（摄像头管理器）
- CameraManager是属于系统的一个服务，getSystemService(Context.CAMERA_SESSION);
- 用于，可以获取摄像头ID，检测和打开摄像头，通过getCameraCharacteristics()可以获取到CameraCharacteristics()类
###### CameraCharacteristics（摄像头属性）
- 摄像头的信息类，通过这个类可以拿到
- 我们通过CameraManager 传入摄像头ID，获取到指定摄像头的CameraCharacteristics
###### CameraDevice (代表摄像头)----> 相当于Camera
###### CameraCaptureSession
- Camera2打开摄像头后主要是和CameraCaptireSession打交道，
- 比如我们进行预览拍照，都是通过CameraCaptureSession进行的，预览的API是setRepeatingRequest()，拍照的API是capture()
###### CaptureRequest
- 当我们发起一次预览的时候需要使用CaptureRequest(),也就是发起了一次 captureRequest请求，
- 我们进行拍照的曝光啊，对焦模式啊，都需要设置CaptureRequest进行参数的设置
###### CaptureRequest.Builder
- 主要是构建了一个Map，调用了build方法后重新获取到一个CaptureRequest
###### ImageReader