package d.io.byteStreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadBinaryFile {

	public static void main(String[] args) {

		File file = new File("files/java.jpg");
		File file2 = new File("files/javaCopy.jpg");

		// you should have 2 resources in ARM: in and out
		try (FileInputStream in = new FileInputStream(file); FileOutputStream out = new FileOutputStream(file2);) {

			System.out.println("available bytes: " + in.available());
			long ts1 = System.currentTimeMillis();
			int b = in.read(); // read first byte from source file
			while (b != -1) {
				out.write(b); // write current byte to destination file
				b = in.read(); // read next byte from source file (will return -1 at EOF)
			}
			long ts2 = System.currentTimeMillis();

			System.out.println("copy file is done in: " + (ts2 - ts1) + "ms");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
