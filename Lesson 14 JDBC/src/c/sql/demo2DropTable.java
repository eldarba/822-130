package c.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo2DropTable {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1"; // use your own user
		String password = "pass1"; // use your own password

		try (Connection con = DriverManager.getConnection(url, user, password);) {
			System.out.println("connected to: " + url);

			// ===================work with the database======================
			// we need a statement object in order to execute SQL commands
			Statement stmt = con.createStatement();
			// create an SQL command as String
			String sql = "drop table book";
			// execute the SQL command
			int rowsEffected = stmt.executeUpdate(sql);
			System.out.println(sql);
			System.out.println("effected rows: " + rowsEffected);
			// ===============================================================

		} catch (SQLException e) {
			System.out.println("failed connected to: " + url);
			e.printStackTrace();
		}

		System.out.println("not connected to: " + url);

	}

}
