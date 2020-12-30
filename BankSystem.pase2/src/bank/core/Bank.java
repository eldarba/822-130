
package bank.core;

public class Bank {

	private float balance; // this is the bank private money
	private Client[] clients = new Client[100];
	private Logger logger = new Logger(null);
	Object accountUpdater; // not supported yet

	/** returns the bank balance */
	public float getBalance() {
		return balance;
	}

	/** returns the sum of the clients fortune */
	public float getFortune() {
		float sum = 0;
		for (Client client : clients) {
			if (client != null) {
				sum += client.getFortune();
			}
		}
		return sum;
	}

}
