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
