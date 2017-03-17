package br.com.unitri.websocket.sessions;

import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.unitri.websocket.handlers.WebsocketHandler;

@RestController
@RequestMapping(value = "sessions")
public class SessionsController {


	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Sessions listaVideos(@RequestParam(required = false) String nome) {

		Sessions sessions = new Sessions();
		
		sessions.setTotal(WebsocketHandler.sessions.size());
		
		Set<String> sessionsIds = WebsocketHandler.sessions.keySet();
		
		for(String id : sessionsIds) {
			
			Session s = new Session();
			s.setId(id);
			
			sessions.addSession(s);
			
		}
		
		
		return sessions;

	}

}
