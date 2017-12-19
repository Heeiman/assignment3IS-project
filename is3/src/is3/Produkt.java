package is3;

import java.util.HashMap;

public class Produkt {
	private String namn;
	private String kategori;
	private String pris;
	
	private HashMap<String, Exemplar> exemplarlista = new HashMap<String, Exemplar>();
	
	public void setNamn(String namn) {
		this.namn = namn;
	}
	public String getNamn() {
		return this.namn;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public String getKategori() {
		return kategori;
	}
	public void setPris(String pris) {
		this.pris = pris;
	}
	public String getPris() {
		return this.pris;
	}
	public void setExemplarlista (HashMap<String, Exemplar> exemplarlista) {
		this.exemplarlista = exemplarlista;
	}
	public HashMap<String, Exemplar> getExemplarlista () {
		return exemplarlista;
	}
	
	
}
