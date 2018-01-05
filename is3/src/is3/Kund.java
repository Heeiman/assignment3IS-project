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

	public String getcNumber (){
		return cNumber;
	}
	public void setName (String cName){
		this.cName = cName;
	}
	public String getName (){
		return cName;
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
    public void addOrder(Order anOrder) {
        this.orderlista.add(anOrder);
    }

	public Kund(String cNumber2, String cName2, String adress2) {
		this.setcNumber(cNumber2);
		this.setName(cName2);
		this.setAdress(adress2);
	}
	
	}
