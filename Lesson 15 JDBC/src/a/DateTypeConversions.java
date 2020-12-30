package a;

import java.sql.Date;
import java.time.LocalDate;

public class DateTypeConversions {

	public static void main(String[] args) {

		// create java.time.LocalDate
		LocalDate localDate = LocalDate.of(1987, 11, 25);
		System.out.println(localDate);

		// convert to java.sql.Date
		Date sqlDate = Date.valueOf(localDate);
		System.out.println(sqlDate);

		// convert back to java.time.LocalDate
		localDate = sqlDate.toLocalDate();
		System.out.println(localDate);

	}

}
