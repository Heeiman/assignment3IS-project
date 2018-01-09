package is3;

import java.util.HashMap;

public class Customer {
	private String cNumber;
	private String cName;
	private String adress;
	private HashMap <String, Order> orderList = new HashMap<String, Order>();
	
	public Customer() {
	}	
	public void setcNumber (String cNumber){
		this.cNumber = cNumber;
	}
	public String getcNumber (){
		return cNumber;
	}
	public void setcName (String cName){
		this.cName = cName;
	}
	public String getName (){
		return cName;
	}
	public void setcAdress (String adress){
		this.adress = adress;
	}
	public String getcAdress (){
		return this.adress;
	}
	public void setOrderList (HashMap<String, Order> orderList){
		this.orderList = orderList;
	}
	public HashMap<String,Order> getOrderList (){
		return this.orderList;
	}
    public void addOrder(Order anOrder) {
        this.orderList.put(anOrder.getOrderId(), anOrder);
    }
	public Order findOrder (String orderId) {
		for (Order anOrder : this.orderList.values()) {
			if (anOrder.getOrderId().equals(orderId)) {
				return anOrder;
			}
		}
		return null;
	}
	public void removeOrder(String orderId) {
		orderList.entrySet().removeIf(entry -> orderList.containsKey(orderId));
	}

	public Customer(String cNumber2, String cName2, String cAdress2) {
		this.setcNumber(cNumber2);
		this.setcName(cName2);
		this.setcAdress(cAdress2);
	}

}
	
