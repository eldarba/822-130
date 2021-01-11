package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/x?serverTimezone=Israel";
		String user = "eldar1";
		String password = "pass1";

		try (Connection con = DriverManager.getConnection(url, user, password);) {

			Statement statement = con.createStatement();
			String sql;

			sql = "insert into `product` values(0, 'IPad3', 'electro', 70)";

			int rows = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			System.out.println("rows affected: " + rows);

			// get the auto generated keys - product id
			ResultSet rsKeys = statement.getGeneratedKeys();
			rsKeys.next();
			int productId = rsKeys.getInt(1);
			System.out.println("produc id: " + productId);
			//

			System.out.println(sql);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
