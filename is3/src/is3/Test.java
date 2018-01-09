package is3;

public class Test {

	public static void main(String[] args) {
		Customer k1 = new Customer();
		CustomerRegister kr = new CustomerRegister();
		
		k1.setcNumber("1");
		k1.setcAdress("Ettvagen");
		k1.setcName("Erik");
		Order anOrder = new Order("10", "21/3");
		k1.addOrder(anOrder);
		kr.addCustomer(k1);
		
		Customer k2 = new Customer();
		k2.setcNumber("2");
		k2.setcAdress("Tvavagen");
		k2.setcName("Anton");
		kr.addCustomer(k2);
		
		System.out.println(kr.findCustomer("1").getName() + kr.findCustomer("1").getcAdress() + kr.findCustomer("1").getcNumber());
		System.out.println(kr.findCustomer("2").getName() + kr.findCustomer("2").getcAdress() + kr.findCustomer("2").getcNumber());
		
		kr.changeCustomer("1", "Kung Erik", "Slottet");
		
		System.out.println(kr.findCustomer("1").getName() + kr.findCustomer("1").getcAdress() + kr.findCustomer("1").getcNumber());
		
		kr.removeCustomer("1");
		
		//System.out.println(kr.findCustomer("1").getName() + kr.findCustomer("1").getcAdress() + kr.findCustomer("1").getcNumber());
		
		Product p1 = new Product("Tåg", "Modelltåg", "500");
		Item item = new Item("12345");
		OrderRow row = new OrderRow("1","50");
		p1.addItem(item);
		p1.addOrdRowP(row);
		System.out.println(p1.getName() + p1.getCategory() + p1.getPrice());

		
		
		//System.out.println(kr.findCustomer("1").getName());
		


	}

}
