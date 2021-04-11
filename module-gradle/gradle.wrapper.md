
#### Gradle Wrapper
在我们的开发团队中，来了一位新同学都需要在计算机中安装Gradle的嘛？
是的，很需要，不过新同学安装的版本和运行环境就不一样了。
Gradle Wrapper就为了解决上述的痛点问题而存在的。

###### Gradle Wrapper
它是一个脚本，当我们的计算机中没有安装Gradle的时候，它可以指定Gradle的版本去下载Gradle并且同时去运行Gradle的构建
同时去运行项目。
好处：不必手动安装Gradle、标准化项目、确立了项目的统一行和提高项目的开发效率。

当我们使用AS创建Project时就会带有Gradle Wrapper的。

###### 创建Gradle Wrapper
首先我们需要在计算机中配置好Gradle环境。
Gradle内置了Wrapper的Task，我们执行Wrapper Task就能在当前目录下看到生成的Gradle Wrapper目录文件了。

使用命令创建Gradle Wrapper目录文件

```groovy

gradle wrapper task

```
创建后的目录结构 使用 tree . 查看

```groovy
.
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
└── gradlew.bat

```
- gradlew.bat
Windows平台下用于执行Gradle命令的脚本
- gradlew
Linux平台下用于执行Gradle命令的脚本
- gradle-wrapper.jar
内部存在运行Gradle脚本的代码
- gradle-wrapper.properties
内部指定了Gradle脚本的版本号，用于管理使用那个版本的Gradle来构建项目

###### gradle-wrapper.properties文件中的参数
```groovy
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists
distributionUrl=https\://services.gradle.org/distributions/gradle-6.1.1-all.zip
```

- distributionBase

Gradle解包后存储的主目录

- distributionPath

Gradle解包后存储的子目录，distributionBase+distributionPath就是Gradle解包后的存储位置

- distributionUrl
指定Gradle远程下载的地址

- zipStoreBase
Gradle压缩包存储的主目录

- zipStorePath
压缩包存储的子目录，zipStoreBase+zipStorePath就是压缩包存储的全路径了。

###### 使用Gradle Wrapper升级下载gradle

- 创建gradlew wrapper的运行环境

gradle wrapper task

- 在当前目录上使用命令下载
gradlew wrapper --gradle-version 7.0
使用 gradlew wrapper现在 7.0版本的gradle脚本






