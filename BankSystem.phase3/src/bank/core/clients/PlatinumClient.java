package bank.core.clients;

public class PlatinumClient extends Client {

	public PlatinumClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate = 0.01F; // 1%
		this.interestRate = 0.005F; // 0.5%
	}

}
