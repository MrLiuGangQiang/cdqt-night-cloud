## 项目说明
#### 该项目是一个典型的由Spring Cloud管理的微服务项目，主要包括如下模块
* 项目结构说明

```
┌cdqt-night-cloud───────────────────────────────────────顶层项目
├──cdqt-night-core──────────────────────────────────────基础核心模块
├──cdqt-night-tools─────────────────────────────────────通用工具模块
├──cdqt-night-redis─────────────────────────────────────Redis二次封装(增加自动延期功能)
├──cdqt-night-reverse───────────────────────────────────Mybatis逆向工程
├──cdqt-night-eureka────────────────────────────────────服务注册中心(端口：8761 账号：admin 密码：123456)
├──cdqt-night-admin─────────────────────────────────────服务监控中心(端口：8088 账号：admin 密码：123456)
├──cdqt-night-gateway───────────────────────────────────服务网关(Gateway)(端口：8080)
├──cdqt-service-module──────────────────────────────────微服务模块顶层项目
├────cdqt-module-mongo──────────────────────────────────基于MongoDB的文件服务器(端口：8000)
├────cdqt-module-security───────────────────────────────基础权限数据模块(端口：8010)
└────cdqt-module-userinfo───────────────────────────────用户信息模块(端口：8020)
```

* 项目介绍

1. 基于[Spring Cloud Hoxton.SR3](https://cloud.spring.io/spring-cloud-static/Hoxton.SR3/reference/html/spring-cloud.html) 和 [Spring Boot 2.2.5](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/html/)的最新版本。
