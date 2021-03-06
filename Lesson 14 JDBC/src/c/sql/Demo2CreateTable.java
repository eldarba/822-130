package c.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2CreateTable {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1"; // use your own user
		String password = "pass1"; // use your own password

		String sql = "create table book";
		sql += "(";
		sql += "id int primary key, ";
		sql += "title varchar(25), ";
		sql += "author varchar(25), ";
		sql += "price float, ";
		sql += "publication date";
		sql += ")";

		try (Connection con = DriverManager.getConnection(url, user, password);) {
			System.out.println("connected to: " + url);

			// ===================work with the database======================

			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);

			System.out.println(sql);
			// ===============================================================

		} catch (SQLException e) {
			System.out.println("failed connected to: " + url);
			System.out.println(sql);
			e.printStackTrace();
		}

		System.out.println("not connected to: " + url);

	}

}
