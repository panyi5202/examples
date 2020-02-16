package com.py.examples.netty.nianbao;

import com.py.examples.netty.chapter1.EchoServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author panyi on 18-7-31.
 */
public class EchoServer {
    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        // 处理事件，如接受新连接、接收数据、写数据等
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            // 引导绑定和启动服务器
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(group).channel(NioServerSocketChannel.class).localAddress(port)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            channel.pipeline().addLast(new LineBasedFrameDecoder(1024))
                                    .addLast(new StringDecoder())
                                    .addLast(new TimeServerHandler());
                        }
                    });
            // 绑定服务器
            ChannelFuture future = bootstrap.bind().sync();
            System.out.println("EchoServer 启动，端口：" + future.channel().localAddress());
            future.channel().closeFuture().sync();
            System.out.println("EchoServer 关闭");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }

    }
    public static void main(String[] args) {
        try {
            new EchoServer(8888).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
