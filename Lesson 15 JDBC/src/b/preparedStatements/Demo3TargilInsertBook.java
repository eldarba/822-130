package b.preparedStatements;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Demo3TargilInsertBook {

	public static void main(String[] args) {

		// database details
		String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Israel&createDatabaseIfNotExist=true";
		String user = "eldar1";
		String password = "pass1";

		// get data from user
		int id = Integer.parseInt(JOptionPane.showInputDialog("enter book id"));
		String title = JOptionPane.showInputDialog("enter book title");
		String author = JOptionPane.showInputDialog("enter book author");
		double price = Double.parseDouble(JOptionPane.showInputDialog("enter book price"));
		LocalDate localDate = LocalDate.parse(JOptionPane.showInputDialog("enter book publication date [yyyy-mm-dd]"));
		Date date = Date.valueOf(localDate);

		// set the sql command
		String sql = "insert into book values(?, ?, ?, ?, ?)";

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id); // set the id
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setDouble(4, price);
			pstmt.setDate(5, date);

			pstmt.executeUpdate();
			System.out.println(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
