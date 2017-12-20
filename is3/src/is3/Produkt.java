package is3;

import java.util.HashMap;

public class Produkt {
	private String name;
	private String category;
	private String price;
	
	private HashMap<String, Exemplar> itemList = new HashMap<String, Exemplar>();
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategory() {
		return this.category;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPrice() {
		return this.price;
	}
	public void setItemList (HashMap<String, Exemplar> itemList) {
		this.itemList = itemList;
	}
	public HashMap<String, Exemplar> getItemList () {
		return this.itemList;
	}
	
	
}
