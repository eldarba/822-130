package b.preparedStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Demo2SelectWithMetaData {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1"; // use your own user
		String password = "pass1"; // use your own password

//		String sql = "select * from book";
		String sql = "select * from book where price >= ?";

		try (Connection con = DriverManager.getConnection(url, user, password);) {

			// ===================work with the database======================
			// create a fixed statement with place holders (as ?)
			PreparedStatement pstmt = con.prepareStatement(sql);
			// get minimum price as input from user
			double minPrice = Double.parseDouble(JOptionPane.showInputDialog("enter minimum price"));
			// set the value for the place holder parameter
			pstmt.setDouble(1, minPrice); // specify the place holder index and value
			ResultSet rs = pstmt.executeQuery();

			// get meta data on the result set
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();

			System.out.println(rs);

			for (int i = 1; i <= columnCount; i++) {
				System.out.print(meta.getColumnName(i) + "\t\t");
			}

			System.out.println("\n======================================");
			while (rs.next()) { // get current row
				for (int i = 1; i <= columnCount; i++) { // get current column
					System.out.print(rs.getObject(i) + "\t\t");
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
