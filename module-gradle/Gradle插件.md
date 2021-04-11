
#### Gradle中的插件

Gradle中的插件主要分为两种，分别是脚本插件和对象插件

###### 脚本插件
- 定义一个脚本 other.gradle
```java
ext{
    versions='1.0'
    names='DashingQi'
}
```
- 在build.gradle脚本中引入该插件脚本

```groovy

apply from: 'other.gradle'

//定义个一个Action，使用插件中的变量

 task helloWorld {
        doLast {
            println "Hello World¡"
        }
    }
```

###### 对象插件
所谓对象插件就是实现了 org.gradle.api.plugins<Project>接口的插件

对象插件又分为内部插件和第三方插件

**内部插件**

**第三方插件**


