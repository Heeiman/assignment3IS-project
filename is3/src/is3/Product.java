package is3;

import java.util.HashMap;

public class Product {
	private String name;
	private String category;
	private String price;
	
	private HashMap<String, Item> itemList = new HashMap<String, Item>();
	private HashMap<String, OrderRow> ordRowP = new HashMap<String, OrderRow>();
	
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
    public void addItem (Item anItem) {
        this.itemList.put(anItem.getSerNumber(), anItem);
    }
    public HashMap<String, OrderRow> getOrderRowP () {
    	return this.ordRowP;
    }
    public void setOrdRowP (HashMap<String, OrderRow> ordRowP) {
    	this.ordRowP = ordRowP;
    }
    public void addOrdRowP (OrderRow row) {
    	this.ordRowP.put(row.getNumber(), row);
    }
	
}
