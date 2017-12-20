package is3;

import java.util.HashMap;

public class Order {
	private String orderId;
	private String leveransdatum;
	public Kund kund;
	
	HashMap<String, Orderrad> orderradlista = new HashMap<String, Orderrad> ();
	
	public void setOrderId (String orderId){
		this.orderId = orderId;
	}
	public String getOrderId (){
		return this.orderId;
	}
	public void setLeveransdatum (String leveransdatum){
		this.leveransdatum = leveransdatum;
	}
	public String getleveransdatum (){
		return this.leveransdatum;
	}
	public void setKund (Kund kund){
		this.kund = kund;
	}
	public Kund getKund (){
		return this.kund;
	}
	public void setOrderradlista(HashMap<String, Orderrad> orderradlista){
		this.orderradlista = orderradlista;
	}
	public HashMap<String, Orderrad> getOrderradlista (){
		return this.orderradlista;
	}
}
