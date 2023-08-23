package com.example.chattingtest.message;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebSocketMetricLogger implements ChannelInterceptor {


	@Override
	public Message<?> preSend(Message<?> message, MessageChannel channel) {
		var accessor = StompHeaderAccessor.wrap(message);
		var command = accessor.getCommand();

		log.info(String.valueOf(accessor));
		log.info(String.valueOf(command));
		log.info(accessor.getMessage());
		log.info(accessor.getFirstNativeHeader("content"));

		handleMessage(accessor);
		return message;
	}

	private void handleMessage(StompHeaderAccessor accessor) {
		switch (accessor.getCommand()) {
			case CONNECT:
				connectToChatRoom(accessor);
		}
	}

	private void connectToChatRoom(StompHeaderAccessor accessor) {
		// redis에 accessor.getProductId, accessor.getSellerId, accessor.getPurchaseId, accessor.getSenderId

	}
}