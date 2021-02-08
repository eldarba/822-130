package app.core.store;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ClothingStore implements Store {

	private Set<String> products = new HashSet<>();
	{
		products.add("Shirt");
		products.add("Pants");
		products.add("Belt");
	}

	@Override
	public Set<String> getProducts() {
		return products;
	}

	@Override
	public String buy(String productName) throws StoreException {
		for (String p : products) {
			if (p.equalsIgnoreCase(productName)) {
				System.out.println("buy");
				return "ClothingStore: buy " + productName + " seccedded";
			}
		}
		System.out.println("ClothingStore: buy " + productName + " failed");
		throw new StoreException("ClothingStore: buy " + productName + " failed: not found");
	}

	@Override
	public void returnProduct(String productName) {
		products.add(productName);
		System.out.println("returned: ClothingStore: " + productName);
	}

}
