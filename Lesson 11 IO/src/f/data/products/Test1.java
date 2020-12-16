package f.data.products;

import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {

		Product product = new Product("Bread", 15, 111222);
		try {
			product.save();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("END");

	}

}
