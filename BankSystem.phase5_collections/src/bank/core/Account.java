package bank.core;

import java.util.Objects;

public class Account {

	private int id;
	private float balance;

	public Account(int id, float balance) {
		super();
		this.id = id;
		setBalance(balance);
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

	// methods added on phase 3

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Account)) {
			return false;
		}
		Account other = (Account) obj;
		return id == other.id;
	}

}
