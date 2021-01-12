#### 事件构成

###### EventBus

with()：IEvent

更具 tag 存储 Event对象

###### Event

var list = ArrayList<((action:Any)->Unit)>()

//发送事件
sendEvent()

//订阅事件
observer(lifecycleowner,(action:Any)->Unit)

//移除
remove(){
    list.remove()
    EventBus.map.remove(this)
}

lifeowner.lifecycle.aaddObserverd

