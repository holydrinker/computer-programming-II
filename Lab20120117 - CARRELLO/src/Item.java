import articoli.Articoli;


public class Item {
	private Articoli articolo;
	private int quantita;
	
	public Item(Articoli articolo, int quantita) {
		this.articolo = articolo;
		this.quantita = quantita;
	}
	
	public Articoli getArticolo(){
		return this.articolo;
	}
	
	public int getQuantita(){
		return this.quantita;
	}
}
