package g.io.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileBuffer {

	public static void main(String[] args) {

		// 1. define a file object - source
		File file = new File("files/letter.txt");

		// 2. define a source object - IO Object
		try (BufferedReader in = new BufferedReader(new FileReader(file));) {
			// 3. read
			String line = in.readLine(); // read first line
			while (line != null) {
				System.out.println(line);
				line = in.readLine(); // read next line
			}
			// 4. close the stream
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
