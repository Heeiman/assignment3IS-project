package is3;

public class Test {

	public static void main(String[] args) {
		Customer k1 = new Customer();
		CustomerRegister kr = new CustomerRegister();
		
		k1.setcNumber("1");
		k1.setcAdress("Ettvagen");
		k1.setcName("Erik");
		kr.addCustomer(k1);
		
		System.out.println(kr.findCustomer("1").getName() + " " + kr.findCustomer("1").getcAdress() + " " + kr.findCustomer("1").getcNumber());
		
	    Customer k2 = new Customer();
		k2.setcName("Anton");
		k2.setcAdress("Tvavagen");
		k2.setcNumber("2");
		kr.addCustomer(k2);

		kr.changeCustomer("1", "Kung Erik", "Slottet");
		
		System.out.println(kr.findCustomer("1").getName() + " " + kr.findCustomer("1").getcAdress() + " " + kr.findCustomer("1").getcNumber());
		System.out.println(kr.findCustomer("2").getName() + " " + kr.findCustomer("2").getcAdress() + " " + kr.findCustomer("2").getcNumber());
		
		kr.removeCustomer("1");
		
		System.out.println(kr.findCustomer("1"));
		
		ProductRegister pr = new ProductRegister();
		Product p1 = new Product("Tåg", "Modelltåg", "500");
		pr.addProduct(p1);
		Item item = new Item("12345");
		OrderRow row = new OrderRow("1","50");
		Order o = new Order("1111", "180110");
		k2.addOrder(o);
		o.addOrderRow(row);
		OrderRow test = o.findOrderRow("1");
		test.setAmount("25");
		p1.addItem(item);
		p1.addOrdRowP(test);
		System.out.println(p1.getName() + " " + p1.getCategory() + " " + p1.getPrice() + " " + item.getSerNumber() + " " + row.getNumber() + " " + row.getAmount());
		System.out.println("Hell yeah motherduckers");
		pr.printProducts();
		kr.printOrders("2");
		System.out.println();
		o.printOrderRows();
		System.out.println(o.getOrderId() + " " + o.getDelDate());
		System.out.println();
		k2.findOrder("1111");
		Order oTest = k2.findOrder("1111");
		System.out.println(oTest.getOrderId() + " " + oTest.getDelDate());
		

		
		
		//System.out.println(kr.findCustomer("1").getName());


		


	}

}
