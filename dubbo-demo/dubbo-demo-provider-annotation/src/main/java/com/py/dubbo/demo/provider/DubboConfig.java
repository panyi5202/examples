package com.py.dubbo.demo.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author panyi on 18-8-21.
 */
@Configuration
//@DubboComponentScan(basePackages = {"com.apache.dubbo.demo.provider.annotation"})
public class DubboConfig {
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("provider-test8");
        return applicationConfig;
    }
    /**
     * 默认基于dubbo协议提供服务
     *
     * @return
     */
    @Bean(name = "dubbo")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProtocolConfig protocolConfig() {
        // 服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setPort(20880);
        protocolConfig.setServer("netty4");
        return protocolConfig;
    }


    @Bean(name = "rest")
    // @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProtocolConfig protocolDubboConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("rest");
        protocolConfig.setServer("netty");
        protocolConfig.setPort(8888);
        return protocolConfig;
    }
}
