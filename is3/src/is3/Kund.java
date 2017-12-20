package is3;

import java.util.HashMap;

public class Kund {
	private String cNumber;
	private String cName;
	private String adress;
	
	private HashMap <String, Order> orderlista = new HashMap<String, Order>();
	
	public void setcNumber (String cNumber){
		this.cNumber = cNumber;
	}
<<<<<<< HEAD
	public String getKundnummer (){
		return this.kundnummer;
=======
	public String getcNumber (){
		return cNumber;
>>>>>>> branch 'master' of https://github.com/Heeiman/assignment3IS-project
	}
	public void setName (String cName){
		this.cName = cName;
	}
<<<<<<< HEAD
	public String getNamn (){
		return this.namn;
=======
	public String getName (){
		return cName;
>>>>>>> branch 'master' of https://github.com/Heeiman/assignment3IS-project
	}
	public void setAdress (String adress){
		this.adress = adress;
	}
	public String getAdress (){
		return this.adress;
	}
	public void setOrderlista (HashMap<String, Order> orderlista){
		this.orderlista = orderlista;
	}
	public HashMap<String,Order> getOrderlista (){
		return this.orderlista;
	}
	
	

}
