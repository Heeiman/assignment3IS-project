package is3;

import java.util.HashMap;

public class Product {
	private String name;
	private String category;
	private String price;
	
	private HashMap<String, Item> itemList = new HashMap<String, Item>();
	
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
	public void setItemList (HashMap<String, Item> itemList) {
		this.itemList = itemList;
	}
	public HashMap<String, Item> getItemList () {
		return this.itemList;
	}
    public void addProduct(Item anItem) {
        this.itemList.put(anItem.getSerNumber(), anItem);
    }
	
}
