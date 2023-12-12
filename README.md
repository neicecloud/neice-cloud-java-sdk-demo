# OpenAPIClient-java

内测云开发者服务平台应用程序接口-Java Demo使用说明

## Step1.获取sdk文件

java sdk项目拉取路径：
https://github.com/neicecloud/neice-cloud-java-sdk

项目拉取到本地后，进行install到本地Maven仓库，需要时可以deploy到远程Maven仓库

## Step2.添加依赖

### 在你的项目的POM文件中添加如下依赖：

<dependency>
<groupId>cloud.neice</groupId>
<artifactId>neice-cloud-java-sdk</artifactId>
<version>1.0.0</version>
<scope>compile</scope>
</dependency>

## Step3.参考Demo.java获取接口数据

1. 填入对接渠道的地址host
2. 在对接渠道的注册账号中生成AccessKey，位置：账户管理-AccessKey管理
3. 通过AccessKeyId和AccessKeySecret登录渠道
4. 传参获取所需数据