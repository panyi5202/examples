package com.py.provider.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author Roy
 */
@EnableBinding(Source.class)
public class MessageProvider {
    @Resource
    private MessageChannel output;  // 消息的发送管道

    public void send(String product) {
        output.send(MessageBuilder.withPayload(product).build());
    }

}
