package b.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect2MySql {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1";
		String password = "pass1";

		try (Connection con = DriverManager.getConnection(url, user, password);) {
			System.out.println("connected to: " + url);

			// ===================work with the database======================
			// we need a statement object in order to execute SQL commands
			Statement stmt = con.createStatement();
			// create an SQL command as String
			String sql = "insert into book values(111, 'java 5', 'eldar', '2018-10-25')";
			// execute the SQL command
			stmt.executeUpdate(sql);
			System.out.println(sql);
			// ===============================================================

		} catch (SQLException e) {
			System.out.println("failed connected to: " + url);
			e.printStackTrace();
		}

		System.out.println("not connected to: " + url);

	}

}
