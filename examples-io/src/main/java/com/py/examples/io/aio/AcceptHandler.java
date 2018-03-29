package com.py.examples.io.aio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

/**
 * 接收客户端的请求
 * @author panyi on 18-3-29.
 * @since V3.0.1
 */
public class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel,AioServer>{
    @Override
    public void completed(AsynchronousSocketChannel channel, AioServer attachment) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer,buffer, new ReadHandler(channel));

    }

    @Override
    public void failed(Throwable exc, AioServer attachment) {

    }
}
class ReadHandler implements CompletionHandler<Integer,ByteBuffer>{
    private AsynchronousSocketChannel channel;

    public ReadHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        try {
            buffer.flip(); // 转换成读取模式
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
            String msg = new String(bytes, "utf-8");
            System.out.println("    收到信息：" + msg);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }
}
