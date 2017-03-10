package br.com.unitri.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import br.com.unitri.websocket.handlers.WebsocketHandler;

@EnableWebSocket
@SpringBootApplication
public class WebsocketHandlerApplication implements WebSocketConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketHandlerApplication.class, args);
	}

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		registry.addHandler(new WebsocketHandler(), "/echo");
		
	}
}					