package biblioteca;

public class Volume {

	private String titolo;
	private String autore;
	private int anno;
	private boolean prestato;
	
	public Volume(String titolo, String autore, int anno, boolean prestato) {
		this.titolo = titolo;
		this.autore = autore;
		this.anno = anno;
		this.prestato = prestato;
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
	
	public boolean getPrestato(){
		return this.prestato;
				
	}
	
	public void setPrestato(boolean stato){
		this.prestato = stato;
	}
}
