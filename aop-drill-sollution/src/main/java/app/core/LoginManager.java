package app.core;

import org.springframework.stereotype.Component;

@Component
public class LoginManager {

	private boolean logged;

	public boolean login(String password) {
		System.out.println("login");
		this.logged = true;
		return true;
	}

	public void logout() {
		System.out.println("logout");
		this.logged = false;
	}

	public boolean isLogged() {
		return logged;
	}

}
