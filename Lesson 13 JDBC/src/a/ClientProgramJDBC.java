package a;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class ClientProgramJDBC {

	public static void main(String[] args) {

		// how to load drivers if needed
		try {
			// loading classes is done usually using forName method
			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("org.apache.derby.client.ClientAutoloadedDriver");
			System.out.println("drivers loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Enumeration<Driver> enumerator = DriverManager.getDrivers();
		System.out.println(enumerator.getClass());

		while (enumerator.hasMoreElements()) {
			System.out.println(enumerator.nextElement());
		}

	}

}
