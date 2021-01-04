package bank.core.clients;

public class RegularClient extends Client {

	public RegularClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate = 0.03F; // 3%
		this.interestRate = 0.001F; // 0.1%
	}

//	@Override
//	public String toString() {
//		return "RegularClient [id=" + getId() + ", name=" + getName() + ", balance=" + getBalance() + "]";
//	}

}
