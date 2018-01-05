package is3;

import java.util.HashMap;

public class Order {
	private String orderId;
	private String delDate;
	private String dDate;
	public Kund customer;
	
	HashMap<String, Orderrad> ordRowList = new HashMap<String, Orderrad> ();
	
	public void setOrderId (String orderId){
		this.orderId = orderId;
	}
	public String getOrderId (){
		return this.orderId;
	}
	public void setLevDate (String delDate){
		this.delDate = delDate;
	}
	public void setDDate (String dDate){
		this.dDate = dDate;
	}
	public String getdelDate(){
		return delDate;
	}
	public String getdDate (){
		return this.dDate;
	}
	public void setCustomer (Kund customer){
		this.customer = customer;
	}
	public Kund getCustomer (){
		return this.customer;
	}
	public void setOrdRowList(HashMap<String, Orderrad> ordRowList){
		this.ordRowList = ordRowList;
	}
	public HashMap<String, Orderrad> getOrdRowList (){
		return this.ordRowList;
	}
	//HEJ
}
