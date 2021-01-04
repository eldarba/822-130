package bank.core;

public class Logger {

	// will be in use when working with database
	private String driverName;

	public Logger(String driverName) {
		super();
		this.driverName = driverName;
	}

	public static void log(Log log) {
		System.out.println(log.getData());
	}

	public Log[] getLogs() {
		return null;
	}

	public String getDriverName() {
		return driverName;
	}

}
