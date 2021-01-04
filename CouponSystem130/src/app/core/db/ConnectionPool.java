package app.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import app.core.exceptions.CouponSystemException;

public class ConnectionPool {

	private String url = "";
	private Set<Connection> connections = new HashSet<Connection>();
	public static final int MAX = 5;

	private static ConnectionPool instance;

	private ConnectionPool() throws CouponSystemException {
		try {
			for (int i = 0; i < MAX; i++) {
				Connection con;
				con = DriverManager.getConnection(url);
				connections.add(con);
			}
		} catch (SQLException e) {
			throw new CouponSystemException("ConnectionPool initialization failed", e);
		}
	}

	public static ConnectionPool getInstance() throws CouponSystemException {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	// add required methods

}
