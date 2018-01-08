package is3;

public class Test {

	public static void main(String[] args) {
		Customer k = new Customer();
		CustomerRegister kr = new CustomerRegister();
		
		k.setcNumber("1");
		k.setAdress("Hejsvej");
		k.setName("Erik");
		
		kr.addCustomer(k);
		k.
		
		System.out.println(kr.findCustomer("1").getName());
		
		k.setName("Anton");
		
		System.out.println(kr.findCustomer("1").getName());


	}

}
