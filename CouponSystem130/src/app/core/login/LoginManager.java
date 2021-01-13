package app.core.login;

import app.core.facade.Facade;

public class LoginManager {
	private static LoginManager instance = new LoginManager();

	private LoginManager() {
	}

	public static LoginManager getInstance() {
		return instance;
	}

	public Facade login() {
		return new Facade();

	}

}
