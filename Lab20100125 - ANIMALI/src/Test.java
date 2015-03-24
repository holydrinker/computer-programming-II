
import istogramma.Istogramma;

import java.util.Random;

import animali.Animale;
import animali.Cane;
import animali.Gatto;
import animali.Leone;
import animali.Scorpione;
import animali.Tucano;
import serie.Serie;
import serie.SerieDL;

public class Test {
	static final int INDICE_CANE = 0;
	static final int INDICE_GATTO = 1;
	static final int INDICE_LEONE = 2;
	static final int INDICE_TUCANO = 3;
	static final int INDICE_SCORPIONE = 4;
	static final int TYPE_OF_ANIMAL = 5;
	static final int DIM = 30;
	
	public static void main(String[] args){
		Serie<Animale> serie = new SerieDL<Animale>();
		Random r = new Random();
		
		for(int i = 0; i < DIM; i++)
			serie.add(getRandomAnimal(r));
	
		Istogramma istogramma = new Istogramma(serie);
		istogramma.print();
	}
	
	private static Animale getRandomAnimal(Random r){
		int animalIndex = r.nextInt(TYPE_OF_ANIMAL);
		
		if(animalIndex == INDICE_CANE)
			return new Cane();
		else if(animalIndex == INDICE_GATTO)
			return new Gatto();
		else if (animalIndex == INDICE_LEONE)
			return new Leone();
		else if ( animalIndex == INDICE_SCORPIONE )
			return new Scorpione();
		else if(animalIndex == INDICE_TUCANO )
			return new Tucano();
		else 
			return null;
	}
}
