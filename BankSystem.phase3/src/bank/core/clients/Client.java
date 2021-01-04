package bank.core.clients;

import java.util.Objects;

import bank.core.Account;
import bank.core.Bank;
import bank.core.Log;
import bank.core.Logger;

/*an abstract class cannot be instantiated*/
public abstract class Client {

	private int id;
	private String name;
	private float balance;
	private Account[] accounts;
	// protected fields are accessible to sub classes
	protected float commissionRate;
	protected float interestRate;
	// logger field removed on phase 3

	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.accounts = new Account[5];
	}

	public void addAcount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = account;
				// log the operation
				Log log = new Log(System.currentTimeMillis(), this.id, "addAcount", account.getBalance());
				Logger.log(log);
				//
				break;
			}
		}
	}

	public Account getAcount(int index) {
//		if(index >= 0 && index < accounts.length) {
//			return accounts[index];
//		}else {
//			return null;
//		}

		// use ternary operator [?:] instead of if-else construct
		Account account = index >= 0 && index < accounts.length ? accounts[index] : null;
		return account;
	}

	/**
	 * remove the account with the same id from the array (by assigning a 'null'
	 * value to the array[position]) & transfers the money to the clients balance.
	 * Log the operation via creating Log object with appropriate data and sending
	 * it to the Logger.log(..) method.
	 */
	public void removeAcount(Account accountParam) {
		for (int i = 0; i < accounts.length; i++) {
			Account currAccount = accounts[i];
			if (accountParam.equals(currAccount)) {
				this.balance += currAccount.getBalance(); // transfers the money to the clients balance
				accounts[i] = null; // remove the account
				// log the operation
				Log log = new Log(System.currentTimeMillis(), this.id, "removeAcount", currAccount.getBalance());
				Logger.log(log);
				//
				return; // end the method here
			}
		}

		System.out.println("account not found");
	}

	/**
	 * implement to add or remove the amount from clients balance according to the
	 * commission (which is now zero). Use the commission data member in your
	 * calculation). log the operation
	 */
	public void deposit(float amount) {
		makeDepositWithdraw(amount, true);
	}

	public void withdraw(float amount) {
		makeDepositWithdraw(amount, false);
	}

	private void makeDepositWithdraw(float amount, boolean deposit) {

		String description = "deposit";
		if (deposit) {
			this.balance += amount;
		} else {
			this.balance -= amount;
			description = "withdraw";
		}
		// transfer commission from the client to the bank
		float commission = amount * this.commissionRate; // calculate the commission
		this.balance -= commission;
		Bank.getInstance().addCommission(commission);
		// log the operation
		Log log = new Log(System.currentTimeMillis(), this.id, description, amount);
		Logger.log(log);
		//
		// log the operation
		Log logCommission = new Log(System.currentTimeMillis(), this.id, "commission", commission);
		Logger.log(logCommission);
		//

	}

	/**
	 * run over the accounts, calculate the amount to add according to the client
	 * interest (meanwhile it is zero) and add it to each account balance. Use the
	 * interest data member in your calculation. Log this operation.
	 */

	public void autoUpdateAccounts() {
		for (Account account : accounts) {
			if (account != null) {
				float interest = account.getBalance() * this.interestRate;
				account.setBalance(account.getBalance() + interest);
				// log the operation
				Log log = new Log(System.currentTimeMillis(), this.id, "autoUpdateAccounts", interest);
				Logger.log(log);
				//
			}
		}
	}

	/**
	 * returns the sum of client balance + total account balance.
	 */
	public float getFortune() {
		float sum = this.balance;
		for (Account account : accounts) {
			if (account != null) {
				sum += account.getBalance();
			}
		}
		return sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Client)) {
			return false;
		}
		Client other = (Client) obj;
		return id == other.id;
	}

}
