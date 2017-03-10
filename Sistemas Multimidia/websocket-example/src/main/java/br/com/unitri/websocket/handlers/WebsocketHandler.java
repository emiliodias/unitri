package br.com.unitri.websocket.handlers;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebsocketHandler extends TextWebSocketHandler {

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		System.out.println("Conexão encerrada...");
		
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	
		System.out.println("Conexão estabelecida...");
		
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		System.out.println(message.getPayload());
		
		session.sendMessage(new TextMessage("Echo reply " + message.getPayload()));
		
	}
	
	
}
