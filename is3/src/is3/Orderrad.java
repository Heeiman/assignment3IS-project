package is3;

public class Orderrad {
	private String nummer;
	private String antal;
	
	private Order order;
	private Produkt produkt;
	
	public void setNumber (String number){
		this.nummer = number;
	}
	public String getNumber (){
		return nummer;
	}
	public void setAntal (String antal){
		this.antal = antal;
	}
	public String getAntal (){
		return antal;
	}
	public void setOrder (Order order){
		this.order = order;
	}
	public Order getOrder (){
		return this.order;
	}
	public void setProdukt (Produkt produkt){
		this.produkt = produkt;
	}
	public Produkt getProdukt (){
		return produkt;
	}
}
