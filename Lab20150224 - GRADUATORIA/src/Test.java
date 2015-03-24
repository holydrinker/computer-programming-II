import java.util.Random;

import graduatoria.Graduatoria;
import graduatoria.Progetto;
import graduatoria.Record;


public class Test {
	static final int NUM_PROGETTI = 20;
	
	public static void main(String[] args) {
		Graduatoria graduatoria = new Graduatoria();	
		for(int i = 0; i < NUM_PROGETTI; i++)
			graduatoria.aggG(rateGen(), new Progetto(nameGen()));
		
		/*
		 * Backup della graduatoria
		 */
		Graduatoria backup = new Graduatoria();
		for(Object o : graduatoria){
			float punteggio = ((Record)o).punteggio;
			Progetto progetto = ((Record)o).progetto;
			backup.aggG(punteggio, progetto);
		}
		
		/*
		 * Stampa	
		 */
		
		while(!graduatoria.èVuota()){
			float punteggio = graduatoria.primoV();
			Progetto progetto = graduatoria.primoP();
			graduatoria.restoG();
			System.out.println(punteggio + " " + progetto.toString());
		}
		
		/*
		 * Ripristino graduatoria
		 * Media
		 */
		graduatoria = backup;
		System.out.println("\nMedia: " + graduatoria.media());
		
		/*
		 * Contenuta
		 */
		Graduatoria graduatoria2 = new Graduatoria();
		final int PRIMA = 0;
		final int TERZA = 2;
		final int ULTIMA = graduatoria.dim() - 1;
		
		int i = 0;
		for(Object o : graduatoria){
			float punteggio = ((Record)o).punteggio;
			Progetto progetto = ((Record)o).progetto;
			if(i != PRIMA && i != TERZA && i != ULTIMA)
				graduatoria2.aggG(punteggio, progetto);
			i++;
		}
		
		boolean result = graduatoria2.contenuta(graduatoria);
		System.out.println("\nLa graduatoria più piccola è contenuta nella graduatoria più grande: " + result);
	}
	
	/**
	 * Genera un nome casuale di lunghezza compresa fra 3 e 5
	 */
	private static String nameGen(){
		int length = new Random().nextInt(2) + 3;
		final String MATRIX = "ABCDEFGHILMNOPQRSTUVZ"; 
		String name = "";
		for(int i = 0; i < length; i++)
			name += MATRIX.charAt(new Random().nextInt(MATRIX.length()));
		return name;
	}
	
	/**
	 * Genera un punteggio compreso fra 0 e 15
	 * @return
	 */
	private static float rateGen(){
		return new Random().nextFloat() * 15f;
	}
}
