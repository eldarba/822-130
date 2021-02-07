package app.core.beans;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class ConnectionPool {

	String url = "";
	String user = "";
	String password = "";
	private Set<Connection> connections = new HashSet<Connection>();
	public static final int MAX = 5;

	public ConnectionPool() {
		System.out.println("connection pool up");
//		try {
//			for (int i = 0; i < MAX; i++) {
//				Connection con;
//				con = DriverManager.getConnection(url, user, password);
//				connections.add(con);
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException("ConnectionPool initialization failed", e);
//		}
	}

	// add required methods

	public synchronized Connection getConnection() {
		while (this.connections.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Iterator<Connection> it = this.connections.iterator();
		Connection con = it.next();
		it.remove();
		return con;
	}

	public synchronized void restoreConnection(Connection connection) {
		connections.add(connection);
		notify();
	}

	@PreDestroy
	/**
	 * close the connections
	 */
	public synchronized void cloaseAllConnections() {
		// signal that this connection pool is closing -- boolean field
		// wait for all connections to come back to pool
		// iterate the connections set and close each connection
		System.out.println("close all connections. pool is down");
	}

}
