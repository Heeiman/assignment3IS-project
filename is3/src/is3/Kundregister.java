package is3;

import java.util.HashMap;

public class Kundregister {
	
	
	private HashMap<String, Kund> kundMap = new HashMap<String, Kund>();
	
	public void setKundlista (HashMap<String, Kund> kundMap) {
		this.kundMap = kundMap;
	}
	
	public HashMap<String, Kund> getKundlista () {
		return this.kundMap;
	}
	
	public void addKund (Kund k) {
		this.kundMap.put(k.getKundnummer(), k);
	}
	
	public void removeKund (String kundnummer) {
		kundMap.entrySet().removeIf(entry -> !kundMap.containsKey(kundnummer));
		
	}
	
	public HashMap<String, Kund> findKund (String kundnummer) {
		kundMap.get(kundnummer);
	
	}

}
