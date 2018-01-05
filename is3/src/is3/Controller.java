package is3;

import javax.swing.JFrame;
import java.util.HashMap;

public class Controller {
	CustomerRegister customers;
	ProductRegister products;
	JFrame appFrame;
	
	public Controller(CustomerRegister customerReg, JFrame appFrame) {
		this.customers = customerReg;
		this.appFrame = appFrame;
	}
	public void addCustomer(String cNumber, String cName, String adress) {
        Customer newCustomer = new Customer (cNumber, cName, adress);
            this.customers.addKund(newCustomer);
	}
	public void addCustomerOrder (String orderID, String delDate, Customer customer, String cNumber) {
		Customer newCustomer = customers.findKund(cNumber);
		Order order = new Order (orderID, delDate, customer);
		newCustomer.addOrder(order);
		order.setCustomer(newCustomer);
		customers.addKund(newCustomer);
	}
	public void removeCustomer(String cNumberRemove) {
	 customers.removeKund(cNumberRemove);
	}

	public void addOrder(String OrderId, String delDate, String dDate, String cNumber) {
		Customer newCustomer = customers.findKund(cNumber);
		Order newOrder = new Order(OrderId);
		newCustomer.addOrder(newOrder);
		newOrder.setCustomer(newCustomer);
	}
	public void addOrderrad(String number, String amount) {
	//	Order newOrder = 
		//Order newOrder = ordRowList.findOrder(OrderID);
	}
		
	//public HashMap<String, Customer> findKund (String cNumber) {
		//Customer newCustomer = customers.findKund(cNumber);
		//return newCustomer;
	//}
	public void updateCustomer(String cNumber, String newCName, String adress) {
	//customers.setCustomerName(cNumber, newCName);
	}

	
}
