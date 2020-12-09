package f.io.defaults;

import java.io.IOException;

public class Demo2 {

	public static void main(String[] args) {

		int b;
		try {
			b = System.in.read();
			System.out.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.close();
		System.out.flush();
	}

}
