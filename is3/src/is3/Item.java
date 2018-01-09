package is3;

public class Item {
	private String serNumber;
	private Product product;
	
	public Item (String serNumber) {
		this.setSerNumber(serNumber);
	}
	
	public void setSerNumber (String serNumber) {
		this.serNumber = serNumber;
	}
	public String getSerNumber () {
		return this.serNumber;
	}
	public void setProdukt (Product product) {
		this.product = product;
	}
	public Product getProduct () {
		return this.product;
	}
}
