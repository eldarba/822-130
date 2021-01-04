
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

	/**
	 * add the client to the array and log the operation. You should seek the array
	 * and place the Client where the first null value is found.
	 * 
	 * @param client the client to be added
	 */
	public void addClient(Client client) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] == null) {
				clients[i] = client;
				// log the operation
				Log log = new Log(System.currentTimeMillis(), client.getId(), "addClient", client.getFortune());
				logger.log(log);
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
	public void removeClient(int clientId) {
		for (int i = 0; i < clients.length; i++) {
			if (clients[i] != null && clients[i].getId() == clientId) {
				// log the operation
				Log log = new Log(System.currentTimeMillis(), clientId, "removeClient", clients[i].getFortune());
				logger.log(log);
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

}
