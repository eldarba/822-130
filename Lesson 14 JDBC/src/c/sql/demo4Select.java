package c.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo4Select {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1"; // use your own user
		String password = "pass1"; // use your own password

		String sql = "select * from book";

		try (Connection con = DriverManager.getConnection(url, user, password);) {

			// ===================work with the database======================
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);

			rs.next(); // now we are in the first row
			int id = rs.getInt(1); // you can get column value by index in the result set
			String title = rs.getString("title"); // you can get column value by column name

			System.out.println(id);
			System.out.println(title);

			// ===============================================================

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
		}

	}

}
