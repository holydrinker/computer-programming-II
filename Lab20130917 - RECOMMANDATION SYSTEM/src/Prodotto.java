

public class Prodotto {

	private String nome;
	private int prezzo;
	
	public Prodotto(String nome, int prezzo) {
		this.nome = nome;
		this.prezzo = prezzo;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getPrezzo(){
		return this.prezzo;
	}	
}
