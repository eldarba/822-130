package bank.core.clients;

public class GoldClient extends Client {

	public GoldClient(int id, String name, float balance) {
		super(id, name, balance);
		this.commissionRate = 0.02F; // 2%
		this.interestRate = 0.003F; // 0.3%
	}

}
