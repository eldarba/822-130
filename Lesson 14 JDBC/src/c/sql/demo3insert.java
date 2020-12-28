package c.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demo3insert {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1"; // use your own user
		String password = "pass1"; // use your own password

		try (Connection con = DriverManager.getConnection(url, user, password);) {
			System.out.println("connected to: " + url);

			// ===================work with the database======================
			Statement stmt = con.createStatement();
			for (int i = 1; i <= 20; i++) {

				String sql = "insert into book values(";
				sql += i + ", ";
				sql += "'title" + i + "', ";
				sql += "'author" + i + "', ";
				int r = (int) (Math.random() * 100);
				sql += r + ", ";
				sql += "'2020-12-28'";
				sql += ")";
				System.out.println(sql);
				stmt.executeUpdate(sql);

			}

			// ===============================================================

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("not connected to: " + url);

	}

}
