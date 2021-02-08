package app.core.store;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class FoodStore implements Store {

	private Set<String> products = new HashSet<>();
	{
		products.add("bread");
		products.add("chese");
		products.add("milk");
		products.add("vegetables");
	}

	@Override
	public Set<String> getProducts() {
		return products;
	}

	@Override
	public String buy(String productName) throws StoreException {
		if (products.contains(productName)) {
			System.out.println("buy");
			return "FoodStore buy " + productName + " seccedded";
		} else {
			throw new StoreException("FoodStore: buy " + productName + " failed: not found");
		}
	}

	@Override
	public void returnProduct(String productName) {
		products.add(productName);
		System.out.println("returned: FoodStore: " + productName);
	}

}
