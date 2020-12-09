package g.io.text;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileARM {

	public static void main(String[] args) {

		// 1. define a file object - source
		File file = new File("files/letter.txt");

		// 2. define a source object - IO Object
		try (FileReader in = new FileReader(file);) {
			// 3. read
			int c = in.read(); // read first char
			while (c != -1) {
				System.out.print((char) c);
				c = in.read(); // read next char
			}
			// 4. close the stream
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
