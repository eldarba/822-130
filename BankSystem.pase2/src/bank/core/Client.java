package bank.core;

public class Client {

	private int id;
	private String name;
	private float balance;
	private Account[] accounts;
	private float commissionRate;
	private float interestRate;
	private Logger logger;

	public Client(int id, String name, float balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.accounts = new Account[5];
		logger = new Logger(null);
	}

	public void addAcount(Account account) {
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = account;
				// log the operation
				Log log = new Log(System.currentTimeMillis(), this.id, "addAcount", account.getBalance());
				logger.log(log);
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
	public void removeAcount(int acountId) {
		for (int i = 0; i < accounts.length; i++) {
			Account account = accounts[i];
			if (account != null && account.getId() == acountId) {
				this.balance += account.getBalance(); // transfers the money to the clients balance
				accounts[i] = null; // remove the account
				// log the operation
				Log log = new Log(System.currentTimeMillis(), this.id, "removeAcount", account.getBalance());
				logger.log(log);
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
		float commission = amount * this.commissionRate; // calculate the commission
		String description = "deposit";
		if (deposit) {
			this.balance += amount;
		} else {
			this.balance -= amount;
			description = "withdraw";
		}
		this.balance -= commission;
		// log the operation
		Log log = new Log(System.currentTimeMillis(), this.id, description, amount);
		logger.log(log);
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
				logger.log(log);
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

}
