package is3;

import javax.swing.JFrame;

import java.util.HashMap;

public class Controller {
	CustomerRegister customers;
	ProductRegister products;
	JFrame Frame;

	public Controller(CustomerRegister customers, ProductRegister products, JFrame Frame) {
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

	public Order findorder(String orderId, String cNumber) {
		Customer c = customers.findCustomer(cNumber);
		Order newOrder = c.findOrder(orderId);
		if (newOrder != null) {
			return newOrder;
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

	public HashMap<String, Order> showCustomerOrder(String cNumber) {
		Customer newCustomer;
		newCustomer = this.findCustomer(cNumber);
		if (newCustomer != null) {
			return newCustomer.getOrderList();
		}
		return null;
	}

	public void removeOrder(String cNumber, String orderId) {
		Customer tmpCustomer = customers.findCustomer(cNumber);
		if (tmpCustomer != null) {
			tmpCustomer.removeOrder(orderId);
		}
	}

	public void addOrderOrderRow(String cNumber, String number, String amount, String orderId) {
		Customer tmpCustomer = customers.findCustomer(cNumber);
		Order o = tmpCustomer.findOrder(orderId);
		OrderRow oRow = new OrderRow(number, amount);
		o.addOrderRow(oRow);
		oRow.setOrder(o);
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
		Product newProduct = new Product(name, price, category);
		this.products.addProduct(newProduct);
	}

	public void addProductOrderRow(String name, String number, String orderId, String cNumber) {
		Product p = products.findProduct(name);
		if (p != null) {
			Customer c = customers.findCustomer(cNumber);
			if (c != null) {
				Order o = c.findOrder(orderId);
				if (o != null) {
					OrderRow row = o.findOrderRow(number);
					if (row != null) {
						p.addOrdRowP(row);
						row.setProduct(p);
					}
				}
			}
		}
	}

	public void removeProductOrderRow(String name, String number, String orderId, String cNumber) {
		Product p = products.findProduct(name);
		if (p != null) {
			Customer c = customers.findCustomer(cNumber);
			if (c != null) {
				Order o = c.findOrder(orderId);
				if (o != null) {
					OrderRow row = o.findOrderRow(number);
					if (row != null) {
						p.removeOrdRowP(number);
						row.removeProduct();
					}
				}
			}
		}
	}

	public String printStuff(String cNumber, String orderId, String number, String productName) {
		Customer c = customers.findCustomer(cNumber);
		Order o = c.findOrder(orderId);
		if (c != null) {
			for (OrderRow or : o.getOrdRowList().values()) {
				return or.getAmount();
			}

		}
		return null;
	}

	public double getOrderProductPrice(String OrderId, String cNumber) {
		Order o = this.findorder(OrderId, cNumber);
		if (o != null) {
			double amount = o.getOrdRowList().size();
			for (OrderRow or : o.getOrdRowList().values()) {
				String price = or.getProduct().getPrice();
				double sum = Double.parseDouble(price) * (amount);
				return sum;
			}
		}
		return 0;
	}

	public HashMap<String, OrderRow> showOrderRows(String orderId, String cNumber) {
		Order newOrder;
		newOrder = this.findorder(orderId, cNumber);
		if (newOrder != null) {
			return newOrder.getOrdRowList();
		}
		return null;
	}

	public String printOrders(String cNumber) {
		Customer c = this.findCustomer(cNumber);
		if (c != null) {
			for (Order o : c.getOrderList().values()) {
				return o.getOrderId() + " " + o.getDelDate();
			}
		}
		return null;
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