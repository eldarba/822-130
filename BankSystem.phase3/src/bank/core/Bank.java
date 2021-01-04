
package bank.core;

import bank.core.clients.Client;

public class Bank {

	private float balance; // this is the bank private money
	private Client[] clients = new Client[100];
	Object accountUpdater; // not supported yet

	// SINGLETON DESIGN PATTERN ========================

	// the only instance is a class variable in Bank class
	private static Bank instance = new Bank();

	// private CTOR - no one out of this class can create a bank
	private Bank() {
	}

	// getter - so anyone out of this class can get a reference to the bank
	public static Bank getInstance() {
		return instance;
	}
	// =================================================

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

	/**
	 * add the client to the array and log the operation. You should seek the array
	 * and place the Client where the first null value is found.
	 * 
	 * @param client the client to be added
	 */
	public void addClient(Client client) {
		for (int i = 0; i < this.clients.length; i++) {
			if (clients[i] == null) {
				clients[i] = client;
				// log the operation
				Log log = new Log(System.currentTimeMillis(), client.getId(), "addClient", client.getFortune());
				Logger.log(log);
				//
				return;
			}
		}
		// if we are here the array was full and so we did not add the client
		System.out.println("client not added - array is  full");
	}

	/**
	 * remove the client with the same id from the array (by assigning a 'null'
	 * value to the array[position]). Log the operation
	 * 
	 * @param clientId
	 */
	public void removeClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
//			if (clients[i] != null && clients[i].getId() == clientId) {
			if (client.equals(clients[i])) {
				// log the operation
				Log log = new Log(System.currentTimeMillis(), client.getId(), "removeClient", clients[i].getFortune());
				Logger.log(log);
				//
				clients[i] = null;
				return;
			}
		}
		// if we are here the client was not found
		System.out.println("client not removed - not found");
	}

	/**
	 * @return an array of all clients - without null values
	 */
	public Client[] getAllClients() {
		Client[] arr = new Client[this.clients.length];
		int index = 0;
		for (Client client : this.clients) {
			if (client != null) {
				arr[index++] = client; // add the client and then increment the index variable
			}
		}

		// create array of the appropriate length and copy all clients to it
		Client[] theClients = new Client[index];
		System.arraycopy(arr, 0, theClients, 0, index);

		return theClients;
	}

	public Log[] getLogs() {
		return null;
	}

	public void startAcountUpdater() {

	}

	// methods added in phase 3

	public void addCommission(float amount) {
		this.balance += amount;
	}

	public void printClientList() {
		System.out.println("===== Bank Client List =====");
		for (Client client : clients) {
			if (client != null) {
				System.out.println(client);
			}
		}
		System.out.println("===== ================ =====");
	}

	/**
	 * return the client of the specified id or null if not found
	 * 
	 * @param clientId
	 * @return the client of the specified id
	 */
	public Client getClient(int clientId) {
		for (Client client : clients) {
			if (client != null && client.getId() == clientId) {
				return client;
			}
		}
		return null;
	}

}
