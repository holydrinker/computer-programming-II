
public class Test {

	static int NUM_SESSIONI = 20;
	static ItemRecommender itemRecommender;
	
	public static void main(String[] args) {
		itemRecommender = new ItemRecommender(NUM_SESSIONI);
		stampaSessioni();
		stampaCoOccorrenze(itemRecommender);
	}

	private static void stampaSessioni(){
		Sessioni sessioni = itemRecommender.sessioni;
		int idxSessione = 1;
		
		for(Object obj : sessioni.listaSessioni){
			System.out.println("sessione " + idxSessione++);
			SessioneLL sessioneCorrente = (SessioneLL)obj;
			
			for(Object o : sessioneCorrente.prodotti){
				Prodotto p = (Prodotto) o;
				System.out.print(p.getNome() + " ");
			}
			System.out.println("\n");
		}
	}
	
	private static void stampaCoOccorrenze(ItemRecommender itemRecommender){
		Prodotto[] prodottiAcquistabili = itemRecommender.prodottiAcquistabili;
		Sessioni sessioni = itemRecommender.sessioni;
		
		for(int i = 0; i < prodottiAcquistabili.length; i++){
			for(int j = 0; j < prodottiAcquistabili.length; j++){
				if(i != j){	
					int res = itemRecommender.acquistiAssociati(prodottiAcquistabili[i], prodottiAcquistabili[j]);
					System.out.println(	"Acquisti associati " + prodottiAcquistabili[i].getNome() 
										+ " - " + prodottiAcquistabili[j].getNome() + ": " + res);
				}
			}
		}
	}
}
