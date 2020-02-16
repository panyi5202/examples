package com.roy.springboot.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

/**
 * @author Roy
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class RedisTest {
    @Resource
    private Jedis jedis;

    @Test
    public void testRedis(){
        jedis.set("user","roy");
        String user = jedis.get("user");
        System.out.println(user);
    }
}
