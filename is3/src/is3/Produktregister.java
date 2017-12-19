package is3;

import java.util.HashMap;

public class Produktregister {
	
	private HashMap<String, Produkt> produktMap = new HashMap<String, Produkt>();
	
	public void setKundMap (HashMap<String, Produkt> produktMap) {
		this.produktMap = produktMap;
	}
	
	public HashMap<String, Produkt> getProduktMap () {
		return this.produktMap;
	}
	
	public void addProdukt (Produkt p) {
		this.produktMap.put(p.getNamn(), p);
	}
	
	public void removeProdukt (String produktnr) {
		produktMap.entrySet().removeIf(entry -> !produktMap.containsKey(produktnr));
	}
	
}
