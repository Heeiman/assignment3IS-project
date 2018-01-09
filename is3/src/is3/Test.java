package is3;

public class Test {

	public static void main(String[] args) {
		Customer k = new Customer();
		CustomerRegister kr = new CustomerRegister();
		
		k.setcNumber("1");
		k.setcAdress("Hejsvej");
		k.setcName("Erik");
		kr.addCustomer(k);
		
		System.out.println(kr.findCustomer("1").getName());
		
		k.setcName("Anton");

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

		

		System.out.println(kr.findCustomer("1").getName());
		


	}

}
