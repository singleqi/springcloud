# springcloud
## 1.Eureka
**服务注册和发现**  
此子模块中为单节点，可配置成[集群](https://juejin.im/post/5c8619b0e51d4510a06d3fe5)  
同样有类似功能的有Consul，Consul是分布式系统的服务注册和发现，有以下的性质：  
分布一致性协议实现、
健康检查、
Key/Value存储、
多数据中心方案。  
但配置和SpringBoot相差比较大，在这里不做演示。  
测试url:http://localhost:8761

## 2.service
此子模块service只是简单的*springboot*项目，*application.yaml*文件中有三个配置，用于实现单个服务的集群部署，
用于后续的LB试验。  
测试url：http://localhost:8081、http://localhost:8082、http://localhost:8083

## 3.Ribbon
此子模块是Ribbon的消费端负载均衡实现，负载均衡分为消息方和提供方的硬件LB如F5或者软件端的LB如nginx，
还有在进程内LB，将LB逻辑集成到消费方，消费方从服务注册中心获知有哪些地址可用，Ribbon就为后者。  
*并在此模块加上Hystrix和Dashboard的实现*  
测试url:http://localhost:9002

## 4.Feign
Feign是一个声明式的HTTP客户端，可以帮助我们更快捷、优雅地调用HTTP API。使用Feign，只需要创建一个接口并注解，
它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解，Feign支持可插拔的编码器和解码器，
Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。  
*并在此模块加上Hystrix和Dashboard的实现*  
测试url:http://localhost:9001

## 5.Hystrix
此子模块主要展示熔断器的Turbine实现(在3.Ribbon,4.Feign的运行的基础上)，Turbine是把多个熔断器作为一个[Cluster](https://juejin.im/post/5c8a348f6fb9a049c644b86b#heading-7)集中显示在Dashboard上。    
测试url:http://localhost:9000/hystrix

## 6.[Zuul](http://www.ymq.io/2017/12/10/spring-cloud-zuul/)
此子模块主要展示了服务网关的*1.路由转发和2.过滤器作用*，在服务网关中可以完成一系列的横切功能，例如权限校验、限流以及监控等，这些都可以通过过滤器完成（其实路由转发也是通过过滤器实现的）。  
测试url：http://localhost:9005/api-feign/?token=token-uuid&password=123456、http://localhost:9005/api-ribbon/?token=token-uuid&password=123456

## 7.Config
此子模块主要展示项目如何从远程git上获取和更新最新的配置文件。  
测试url: http://localhost:9010/service-dev.yaml (调用此配置的服务名称-profile.yaml)
refresh url: http://localhost:8081/actuator/refresh

## 8.Bus
配置在Config和Service上，主要将分布式系统的节点通过轻量级消息代理连接起来。用于在集群中传播状态更改（例如配置更改事件）或其他管理指令。  
唯一实现的方式是用 AMQP 消息代理作为通道，但是相同的基本功能集（还有一些取决于传输）在其他传输的路线图上。
测试url：http://localhost:9010/actuator/bus-refresh

环境Java,Maven,Docker,docker-compose  
打包：mvn clean package docker:build  
运行：docker-compose -f <./docker-compose.yaml> up  