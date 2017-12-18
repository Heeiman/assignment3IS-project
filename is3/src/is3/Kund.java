package is3;

public class Kund {
	private String kundnummer;
	private String namn;
	private String adress;
	
	Hashmap<String, String> orderlista = new Hashmap<String, String>();
	
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
	

}
