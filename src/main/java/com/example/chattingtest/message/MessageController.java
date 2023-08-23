package com.example.chattingtest.message;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {
	private final SimpMessageSendingOperations simplemessageSendingOperations;
	@MessageMapping("/hello")
	public void test(Message message){
		log.info(message.toString());
		simplemessageSendingOperations.convertAndSend("/sub/channel",message);
	}

	// /sub/productId/sellerId/purchaseId
}
