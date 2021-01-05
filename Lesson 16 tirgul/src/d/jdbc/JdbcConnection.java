package d.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {

		String url = "";
		try (Connection con = DriverManager.getConnection(url);) {

			Statement stmt = con.createStatement();
			stmt.execute("sql");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
