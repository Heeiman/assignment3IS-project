package is3;

public class test {

	public static void main(String[] args) {
		Customer k = new Customer();
		CustomerRegister kr = new CustomerRegister();
		
		k.setKundnummer("1");
		k.setAdress("Hejsvej");
		k.setNamn("Erik");
		
		kr.addKund(k);
		
		System.out.println(kr.findKund("1").getNamn());
		
		k.setNamn("Anton");
		
		System.out.println(kr.findKund("1").getNamn());

	}

}
