####  智能的操作
- 修改打包后输出的目录
- 提高打包速度

#### build.gradle脚本

在gradle中一个原子性的操作叫做task，可以将task理解为Gradle脚本中的最小可执行单元

###### 输出Hello World

```
task helloWorld{
    doLast{
        println "Hello World!"
    }
}
```
###### gradle常用的命令

- 执行一个task : ./gradlew taskName
- 获取脚本中所有的task : ./gradlew tasks --all

#### Gradle脚本构建的生命周期

gradle构建的时候都会执行3个不同的生命周期阶段

- 初始化

Gradle为每一个项目创建一个Project实例，在多项目构建中，Gradle会找出哪些项目依赖需要参与到构建中。

- 配置

执行所有项目的构建脚本，也就是执行每个项目中的build.gradle文件
此时我们配置的task任务也会在这个阶段执行

- 执行

gradle脚本按照顺序依次执行task


