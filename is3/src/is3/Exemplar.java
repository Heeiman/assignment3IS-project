package is3;

public class Exemplar {
	private String serienummer;
	
	private Produkt produkt;
	
	public void setSerienummer (String serienummer) {
		this.serienummer = serienummer;
	}
	public String getSerienummer () {
		return serienummer;
	}
	public void setProdukt (Produkt produkt) {
		this.produkt = produkt;
	}
	public Produkt getProdukt () {
		return produkt;
	}
}