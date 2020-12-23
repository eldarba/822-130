package a.io.homework;

import java.io.IOException;

public class Tar3A {

	public static void main(String[] args) {

		{
			try {
				System.out.println("enter a line");
				int b = System.in.read();
				while (b != 13) {
					System.out.write(b);
					b = System.in.read();
				}
				System.out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println();
			System.out.println("BYE");
		}

//		{ // do it with buffer and converter
//			try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
//				System.out.println("enter a line");
//				String line = in.readLine();
//				System.out.println(line);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

	}

}
