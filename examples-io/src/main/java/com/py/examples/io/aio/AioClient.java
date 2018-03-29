package com.py.examples.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @author panyi on 18-3-29.
 * @since V3.0.1
 */
public class AioClient {
    public static void main(String[] args) throws IOException {
        AioClient client = new AioClient();
        AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
        AsyncClientHandler handler = client.new AsyncClientHandler(channel);
        channel.connect(new InetSocketAddress("127.0.0.1",8888),handler,handler);
        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public class AsyncClientHandler implements CompletionHandler<Void,AsyncClientHandler>{
        AsynchronousSocketChannel channel;

        public AsyncClientHandler(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void completed(Void result, AsyncClientHandler attachment) {
            System.out.println("客户端与服务器连接成功，开始发送数据");
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put("2222222".getBytes());
            writeBuffer.flip();
            //异步写
            channel.write(writeBuffer, writeBuffer,new WriteHandler(channel));
        }

        @Override
        public void failed(Throwable exc, AsyncClientHandler attachment) {

        }
    }

    public class WriteHandler implements CompletionHandler<Integer,ByteBuffer>{
        AsynchronousSocketChannel channel;

        public WriteHandler(AsynchronousSocketChannel channel) {
            this.channel = channel;
        }

        @Override
        public void completed(Integer result, ByteBuffer buff) {
            System.out.println("写入完成");
            if (buff.hasRemaining()){
                channel.write(buff);
                System.out.println("数据发送成功");
            }
        }

        @Override
        public void failed(Throwable exc, ByteBuffer attachment) {

        }
    }
}
