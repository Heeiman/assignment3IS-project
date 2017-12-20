package is3;

public class Orderrad {
	private String number;
	private String amount;
	
	private Order order;
	private Produkt product;
	
	public void setNumber (String number){
		this.number = number;
	}
	public String getNumber (){
		return this.number;
	}
	public void setAmount (String amount){
		this.amount = amount;
	}
	public String getAmount (){
		return this.amount;
	}
	public void setOrder (Order order){
		this.order = order;
	}
	public Order getOrder (){
		return this.order;
	}
	public void setProduct (Produkt product){
		this.product = product;
	}
	public Produkt getProduct (){
		return this.product;
	}
}
