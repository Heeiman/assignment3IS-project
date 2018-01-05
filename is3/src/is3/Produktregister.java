package is3;

import java.util.HashMap;

public class Produktregister {
	
	private HashMap<String, Produkt> productMap = new HashMap<String, Produkt>();
	
	public void setKundMap (HashMap<String, Produkt> productMap) {
		this.productMap = productMap;
	}
	public HashMap<String, Produkt> getProductMap () {
		return this.productMap;
	}
	public void addProduct (Produkt p) {
		this.productMap.put(p.getName(), p);
	}
	public void removeProduct (String productnr) {
		this.productMap.entrySet().removeIf(entry -> this.productMap.containsKey(productnr));
	}
	public Produkt findProduct (String productname) {
		for (Produkt p : this.productMap.values()) {
			if (p.getName().equals(productname)) {
				return p;
			}
		}
		return null;
	}
	
}
