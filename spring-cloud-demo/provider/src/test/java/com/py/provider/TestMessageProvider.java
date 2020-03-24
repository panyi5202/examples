package com.py.provider;

import com.py.provider.service.MessageProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Roy
 */
@SpringBootTest(classes = ProviderApp.class)
@RunWith(SpringRunner.class)
public class TestMessageProvider {
    @Resource
    private MessageProvider messageProvider;

    @Test
    public void testSend() {
        String product = "aaabbbccc";
        messageProvider.send(product);
    }

}
