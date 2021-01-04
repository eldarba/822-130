package bank.test;

import bank.core.Bank;
import bank.core.Logger;
import bank.core.clients.GoldClient;
import bank.core.clients.PlatinumClient;
import bank.core.clients.RegularClient;
import bank.core.exceptions.BankSystemException;

public class Test5Bank {

	public static void main(String[] args) {

		try {
			Bank bank = Bank.getInstance();

			bank.addClient(new RegularClient(101, "aaa", 0));
			bank.addClient(new GoldClient(102, "bbb", 0));
			bank.addClient(new PlatinumClient(103, "ccc", 0));

			bank.getClient(101).deposit(100);
			bank.getClient(102).deposit(1000);
			bank.getClient(103).deposit(500);

			bank.printClientList();

			System.out.println(Logger.getLogs());

		} catch (BankSystemException e) {
			e.printStackTrace();
		}
	}

}
