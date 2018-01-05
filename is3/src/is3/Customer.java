package is3;

import java.util.HashMap;

public class Customer {
	private String cNumber;
	private String cName;
	private String adress;
	
	public Customer() {
	}
	
	private HashMap <String, Order> orderList = new HashMap<String, Order>();
	
	public void setcNumber (String cNumber){
		this.cNumber = cNumber;
	}

	public String getcNumber (){
		return cNumber;
	}
	public void setName (String cName){
		this.cName = cName;
	}
	public String getName (){
		return cName;
	}
	public void setAdress (String adress){
		this.adress = adress;
	}
	public String getAdress (){
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

	public Customer(String cNumber2, String cName2, String adress2) {
		this.setcNumber(cNumber2);
		this.setName(cName2);
		this.setAdress(adress2);
	}

}
	
