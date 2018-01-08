package is3;

import javax.swing.JFrame;


import java.util.HashMap;
import java.util.LinkedList;

public class Controller {
	CustomerRegister customers;
	ProductRegister products;
	JFrame Frame;
	
	public Controller(CustomerRegister customers, JFrame Frame) {
		this.customers = customers;
		this.Frame = Frame;

	}
	public void addCustomer(String cNumber, String cName, String cAdress) {
        Customer newCustomer = new Customer (cNumber, cName, cAdress);
            this.customers.addCustomer(newCustomer);
	}
	public void addCustomerOrder (String orderID, String delDate, String cNumber) {
		Customer newCustomer = customers.findCustomer(cNumber);
		Order order = new Order (orderID, delDate);
		newCustomer.addOrder(order);
		order.setCustomer(newCustomer);
		customers.addCustomer(newCustomer);
	}
	public void removeCustomer(String cNumberRemove) {
	 customers.removeCustomer(cNumberRemove);
	}
	public Customer findCustomer (String cNumber) {
		Customer newCustomer = customers.findCustomer(cNumber);
		if (newCustomer != null) {
			return newCustomer;
		}
		return null;

	}

	public void addOrder(String OrderId, String delDate, String cNumber) {
		Customer newCustomer = customers.findCustomer(cNumber);
		Order newOrder = new Order(OrderId, cNumber);
		newCustomer.addOrder(newOrder);
		newOrder.setCustomer(newCustomer);
	}
	 public HashMap<String, Order> showOrders(String cNumber) {
	        Customer newCustomer;
	        newCustomer = customers.findCustomer(cNumber);
	        if (newCustomer != null) {
	            return newCustomer.getOrderList();
	        }
	        return null;
	    }
	//public void addOrderRow(String number, String amount) {
		//Order newOrder = orderList.
	//}
		
	//public HashMap<String, Customer> findKund (String cNumber) {
		//Customer newCustomer = customers.findKund(cNumber);
		//return newCustomer;
	//}
	public void updateCustomer(String cNumber, String newCName, String adress) {
	//customers.setCustomerName(cNumber, newCName);
	}
	
	
}
