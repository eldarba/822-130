package app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.sessions.Session;
import app.core.sessions.SessionContext;

@RestController
public class LoginController {

	@Autowired
	private SessionContext sessionContext;

	@PostMapping("/login/{userName}")
	public String login(@PathVariable String userName) {
		// create a new session
		Session session = sessionContext.createSession();
		// load session with attributes if needed (you can load any type of object)
		// this is how we save a client state
		session.setAttribute("userName", userName);
		// return the token to the caller (client)
		return session.token;
	}

}
