package app.core.store;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class ElectronicsStore implements Store {

	private Set<String> products = new HashSet<>();
	{
		products.add("tv");
		products.add("computer");
		products.add("dish washer");
	}

	@Override
	public Set<String> getProducts() {
		return products;
	}

	@Override
	public void buy(String productName) {
		if (products.contains(productName)) {
			System.out.println("ElectronicsStore buy " + productName + " seccedded");
		} else {
			System.out.println("ElectronicsStore buy " + productName + " failed: not found");
		}
	}

	@Override
	public void returnProduct(String productName) {
		products.add(productName);
		System.out.println("returned: ElectronicsStore: " + productName);
	}

}
