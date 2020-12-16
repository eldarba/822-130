package f.data.products;

import java.io.IOException;

public class Test2 {

	public static void main(String[] args) {

		try {
			Product product = new Product();
			System.out.println(product);
			product.load();
			System.out.println(product);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
