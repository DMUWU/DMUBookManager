# DMUBookManager
实现一个图书馆管理系统
## 1.搭建框架
使用Maven来管理项目，并使用Spring Boot（SSM）作为我们项目的主体框架。
用Spring Boot生成一个模板，同时自动添加了一些模块，然后将其他的依赖添加到Pom.xml里，如Freemaker、MyBatis等。

## 2.目录及已有文件解释
* src（文件夹） 存放java代码
* templates（文件夹） 存放html文件
* application.properties（文件） Spring Boot的配置文件
* mybatis-config.xml（文件） MyBatis的配置文件
* BookManagerApplication.java（文件） Spring Boot的入口，运行会启动Spring Boot

## 各个package的介绍：
* biz 用来存放比较复杂的逻辑
* configuration 添加拦截器
* controllers 控制器都在这里，网页的入口，处理请求
* dao 跟数据库交互的包
* interceptor AOP的代码都在这
* model 各种数据模型，Bean
* service 对dao层的封装
* utils 简单工具
* enums 所有的枚举类

## 总结
目前基本与原版类似，但没有自定义异常，简单的web项目已完成，但是还有许多需要完善的地方
