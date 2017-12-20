package is3;

import java.util.HashMap;

public class Order {
	private String orderId;
<<<<<<< HEAD
	private String delDate;
=======
	private String dDate;
>>>>>>> refs/remotes/origin/m
	public Kund customer;
	
	HashMap<String, Orderrad> ordRowList = new HashMap<String, Orderrad> ();
	
	public void setOrderId (String orderId){
		this.orderId = orderId;
	}
	public String getOrderId (){
		return this.orderId;
	}
<<<<<<< HEAD
	public void setLevDate (String delDate){
		this.delDate = delDate;
=======
	public void setDDate (String dDate){
		this.dDate = dDate;
>>>>>>> refs/remotes/origin/m
	}
<<<<<<< HEAD
	public String getdelDate(){
		return delDate;
=======
	public String getdDate (){
		return this.dDate;
>>>>>>> refs/remotes/origin/m
	}
	public void setCustomer (Kund customer){
		this.customer = customer;
	}
	public Kund getCustomer (){
<<<<<<< HEAD
		return customer;
=======
		return this.customer;
>>>>>>> refs/remotes/origin/m
	}
	public void setOrdRowList(HashMap<String, Orderrad> ordRowList){
		this.ordRowList = ordRowList;
	}
	public HashMap<String, Orderrad> getOrdRowList (){
		return this.ordRowList;
	}
}
