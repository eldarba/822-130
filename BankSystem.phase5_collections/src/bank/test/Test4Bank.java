package bank.test;

import bank.core.Bank;
import bank.core.clients.PlatinumClient;
import bank.core.clients.RegularClient;
import bank.core.exceptions.BankSystemException;

public class Test4Bank {

	public static void main(String[] args) {

		try {
			Bank bank = Bank.getInstance();

			bank.addClient(new RegularClient(101, "aaa", 0));
			bank.addClient(new PlatinumClient(102, "bbb", 0));

			bank.getClient(101).deposit(100);
			bank.getClient(102).deposit(100);

			bank.printClientList();

		} catch (BankSystemException e) {
			e.printStackTrace();
		}
	}

}
