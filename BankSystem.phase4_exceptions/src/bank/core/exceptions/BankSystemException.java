package bank.core.exceptions;

/**
 * 
 * This class is the super type of all Bank System exceptions
 * 
 * @author Eldar
 *
 */
public class BankSystemException extends Exception {

	private static final long serialVersionUID = 1L;

	public BankSystemException() {
		super();
	}

	public BankSystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BankSystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public BankSystemException(String message) {
		super(message);
	}

	public BankSystemException(Throwable cause) {
		super(cause);
	}

}
