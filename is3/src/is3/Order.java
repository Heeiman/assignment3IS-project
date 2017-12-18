package is3;

public class Order {
	private String orderId;
	private String leveransdatum;
	public Kund kund;
	
	Hashmap<String, String> orderradlista = new Hashmap<String, String> ();
	
	public void setOrderId (String orderId){
		this.orderId = orderId;
	}
	public String getOrderId (){
		return orderId;
	}
	public void setLeveransdatum (String leveransdatum){
		this.leveransdatum = leveransdatum;
	}
	public String getleveransdatum (){
		return leveransdatum;
	}
	public void setKund (Kund kund){
		this.kund = kund;
	}
	public Kund getKund (){
		return kund;
	}
}
