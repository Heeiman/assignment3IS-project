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
	public void addCustomerOrder (String orderID, String delDate, String dDate) {
		Kund newCustomer = customers.findKund(cNumber);
		Order order = new Order(orderID);
		newCustomer.addOrder(order);
		order.setCustomer(newCustomer);
		customers.addKund(newCustomer);
	}
	public void addOrderlist
	
	
}
