package priv.cx.carl.netty5.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDate;

/**
 * 客户端消息处理
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(LocalDate.now() + "客户端收到消息:" + msg);
    }

}
