package is3;

import java.util.HashMap;

public class Produktregister {
	
	private HashMap<String, Product> productMap = new HashMap<String, Product>();
	
	public void setKundMap (HashMap<String, Product> productMap) {
		this.productMap = productMap;
	}
	public HashMap<String, Product> getProductMap () {
		return this.productMap;
	}
	public void addProduct (Product p) {
		this.productMap.put(p.getName(), p);
	}
	public void removeProduct (String productnr) {
		this.productMap.entrySet().removeIf(entry -> this.productMap.containsKey(productnr));
	}
	public Product findProduct (String productname) {
		for (Product p : this.productMap.values()) {
			if (p.getName().equals(productname)) {
				return p;
			}
		}
		return null;
	}
	
}
