package com.py.examples.netty.chapter1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author panyi on 18-8-1.
 */
public class EchoClient {
    private String host;
    private int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public void start() throws InterruptedException {
        // EventLoopGroup可以理解为是一个线程池，这个线程池用来处理连接、接受数据、发送数据
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 创建Bootstrap对象用来引导启动客户端
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).remoteAddress(new InetSocketAddress(host,port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // 添加一个ChannelHandler，客户端成功连接服务器后就会被执行
                            ch.pipeline().addLast(new EchoClientHandler());
                        }
                    });
            // 调用Bootstrap.connect()来连接服务器
            ChannelFuture future = bootstrap.connect().sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) {
        try {
            new EchoClient("localhost",8888).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
