package com.py.examples.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO最重要的三个概念：Selector、Channel、Buffer
 *
 * @author panyi on 18-3-28.
 * @since V3.0.1
 */
public class NioServer {
    public static void main(String[] args) {
        try (Selector selector = Selector.open()) {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.configureBlocking(false);
            ssc.socket().bind(new InetSocketAddress(8888));
            ssc.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器已经启动。。。");
            while (true) {
                int select = selector.select(1000);
                System.out.println("selector取到keys: "+ select);
                if (select > 0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = keys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        // 处理事件
                        if (key.isAcceptable()) {
                            System.out.println("  已经准备好连接");
                            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                            SocketChannel socketChannel = channel.accept();
                            socketChannel.configureBlocking(false);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                        if (key.isReadable()) {
                            System.out.println("  已经准备读取");
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(20);
                            int read = socketChannel.read(buffer);
                            if (read > 0) {
                                buffer.flip(); // 转换成读取模式
                                byte[] bytes = new byte[buffer.remaining()];
                                buffer.get(bytes);
                                String msg = new String(bytes, "utf-8");
                                System.out.println("    收到信息：" + msg);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
