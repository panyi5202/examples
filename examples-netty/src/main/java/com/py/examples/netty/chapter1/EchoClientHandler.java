package com.py.examples.netty.chapter1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;

/**
 * @author panyi on 18-8-1.
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("已经连接上 EchoServer，开始发送数据...");
        ctx.writeAndFlush(Unpooled.copiedBuffer("来自 EchoClient 的消息", CharsetUtil.UTF_8).duplicate());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("收到 EchoServer 的消息：" + msg.toString(Charset.forName("UTF-8")));
    }
}
