package com.py.examples.io.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author panyi on 18-3-29.
 * @since V3.0.1
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));

        ByteBuffer buffer = ByteBuffer.allocate(40);
        InputStream in = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String msg ;
        while ((msg = reader.readLine()) != null) {
            buffer.put(msg.getBytes());

            buffer.flip();
            while (buffer.hasRemaining()) {
                channel.write(buffer);
            }
            buffer.clear(); // 清空缓存
        }
    }
}
