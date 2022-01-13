package com.anoneutral.cheatchatbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.anoneutral.cheatchatbe.model.ChatMessage;
import com.anoneutral.cheatchatbe.model.MessageType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class WebsocketEventListener {
	
	@Autowired
	private SimpMessageSendingOperations sendingOperations;
	
	@EventListener
	public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
		log.info("New User connected...");
	}
	
	@EventListener
	public void handleWebSocketDisconnectListener(final SessionDisconnectEvent event) {
		log.info(event.getMessage().toString());
		final StompHeaderAccessor stompHeaderAccessor = StompHeaderAccessor.wrap(event.getMessage());
		final String username = (String) stompHeaderAccessor.getSessionAttributes().get("username");
		final ChatMessage chatMessage = ChatMessage.builder()
				.type(MessageType.DISCONNECT)
				.sender(username)
				.build();
		sendingOperations.convertAndSend("/topic/public", chatMessage);
	}
}
