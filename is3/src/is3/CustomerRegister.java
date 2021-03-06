package is3;

import java.util.HashMap;

public class CustomerRegister {

	private HashMap<String, Customer> customerList = new HashMap<String, Customer>();

	public void setCustomerList(HashMap<String, Customer> customerList) {
		this.customerList = customerList;
	}

	public HashMap<String, Customer> getCustomerList() {
		return this.customerList;
	}

	public void addCustomer(Customer k) {
		this.customerList.put(k.getcNumber(), k);
	}

	public void removeCustomer(String cNumber) {
		customerList.entrySet().removeIf(entry -> customerList.containsKey(cNumber));
	}

	public Customer findCustomer(String cNumber) {
		for (Customer k : this.customerList.values()) {
			if (k.getcNumber().equals(cNumber)) {
				return k;
			}
		}
		return null;
	}

	public void setCustomerName(String cNumber, String newName, String newAdress) {
		Customer c = this.findCustomer(cNumber);
		if (c != null) {
			c.setcName(newName);
			c.setcAdress(newAdress);
		}
	}

	public void changeCustomer(String cNumber, String cName, String cAdress) {
		for (Customer k : this.customerList.values()) {
			if (k.getcNumber().equals(cNumber)) {
				k.setcName(cName);
				k.setcAdress(cAdress);
			}

		}
	}

	public void printOrders(String cNumber) {
		Customer c = this.findCustomer(cNumber);
		if (c != null) {
			for (Order o : c.getOrderList().values()) {
				System.out.print(o.getOrderId() + " " + o.getDelDate());
			}
		}
	}
}