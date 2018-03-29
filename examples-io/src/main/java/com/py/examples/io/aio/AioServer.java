package com.py.examples.io.aio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * 异步IO
 *
 * @author panyi on 18-3-29.
 * @since V3.0.1
 */
public class AioServer implements Runnable {
    public static void main(String[] args) throws IOException {
        AioServer aioServer = new AioServer();
        new Thread(aioServer).start();
    }

    @Override
    public void run() {
        try {
            AsynchronousServerSocketChannel channel = AsynchronousServerSocketChannel.open();
            channel.bind(new InetSocketAddress(8888));
            System.out.println("服务器已经启动");

            channel.accept(this, new AcceptHandler());

            CountDownLatch latch = new CountDownLatch(1);
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
