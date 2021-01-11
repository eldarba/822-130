package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306?serverTimezone=Israel";
		String user = "eldar1";
		String password = "pass1";

		try (Connection con = DriverManager.getConnection(url, user, password);) {

			Statement statement = con.createStatement();
			String sql;

			// creating a database
			sql = "create database x";
//			sql = "drop database x";
//			statement.executeUpdate(sql);
			System.out.println(sql);

			// create a a table
			sql = "create table x.product(";
			sql += "id int auto_increment, ";
			sql += "name varchar(10) not null, ";
			sql += "description varchar(10) not null, ";
			sql += "price float not null check(price <= 100), ";
			sql += "unique(name, description), ";
			sql += "primary key(id)";
			sql += ")";

//			sql = "drop table x.product";

			statement.executeUpdate(sql);
			System.out.println(sql);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
