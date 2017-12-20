package is3;

import java.util.HashMap;

public class Order {
	private String orderId;
	private String delDate;
	public Kund customer;
	
	HashMap<String, Orderrad> orderradlista = new HashMap<String, Orderrad> ();
	
	public void setOrderId (String orderId){
		this.orderId = orderId;
	}
	public String getOrderId (){
		return orderId;
	}
	public void setLevDate (String delDate){
		this.delDate = delDate;
	}
	public String getdelDate(){
		return delDate;
	}
	public void setCustomer (Kund customer){
		this.customer = customer;
	}
	public Kund getCustomer (){
		return customer;
	}
	public void setOrderradlista(HashMap<String, Orderrad> orderradlista){
		this.orderradlista = orderradlista;
	}
	public HashMap<String, Orderrad> getOrderradlista (){
		return orderradlista;
	}
}
