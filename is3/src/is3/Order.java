package is3;

import java.util.HashMap;

public class Order {
	private String orderId;
	private String delDate;
	public Customer customer;
	
	HashMap<String, OrderRow> ordRowList = new HashMap<String, OrderRow> ();
	
	public Order(String orderId, String delDate, Customer customer) {
		this.setOrderId(orderId);
		this.setDelDate(delDate);
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
	public void setDelDate (String delDate){
		this.delDate = delDate;
	}
	public String getDelDate(){
		return delDate;
	}
	public void setCustomer (Customer customer){
		this.customer = customer;
	}
	public Customer getCustomer (){
		return this.customer;
	}
	public void setOrdRowList(HashMap<String, OrderRow> ordRowList){
		this.ordRowList = ordRowList;
	}
	public HashMap<String, OrderRow> getOrdRowList (){
		return this.ordRowList;
	}
    public void addOrderRow (OrderRow aRow) {
        this.ordRowList.put(aRow.getNumber(), aRow);
    }
}
