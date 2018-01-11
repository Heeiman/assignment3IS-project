package is3;

import java.util.HashMap;

public class ProductRegister {

	private HashMap<String, Product> productMap = new HashMap<String, Product>();

	public void setProductMap(HashMap<String, Product> productMap) {
		this.productMap = productMap;
	}

	public HashMap<String, Product> getProductMap() {
		return this.productMap;
	}

	public void addProduct(Product p) {
		this.productMap.put(p.getName(), p);
	}

	public void removeProduct(String productName) {
		this.productMap.entrySet().removeIf(entry -> this.productMap.containsKey(productName));
	}

	public Product findProduct(String productname) {
		for (Product p : this.productMap.values()) {
			if (p.getName().equals(productname)) {
				return p;
			}
		}
		return null;
	}

	public void changeProduct(String productName, String category, String price) {
		Product p = this.findProduct(productName);
		if (p != null) {
			p.setCategory(category);
			p.setPrice(price);
		}
	}

	public void printProducts() {
		productMap
				.forEach((key, value) -> System.out.println(key + ":" + value.getCategory() + " " + value.getPrice()));
	}

	public void getPrice() {
		productMap.forEach((key, value) -> value.getPrice().toString());
	}

}
