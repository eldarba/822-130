package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1SelectWithLoop {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1"; // use your own user
		String password = "pass1"; // use your own password

//		String sql = "select * from book";
//		String sql = "select * from book where price <= 30";
		String sql = "select * from book where price >= 80";

		try (Connection con = DriverManager.getConnection(url, user, password);) {

			// ===================work with the database======================
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			System.out.println(rs);

			while (rs.next()) {
				// get the data of current row
				Object id = rs.getObject(1);
				Object title = rs.getObject(2);
				Object author = rs.getObject(3);
				Object price = rs.getObject(4);
				Object date = rs.getObject(5);
				System.out.println("id: " + id + ", " + title + ", " + author + ", " + price + ", " + date);
			}

			// ===============================================================

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
		}

	}

}
