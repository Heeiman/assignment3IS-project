package is3;

import java.util.HashMap;

public class Order {
	private String orderId;
	private String delDate;
	private String dDate;
	public Customer customer;
	
	HashMap<String, Orderrow> ordRowList = new HashMap<String, Orderrow> ();
	
	public Order(String orderId, String delDate, Customer customer) {
		this.setOrderId(orderId);
		this.setLevDate(delDate);
		this.setCustomer(customer);
	}
	public Order(String orderId) {
	}
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
	public void setCustomer (Customer customer){
		this.customer = customer;
	}
	public Customer getCustomer (){
		return this.customer;
	}
	public void setOrdRowList(HashMap<String, Orderrow> ordRowList){
		this.ordRowList = ordRowList;
	}
	public HashMap<String, Orderrow> getOrdRowList (){
		return this.ordRowList;
	}
	//HEJ
}
