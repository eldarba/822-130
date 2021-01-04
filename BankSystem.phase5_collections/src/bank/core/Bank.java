
package bank.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import bank.core.clients.Client;
import bank.core.exceptions.BankSystemException;

public class Bank {

	private float balance; // this is the bank private money
	private Set<Client> clients = new HashSet<Client>();
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
	 * add the client to the list and log the operation.
	 * 
	 * @param client the client to be added
	 * @throws BankSystemException when the specified client is already in the
	 *                             system
	 */
	public void addClient(Client client) throws BankSystemException {
		if (clients.add(client)) {
			// if we are here it means that the client was indeed added
			// log the operation
			Log log = new Log(System.currentTimeMillis(), client.getId(), "addClient", client.getFortune());
			Logger.log(log);
		} else {
			throw new BankSystemException("addClient failed - already exists");
		}
	}

	/**
	 * remove the client with the same id from the array (by assigning a 'null'
	 * value to the array[position]). Log the operation
	 * 
	 * @param clientId
	 * @throws BankSystemException
	 */
	public void removeClient(Client client) throws BankSystemException {
		// if we work with lists we can use indexOf method
		Client clientFromSystem = null;
		// convert the set to a list (just to show some list capabilities)
		List<Client> list = new ArrayList<Client>(clients);
		int index = list.indexOf(client);
		if (index != -1) {
			clientFromSystem = list.get(index);
		}

		if (clients.remove(client)) {
			// log the operation
			Log log = new Log(System.currentTimeMillis(), client.getId(), "removeClient",
					clientFromSystem.getFortune());
			Logger.log(log);
			//
		} else {
			throw new BankSystemException("removeClient failed - not found");
		}
	}

	/**
	 * @return an array of all clients - without null values
	 */
	public Client[] getAllClientsAsArray() {
		return clients.toArray(new Client[clients.size()]);
	}

	/**
	 * @return a collection of all clients
	 */
	public Collection<Client> getAllClientsAsCollection() {
		return clients;
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
