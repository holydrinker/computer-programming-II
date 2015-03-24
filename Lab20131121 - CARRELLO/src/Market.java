import java.util.Random;

import carrello.Articolo;
import carrello.Carrello;


public class Market {
	private Articolo birra = new Articolo("BirraPeroni", "66cl");
	private Articolo biscotti = new Articolo("Macine", "270g");
	private Articolo pane = new Articolo("Pane","1kg");
	private Articolo pingui = new Articolo("Kinder Pinguì","5x");
	protected Articolo[] merce = {birra, biscotti, pane, pingui};
	protected Carrello[] acquisti;
	
	public Market(int numClienti) {
		inizializzaCarrello(numClienti);
	}
	
	private void inizializzaCarrello(int numClienti){
		acquisti = new Carrello[numClienti];
		
		for(int i = 0; i < acquisti.length; i++){
			int capienzaCarrello = 7;
			int numAcquisti = new Random().nextInt(capienzaCarrello);
			Carrello carrello = new Carrello();
			
			for(int j = 0; j < numAcquisti; j++)
				carrello.aggiungiArticolo(merce[new Random().nextInt(merce.length)]);
			
			acquisti[i] = carrello;
		}
	}
	
	public void stampa(){
		for(int i = 0; i < acquisti.length; i++){
			Carrello carrello = acquisti[i];
			
			for(Object o : carrello){
				Articolo a = (Articolo) o;
				int qta = carrello.quantità(a);
				System.out.println("Articolo: " + a.toString() + " Quantità: " + qta);
			}
			System.out.println("\n");
		}
	}
	
	public void istogramma(){
		Carrello mainCart = new Carrello();
		
		for(int i = 0; i < acquisti.length; i++){
			Carrello carrello = acquisti[i];
			
			for(Object o : carrello){
				Articolo a = (Articolo) o;
				mainCart.aggiungiArticolo(a);
			}
		}
		
		System.out.println("\nTOTALE ACQUSTI");
		for(Object o : mainCart){
			Articolo a = (Articolo) o;
			int qta = mainCart.quantità(a);
			System.out.println("Articolo: " + a.toString() + " Quantità: " + qta);
		}
	}
}
