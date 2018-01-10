package is3;

import javax.swing.JFrame;

import java.util.HashMap;

public class Controller {
	CustomerRegister customers;
	ProductRegister products;
	JFrame Frame;

	public Controller(CustomerRegister customers,ProductRegister products, JFrame Frame) {
		this.customers = customers;
		this.Frame = Frame;
		this.products = products;
	}

	public void addCustomer(String cNumber, String cName, String cAdress) {
		Customer newCustomer = new Customer(cNumber, cName, cAdress);
		this.customers.addCustomer(newCustomer);

	}

	public void addCustomerOrder(String orderID, String delDate, String cNumber) {
		Customer newCustomer = customers.findCustomer(cNumber);
		Order order = new Order(orderID, delDate);
		newCustomer.addOrder(order);
		order.setCustomer(newCustomer);
		customers.addCustomer(newCustomer);
	}

	public void removeCustomer(String cNumberRemove) {
		customers.removeCustomer(cNumberRemove);
	}

	public Customer findCustomer(String cNumber) {
		Customer newCustomer = customers.findCustomer(cNumber);
		if (newCustomer != null) {
			return newCustomer;
		}
		return null;
	}

	public void addOrder(String OrderId, String delDate, String cNumber) {
		Customer newCustomer = customers.findCustomer(cNumber);
		Order newOrder = new Order(OrderId, delDate);
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

	public String showCustomerOrders(String cNumber, String orderId) {
		Customer tmpCustomer = customers.findCustomer(cNumber);
		if (tmpCustomer != null) {
			Order order = tmpCustomer.findOrder(orderId);
			if (order != null) {
				return order.getOrderId();
			}
		}
		return null;
	}

	public void removeOrder(String cNumber, String orderId) {
		Customer tmpCustomer = customers.findCustomer(cNumber);
		if (tmpCustomer != null) {
			tmpCustomer.removeOrder(orderId);
		}
	}

	public void addOrderRow(String cNumber, String number, String amount, String orderId) {
		Customer tmpCustomer = customers.findCustomer(cNumber);
		if (tmpCustomer != null) {
			Order newOrder = tmpCustomer.findOrder(orderId);
			if (newOrder != null) {
				OrderRow newOrderRow = new OrderRow(number, amount);
				newOrder.addOrderRow(newOrderRow);
				newOrderRow.setOrder(newOrder);
			}
		}
	}

	public void removeOrderRow(String cNumber, String orderId, String number) {
		Customer tmpCustomer = customers.findCustomer(cNumber);
		if (tmpCustomer != null) {
			Order tmpOrder = tmpCustomer.findOrder(orderId);
			if (tmpOrder != null) {
				tmpOrder.removeOrderRow(number);
			}
		}
	}

	public HashMap<String, Order> showCustomers(String cNumber) {
		Customer newCustomer = customers.findCustomer(cNumber);
		if (newCustomer != null) {
			return newCustomer.getOrderList();
		}
		return null;
	}

	public void updateCustomerName(String cNumber, String newCName, String newAdress) {
		customers.setCustomerName(cNumber, newCName, newAdress);
	}

	public void updateProduct(String name, String price, String category) {
		products.changeProduct(name, price, category);
	}

	public void addProduct(String name, String price, String category) {
		Product newProduct = new Product(name, category, price);
		this.products.addProduct(newProduct);
	}
	
	public void addProductOrderRow (String name, String price, String category, String number, String amount) {
		Product newProduct = new Product(name, category, price);
		this.products.addProduct(newProduct);
		OrderRow row = new OrderRow(number, amount);
		newProduct.addOrdRowP(row);
		row.setProduct(newProduct);
	}
	
	public void removeProduct(String productName) {
		products.removeProduct(productName);
	}
	public Product findProduct(String pName) {
		Product newProduct = products.findProduct(pName);
		if (newProduct != null) {
			return newProduct;
		}
		return null;
	}

	public void addItemProduct(String serNumber, String name) {
		Product newProduct = products.findProduct(name);
		Item newItem = new Item(serNumber);
		newProduct.addItem(newItem);
		newItem.setProduct(newProduct);
	}

	public void removeItem(String serNumber, String productName) {
		Product newProduct = products.findProduct(productName);
		if (newProduct != null) {
			newProduct.removeItem(serNumber);
		}
		
	}

}
