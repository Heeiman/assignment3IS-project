package is3;

import java.util.HashMap;

public class CustomerRegister {

	private HashMap<String, Customer> customerList = new HashMap<String, Customer>();
	
	public void setCustomerList (HashMap<String, Customer> customerList) {
		this.customerList = customerList;
	}
	public HashMap<String, Customer> getCustomerList () {
		return this.customerList;
	}
	public void addCustomer (Customer k) {
		this.customerList.put(k.getcNumber(), k);
	}
	public void removeCustomer (String cNumber) {
		customerList.entrySet().removeIf(entry -> customerList.containsKey(cNumber));	
	}
	public Customer findCustomer (String cNumber) {
		for (Customer k : this.customerList.values()) {
			if (k.getcNumber().equals(cNumber)) {
				return k;
			}
		}
		return null;
	}
	public void changeCustomer (String cNumber, String cName, String cAdress) {
		for (Customer k : this.customerList.values()) {
			if (k.getcNumber().equals(cNumber)) {
				k.setName(cName);
				k.setAdress(cAdress);
			}

}
}
}