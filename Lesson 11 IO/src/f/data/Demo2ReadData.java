package f.data;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo2ReadData {

	public static void main(String[] args) {

		try (DataInputStream in = new DataInputStream(new FileInputStream("files/numbers.data"));) {

			// the file format is: java int, long, short
			int a = in.readInt();
			long b = in.readLong();
			short c = in.readShort();

			System.out.println(a);
			System.out.println(b);
			System.out.println(c);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
