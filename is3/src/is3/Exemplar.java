package is3;

public class Exemplar {
	private String serNumber;
	
	private Produkt product;
	
	public void setSerNumber (String serNumber) {
		this.serNumber = serNumber;
	}
	public String getSerNumber () {
		return this.serNumber;
	}
	public void setProdukt (Produkt product) {
		this.product = product;
	}
	public Produkt getProduct () {
		return this.product;
	}
}
