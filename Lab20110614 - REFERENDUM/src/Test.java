import java.util.Random;

import referendum.Quesito;
import referendum.Referendum;
import referendum.Voto;


public class Test {

	public static void main(String[] args) {
		
		final int MAX_VOTATORI = 20;
		Quesito<Voto> abrogazioneProveEsame = new Quesito<Voto>("prova esame");
		Quesito<Voto> abrogazioneFrequenzaObbligatoria = new Quesito<Voto>("frequenza obbligatoria");
		Quesito<Voto> abrogazioneTasseUniversitarie = new Quesito<Voto>("tasse universitarie");
		Quesito<Voto> abrogazioneDirittoStudio = new Quesito<Voto>("diritto allo studio");
		
		Referendum ref = new Referendum(MAX_VOTATORI);
		ref.aggiungiQuesito(abrogazioneProveEsame);
		ref.aggiungiQuesito(abrogazioneFrequenzaObbligatoria);
		ref.aggiungiQuesito(abrogazioneTasseUniversitarie);
		ref.aggiungiQuesito(abrogazioneDirittoStudio);
		
		for(Object q : ref){
			
			Quesito<Voto> tmpQ = (Quesito<Voto>) q;
			System.out.println(tmpQ.quesito);
			
			int numVotanti = generaNumeroVotanti();
			
			for(int i = 0; i < numVotanti; i++){
				
				Voto v = scrutinaVoto();
				tmpQ.add(v);
				System.out.print(v + " ");
				
			}
			
			if(ref.quorum(tmpQ))
				System.out.println("\nQUORUM RAGGIUNTO");
			else
				System.out.println("\nQUORUM NON RAGGIUNTO");
			
			System.out.println("");
			
		}

	}

	private static int generaNumeroVotanti(){
		
		final int MIN_VOTANTI = 7;
		final int VAR_VOTANTI = 7;
		
		Random r = new Random();
		return r.nextInt(VAR_VOTANTI) + MIN_VOTANTI;
		
	}
	
	private static Voto scrutinaVoto(){
		
		final int SI = 0;
		final int NO = 1;
		final int NULLA = 2;
		final int BIANCA = 3;
		final int TIPI_VOTI = 4;
		
		Random r = new Random();
		int voto = r.nextInt(TIPI_VOTI);
		
		switch(voto){
		
			case SI:
				return Voto.si;
			
			case NO:
				return Voto.no;
				
			case NULLA:
				return Voto.nulla;
			
			case BIANCA:
				return Voto.bianca;
		
		}
		
		return null;
	}
	
}
