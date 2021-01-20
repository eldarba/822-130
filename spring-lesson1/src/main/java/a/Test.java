package a;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {

		try (Connection con = DriverManager.getConnection("")) {

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
