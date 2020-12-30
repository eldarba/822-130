package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1PreparedStatement {

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

			// get meta data on the result set
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();

			System.out.println(rs);

			for (int i = 1; i <= columnCount; i++) {
				System.out.print(meta.getColumnName(i) + "\t");
			}

			System.out.println("\n======================================");
			while (rs.next()) { // get current row
				for (int i = 1; i <= columnCount; i++) { // get current column
					System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println();
			}

			// ===============================================================

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
		}

	}

}
