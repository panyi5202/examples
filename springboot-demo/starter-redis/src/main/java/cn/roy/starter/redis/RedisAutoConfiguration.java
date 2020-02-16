package cn.roy.starter.redis;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * @author Roy
 */
@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(MyRedisProperties.class)
@ConditionalOnProperty(prefix = "redis", value = "enabled", matchIfMissing = true)
public class RedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(MyRedisProperties myRedisProperties) {
        return new Jedis(myRedisProperties.getHost(), myRedisProperties.getPort());
    }
}
