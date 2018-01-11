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
	
	public Order findorder (String orderId, String cNumber) {
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
		Product newProduct = new Product(name, price, category);
		this.products.addProduct(newProduct);
	}

	public void addProductOrderRow(String name, String number, String orderId, String cNumber) {
		Product p = products.findProduct(name);
		Customer c = customers.findCustomer(cNumber);
		Order o = c.findOrder(orderId);
		OrderRow row = o.findOrderRow(number);
		p.addOrdRowP(row);
		row.setProduct(p);
	}
	
	public void printStuff (String cNumber, String orderId, String number, String productName) {
		Customer c = customers.findCustomer(cNumber);
		Order o = c.findOrder(orderId);
		Product p = products.findProduct(productName);
		if (c != null) {
			for (OrderRow or: o.getOrdRowList().values()) {
				System.out.println(or.getAmount());
		}	
		
	}
	}
//	reg.getOwnerCarBrand("Owner", "DSA332")
//    for (owner i : reg.getOwners().values()) {
//           System.out.println(owner.getName());
//           for (car bil: owner) {
//                    System.out.println(bil.getRegNbr()+ " " + bil.getBrand());
//                    
//                    public String getOwnerCarBrand (String ownerNbr, String regNbr){
//                        owner o = this.find (ownerNbr);
//                        if (o != null){
//                                car bil = o.find (regNbr);
//                                if (bil != null) {
//                                        return bil.getBrand
//                                }
//                public Owner find(String nr) {
//                      return this.owners.get(nr);
   public String getOrderProductPrice (String OrderId, String pName, String cNumber) {
	   Order o = this.findorder(OrderId, cNumber);
	   if (o != null) {
		   for (OrderRow or: o.getOrdRowList().values()) {
			   System.out.println(or.getProduct().getPrice());
		   }
	   }
	   return null;
   }
 
   
//	public void printSum (String orderId, String cNumber) {
//		Order o = this.findorder(orderId, cNumber);
//		if (o != null) {
//			for (OrderRow or: o.getOrdRowList().values()) {
//				System.out.println(or.get)
//			}
//		}	
//	}	
	
//	public HashMap<String, Item> printSumStuff (String orderId, String cNumber, String productname) {
//		Order o = this.findorder(orderId, cNumber);
//		Product p = products.findProduct(productname);
//		if (o != null) {
//			return o.getOrderValue();
//			
//		}
//		o.getOrderValue();
//		p.getPrice();
//	}
//	 public LinkedList<Account> showAccounts(String pNbr) {
//	        Person newPerson;
//	        newPerson = persons.findPerson(pNbr);
//	        if (newPerson != null) {
//	            return newPerson.getAccounts();
//	        }
//	        return null;
//	    }
	public void printOrders (String cNumber){
	      Customer c = this.findCustomer(cNumber);
	       if (c != null) {
	                for (Order o: c.getOrderList().values()){
	                       System.out.print (o.getOrderId() + " " + o.getDelDate());
	                }
	       }
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
