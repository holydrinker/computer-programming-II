

public class Volume {
	private String titolo;
	private String autore;
	private int anno;
	private boolean stato;
	
	public Volume(String titolo, String autore, int anno) {
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
		this.stato = false;
	}
	
	public String getTitolo(){
		return this.titolo;
	}
	
	public String getAutore(){
		return this.autore;
	}
	
	public int getAnno(){
		return this.anno;
	}
	
	public boolean getStato(){
		return this.stato;
	}
	
	public void setStato(boolean stato){
		this.stato = stato;
	}
}
