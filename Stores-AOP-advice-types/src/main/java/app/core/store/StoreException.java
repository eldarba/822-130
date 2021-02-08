package app.core.store;

public class StoreException extends Exception {

	private static final long serialVersionUID = 1L;

	public StoreException() {
		super();
	}

	public StoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StoreException(String message, Throwable cause) {
		super(message, cause);
	}

	public StoreException(String message) {
		super(message);
	}

	public StoreException(Throwable cause) {
		super(cause);
	}

}
