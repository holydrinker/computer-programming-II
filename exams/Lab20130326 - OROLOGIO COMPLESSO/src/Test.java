import orologio.OrologioDaPolso;
import frazioni.Minuto;
import frazioni.Ora;


public class Test {
	
	public static void main(String[] args){
		OrologioDaPolso o1 = new OrologioDaPolso();
		OrologioDaPolso o2 = new OrologioDaPolso();
		
		/*
		 * Attivo il primo orologio e faccio partire la simulazione del tempo fino a farlo fermare all'ora desiderata.
		 * A quel punto controllo che l'orologio attivo sia uguale a quello bloccato e stampo il risultato
		 */
		o1.start();
		o1.stopAt(new Ora("3"), new Minuto("59"));
		System.out.println("I due orologi sono uguali: " + o1.equals(o2));
		
		/*
		 * Riattivo l'orologio che aveva bloccato le lancette sull'orario desiderato, e lo faccio ribloccare al termine della giornata.
		 * A questo punto riverfico che il primo orologio che è stato attivo per l'arco di una intera giornata, sia uguale 
		 * all'orologio che non è mai stato attivato
		 */
		o1.start();
		o1.stopAt(new Ora("0"), new Minuto("0"));
		System.out.println("I due orologi sono uguali: " + o1.equals(o2));
	}
	
}
