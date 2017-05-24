package com.my.lionrpc.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.my.lionrpc.protocol.ResponseMessage;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by littlechen on 17/5/21.
 */
public class LionClientChannelInboundHandler extends SimpleChannelInboundHandler<ResponseMessage>{
	
	private static final Logger LOG = LoggerFactory.getLogger(LionClientChannelInboundHandler.class);

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ResponseMessage responseMessage) throws Exception {
    	RequestRepositryRegistry.callBack(responseMessage);
    }
    
    
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
    	super.channelRegistered(ctx);
    	LOG.debug("channel been registered");
    }
    
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    	ctx.close();
    	LOG.error("channel happen excetion,closed.",cause);
    }
    
}