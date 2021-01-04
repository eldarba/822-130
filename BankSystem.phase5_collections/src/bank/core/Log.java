package bank.core;

import java.util.Date;

public class Log {

	private long ts;
	private int clientId;
	private String description;
	private float amout;

	// CTOR 1 - user specify the time
	public Log(long ts, int clientId, String description, float amout) {
		super();
		this.ts = ts;
		this.clientId = clientId;
		this.description = description;
		this.amout = amout;
	}

	// CTOR 2 - no need to specify time
	public Log(int clientId, String description, float amout) {
		this(System.currentTimeMillis(), clientId, description, amout);
	}

//	public String getData() {
//		return "Log [ts=" + ts + ", clientId=" + clientId + ", description=" + description + ", amout=" + amout + "]";
//	}

	@Override
	public String toString() {
		Date date = new Date(ts);
		return "Log [date=" + date + ", clientId=" + clientId + ", description=" + description + ", amout=" + amout
				+ "]";
	}

}
