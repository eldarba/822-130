package app.core.store;

import java.util.Set;

public interface Store {

	Set<String> getProducts();

	void buy(String productName);

	void returnProduct(String productName);

}
