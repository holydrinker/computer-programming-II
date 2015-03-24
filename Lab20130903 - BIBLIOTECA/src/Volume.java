import list.AddOnlyList;
import list.VectorList;

public class Volume {
	private String nome;
	private String editore;
	private int annoPubblicazione;
	private AddOnlyList<String> listaAutori = new VectorList<String>();
	
	public Volume(String nome, String editore, int annoPubblicazione) {
		this.nome = nome;
		this.editore = editore;
		this.annoPubblicazione = annoPubblicazione;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getEditore(){
		return this.editore;
	}
	
	public int getAnnoPubblicazione(){
		return this.annoPubblicazione;
	}
	
	public AddOnlyList<String> getListaAutori(){
		return this.listaAutori;
	}
	
	public void addAutore(String autore){
		this.listaAutori.add(autore);
	}
}
