package e.io.characterStreams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class WriteTextToFile {

	public static void main(String[] args) {

		String str1 = "Hello text file";
		String str2 = "Today is " + new Date();
		String str3 = "Good Bye!";

		try (BufferedWriter out = new BufferedWriter(new FileWriter("files/file", false));) {

			out.write(str1);
			out.newLine();
			out.write(str2);
			out.newLine();
			out.write(str3);
			out.newLine();

			System.out.println("data written");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
