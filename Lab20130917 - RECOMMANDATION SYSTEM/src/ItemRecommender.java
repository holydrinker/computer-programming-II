import java.util.Random;


public class ItemRecommender {
	Sessioni sessioni = new Sessioni();;
	private Prodotto birra = new Prodotto("birra",1);
	private Prodotto pizza = new Prodotto("pizza",3);
	private Prodotto yougurt = new Prodotto("yougurt",2);
	private Prodotto tovaglia  = new Prodotto("tovaglia",4);
	private Prodotto mattarello = new Prodotto("mattarello",3);
	private Prodotto microonde = new Prodotto("microonde",100);
	private Prodotto frullatore = new Prodotto("frullatore",20);
	private Prodotto cocacola = new Prodotto("cocacola",2);
	Prodotto[] prodottiAcquistabili = {birra, pizza, yougurt, tovaglia, mattarello, microonde, frullatore, cocacola};
	
	ItemRecommender(int N) {
		
		for(int i = 0; i < N; i++){
			SessioneLL sessioneCorrente = new SessioneLL();
			int numProdottiAcquistati = 2 + new Random().nextInt(4);
			
			for(int j = 0; j < numProdottiAcquistati; j++)
				sessioneCorrente.prodotti.add(prodottiAcquistabili[new Random().nextInt(prodottiAcquistabili.length)]);
			sessioni.listaSessioni.add(sessioneCorrente);	
		}
	}
	
	int acquistiAssociati(Prodotto a, Prodotto b){
		int counter = 0;
		
		for(Object s : sessioni.listaSessioni){
			SessioneLL sessione =  (SessioneLL) s;
			boolean aIsIn = false;
			boolean bIsIn = false;
			
			for(Object p : sessione.prodotti){
				Prodotto prodotto = (Prodotto) p;
				
				if(prodotto.equals(a))
					aIsIn = true;
				else if(prodotto.equals(b))
					bIsIn = true;
			}
			
			if(aIsIn && bIsIn)
				counter = counter+1;
		}
		
		return counter;
	}
	
}
