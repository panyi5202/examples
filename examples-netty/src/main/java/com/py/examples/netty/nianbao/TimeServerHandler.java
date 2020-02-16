package com.py.examples.netty.nianbao;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author panyi on 2019/9/9.
 */
public class TimeServerHandler extends SimpleChannelInboundHandler<String> {

    private int counter;

    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg)
            throws Exception {
//        byte[] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8").substring(0, req.length - System.getProperty("line.separator").length());
        System.out.println("The time server receive order : " + msg + " ; the counter is : " + ++counter);
        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(msg) ?
                new java.util.Date( System.currentTimeMillis()).toString() : "BAD ORDER";
        currentTime = currentTime + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}
