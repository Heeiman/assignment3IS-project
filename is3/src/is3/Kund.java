package is3;

import java.util.HashMap;

public class Kund {
	private String kundnummer;
	private String namn;
	private String adress;
	
	private HashMap <String, Order> orderlista = new HashMap<String, Order>();
	
	public void setKundnummer (String kundnummer){
		this.kundnummer = kundnummer;
	}
	public String getKundnummer (){
		return kundnummer;
	}
	public void setNamn (String namn){
		this.namn = namn;
	}
	public String getNamn (){
		return namn;
	}
	public void setAdress (String adress){
		this.adress = adress;
	}
	public String getAdress (){
		return adress;
	}
	public void setOrderlista (HashMap<String, Order> orderlista){
		this.orderlista = orderlista;
	}
	public HashMap<String,Order> getOrderlista (){
		return orderlista;
	}
	
	

}
