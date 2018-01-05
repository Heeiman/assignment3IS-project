package is3;

import java.util.HashMap;

public class CustomerRegister {

	private HashMap<String, Customer> kundMap = new HashMap<String, Customer>();
	
	public void setKundMap (HashMap<String, Customer> kundMap) {
		this.kundMap = kundMap;
	}
	public HashMap<String, Customer> getKundMap () {
		return this.kundMap;
	}
	public void addKund (Customer k) {
		this.kundMap.put(k.getcNumber(), k);
	}
	public void removeKund (String cNumber) {
		kundMap.entrySet().removeIf(entry -> kundMap.containsKey(cNumber));	
	}
	public Customer findKund (String cNumber) {
		for (Customer k : this.kundMap.values()) {
			if (k.getcNumber().equals(cNumber)) {
				return k;
			}
		}
		return null;
	}
	public void changeKund (String cNumber, Customer k) {
		kundMap.put(cNumber, kundMap.get(k));
	}
}
