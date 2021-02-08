package app.core.store;

import java.util.Set;

public interface Store {

	Set<String> getProducts();

	String buy(String productName) throws StoreException;

	void returnProduct(String productName);

}
