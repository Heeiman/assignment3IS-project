package is3;

import javax.swing.JFrame;

import is3.Produktregister;
import is3.Kundregister;


public class Controller {
	Kundregister customers;
	Produktregister products;
	JFrame appFrame;
	
	public Controller(Kundregister customerReg, JFrame appFrame) {
		this.customers = customerReg;
		this.appFrame = appFrame;
	}
	public void addCustomer(String cNumber, String cName, String adress) {
        Kund newCustomer = new Kund (cNumber, cName, adress);
            this.customers.addKund(newCustomer);
	}
	public void addCustomerOrder (String orderId, String delDate, String dDate, Kund customer, String cNumber) {
		Kund newCustomer = customers.findKund(cNumber);
		Order order = new Order (orderId, delDate, dDate, customer);
		newCustomer.addOrder(order);
		order.setCustomer(newCustomer);
		customers.addKund(newCustomer);
	}
	public void removeCustomer(String cNumberRemove) {
	 customers.removeKund(cNumberRemove);
	}
	public void addOrder(String OrderId, String delDate, String dDate) {
		Kund newKund = customers.findKund(cNumber);
		Order newOrder = new Order(OrderId);
		newKund.addOrder(anOrder);
		newOrder.setCustomer(newKund);
	}
	public void addOrderrad(String number, String amount) {
		Order newOrder = 
		Order newOrder = ordRowList.findOrder(OrderID);
		
		
		
		
	}
		
}
