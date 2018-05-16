### 更新日志
* 18-4-23 初始创建：服务的消费者，使用ribbon作为负载均衡器，通过restTemplate访问远程服务；
* 18-4-23 使用feign作为负载均衡，feign默认整合了ribbon；
* 18-4-24 增加断路器hystrix；增加Hystrix Dashboard；


### TODO List
* Hystrix Dashboard 还有问题
* feign 使用httpClient