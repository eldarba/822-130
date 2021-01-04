package bank.test;

import java.util.Arrays;

import bank.core.Bank;
import bank.core.Client;

public class Test3Bank {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.addClient(new Client(101, "aaa", 15_000));
		bank.addClient(new Client(102, "bbb", 30_000));

//		System.out.println(Arrays.toString(bank.clients));
		System.out.println(Arrays.toString(bank.getAllClients()));

		System.out.println("bank balance: " + bank.getBalance());
		System.out.println("bank fortune: " + bank.getFortune());

		System.out.println("=================");
		bank.removeClient(102);
		System.out.println(Arrays.toString(bank.getAllClients()));

		System.out.println("bank balance: " + bank.getBalance());
		System.out.println("bank fortune: " + bank.getFortune());
	}

}
