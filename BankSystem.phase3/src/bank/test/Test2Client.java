package bank.test;

import bank.core.Account;
import bank.core.clients.Client;

public class Test2Client {

	public static void main(String[] args) {

		Client cl = new Client(111, "Aaa", 25_000);

		Account account = new Account(6589, 50_000);
		cl.addAcount(account);
	}

}
