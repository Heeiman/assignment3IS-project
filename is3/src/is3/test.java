package is3;

public class test {

	public static void main(String[] args) {
		Kund k = new Kund();
		Kundregister kr = new Kundregister();
		
		k.setKundnummer("1");
		k.setAdress("Hejsvej");
		k.setNamn("Erik");
		
		kr.addKund(k);
		
		System.out.println(kr.findKund("1").getNamn());
		
		k.setNamn("Anton");
		
		System.out.println(kr.findKund("1").getNamn());

	}

}
