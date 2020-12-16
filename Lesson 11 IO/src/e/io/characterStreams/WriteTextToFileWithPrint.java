package e.io.characterStreams;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import b.sets.Point;

public class WriteTextToFileWithPrint {

	public static void main(String[] args) {

		String str1 = "Hello text file";
		String str2 = "Today is " + new Date();
		String str3 = "Good Bye!";

		try (PrintWriter out = new PrintWriter(new FileWriter("files/file2"));) {

			out.println(str1);
			out.println(str2);
			out.println(str3);
			out.println(new Point(6, 10));
			out.println(350);
			out.println(10 < 5);

			System.out.println("data written");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
