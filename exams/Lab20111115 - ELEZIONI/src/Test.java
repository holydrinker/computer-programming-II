import java.util.List;
import java.util.Random;

import elezioni.Elezione;
import elezioni.ListaElettorale;
import elezioni.Voto;


public class Test {
	static final int NULLA = 0;
	static final int BIANCA = 1;
	static final int VALIDA = 2;
	
	public static void main(String[] args) {
		ListaElettorale italia = new ListaElettorale("Viva l'Italia");
		ListaElettorale medio = new ListaElettorale("In medio stat virtus");
		ListaElettorale ecumenismo = new ListaElettorale("Ecumenismo a sinistra");
		ListaElettorale metamorfosi = new ListaElettorale("Metamorfosi");
		ListaElettorale[] liste = {italia, medio, ecumenismo, metamorfosi};
		int numVotanti = 50;
		
		Elezione elezione = new Elezione(numVotanti);
		elezione.aggiungiLista(italia);
		elezione.aggiungiLista(medio);
		elezione.aggiungiLista(ecumenismo);
		elezione.aggiungiLista(metamorfosi);
		
		int numVoti = 30;
		for(int i = 0; i < numVoti; i++){
			Voto voto = null;
			int tipoScheda = new Random().nextInt(3);
			ListaElettorale listaVotata = null;
			
			if(tipoScheda == NULLA){
				voto = new Voto(listaVotata);
			} else if (tipoScheda == BIANCA){
				voto = new Voto();
			} else if(tipoScheda == VALIDA) {
				listaVotata = liste[new Random().nextInt(liste.length)];
				voto = new Voto(listaVotata);
			}
			
			elezione.scrutinaVoto(voto);
		}
		
		System.out.println("Schede bianche: " + elezione.bianche());
		System.out.println("Schede nulle: " + elezione.nulle() + "\n");
		
		System.out.println("ESITI ELEZIONI");
		List<String> risultatiElezioni = elezione.elencoOrdinato();
		for(String s : risultatiElezioni)
			System.out.println(s);
		
		
	}
}
