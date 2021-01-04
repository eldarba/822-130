package bank.core;

import java.util.List;

public class Logger {

	// will be in use when working with database
	private String driverName;

	public Logger(String driverName) {
		super();
		this.driverName = driverName;
	}

	public static void log(Log log) {
		System.out.println(log);
	}

	public List<Log> getLogs() {
		return null;
	}

	public String getDriverName() {
		return driverName;
	}

}
