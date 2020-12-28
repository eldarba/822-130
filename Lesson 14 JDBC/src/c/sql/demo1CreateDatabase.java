package c.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo1CreateDatabase {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1"; // use your own user
		String password = "pass1"; // use your own password

		try (Connection con = DriverManager.getConnection(url, user, password);) {
			System.out.println("connected to: " + url);

			// ===================work with the database======================
			System.out.println("we are just creating the db1 database");
			// ===============================================================

		} catch (SQLException e) {
			System.out.println("failed connected to: " + url);
			e.printStackTrace();
		}

		System.out.println("not connected to: " + url);

	}

}
