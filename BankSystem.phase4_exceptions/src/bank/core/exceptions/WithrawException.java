package bank.core.exceptions;

public class WithrawException extends BankSystemException {

	private int clientId;
	private float currentClientBalance;
	private float withrawAmount;

	private static final long serialVersionUID = 1L;

	public WithrawException(String message, int clientId, float currentClientBalance, float withrawAmount) {
		super(message);
		this.clientId = clientId;
		this.currentClientBalance = currentClientBalance;
		this.withrawAmount = withrawAmount;
	}

	public WithrawException() {
	}

	public WithrawException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public WithrawException(String message, Throwable cause) {
		super(message, cause);
	}

	public WithrawException(String message) {
		super(message);
	}

	public WithrawException(Throwable cause) {
		super(cause);
	}

	// fields get methods

	public int getClientId() {
		return clientId;
	}

	public float getCurrentClientBalance() {
		return currentClientBalance;
	}

	public float getWithrawAmount() {
		return withrawAmount;
	}

}
