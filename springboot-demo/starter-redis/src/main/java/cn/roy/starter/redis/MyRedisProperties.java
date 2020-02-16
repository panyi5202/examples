package cn.roy.starter.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Roy
 */
@ConfigurationProperties(prefix="redis")
public class MyRedisProperties {
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
