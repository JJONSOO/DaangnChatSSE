package com.example.chattingtest.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Message {
	private String content;
	private String senderId;
	private String receiverId;
	private String productId;
}
