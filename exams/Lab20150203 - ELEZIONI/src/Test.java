import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import elezione.Elezione;
import elezione.ListaElettorale;
import elezione.Voto;


public class Test {
	private static final int VOTANTI = 20;
	static ArrayList<ListaElettorale> liste;
	
	public static void main(String[] args) {
		/*
		 * Liste senza candidati
		 */
		ListaElettorale todosCaballeros = new ListaElettorale("Todos Caballeros");
		ListaElettorale noiCiSiamo = new ListaElettorale("Noi ci siamo");
		ListaElettorale futuroIncerto = new ListaElettorale("Futuro incerto");
		
		liste = new ArrayList<ListaElettorale>();
		liste.add(todosCaballeros);
		liste.add(noiCiSiamo);
		liste.add(futuroIncerto);
		
		Elezione elezione = new Elezione();
		for(ListaElettorale l : liste)
			elezione.aggiungiLista(l);
		
		/*
		 * Votazione
		 */
		for(int i = 0; i < VOTANTI; i++){
			Voto voto = generaVotoCasuale();
			elezione.scrutinaVoto(voto);
		}

		/*
		 * Risultati ordinati.
		 */
		List<ListaElettorale> elencoOrdinato = elezione.elencoOrdinato();
		for(ListaElettorale l : elencoOrdinato)
			System.out.println(l.getNomeLista() + " (" + elezione.numeroVoti(l) + " voti)");
		System.out.println("\nSchede bianche: " + elezione.bianche());
		System.out.println("Schede nulle: " + elezione.nulle());
		
	}

	/**
	 * Genera un voto, scegliando casualmente fra scheda bianca, scheda nulla e scheda valida.
	 * In caso la scheda sia valida, la lista da votare viene selezionata tramite il metodo getListaRandom()
	 * @return
	 */
	private static Voto generaVotoCasuale(){
		final int NULLA = 0;
		final int BIANCA = 1;
		final int PERC = 7; //Serve a rendere i numeri più reali, altrimenti troppe schede bianche e troppe schede nulle
		
		int idx = new Random().nextInt(PERC);
		if(idx == NULLA)
			return new Voto(null);
		else if(idx == BIANCA)
			return new Voto();
		else
			return new Voto(getListaRandom());
	}
	
	/**
	 * Estrae una lista elettorale a caso.
	 * @return
	 */
	private static ListaElettorale getListaRandom(){
		int idx = new Random().nextInt(liste.size());
		return liste.get(idx);
	}
}
