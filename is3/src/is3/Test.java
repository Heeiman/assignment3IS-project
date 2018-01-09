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
		
		System.out.println(kr.findCustomer("1").getName());
		


	}

}
