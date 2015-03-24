import java.util.Comparator;
import java.util.Random;

import animali.*;
import serie.Serie;
import istogramma.Istogramma;


public class Test {

	static final int CANE = 0;
	static final int GATTO = 1;
	static final int LEONE = 2;
	static final int TUCANO = 3;
	static final int SCORPIONE = 4;
	static final int INSTANCES  = 15;
	static String[] nomiSerie = {Cane.class.getName(), Gatto.class.getName(), Leone.class.getName(), Tucano.class.getName(), Scorpione.class.getName()};
	
	public static void main(String[] args) {
		Istogramma<Animale> istogramma = new Istogramma<Animale>();
		for(int i = 0; i < nomiSerie.length; i++)
			istogramma.aggiungiSerie(nomiSerie[i]);
		
		Comparator animalComparator = new AnimalComparator(); 
		Animale animale = null;
		
		for(int i = 0; i < INSTANCES; i++){
			int randomAnimal = new Random().nextInt(5);
			
			switch(randomAnimal){
			case CANE:
				animale = new Cane();
				break;
			case GATTO:
				animale = new Gatto();
				break;
			case LEONE:
				animale = new Leone();
				break;
			case TUCANO:
				animale = new Tucano();
				break;
			case SCORPIONE:
				animale = new Scorpione();
				break;
			}
			
			animale.nome = getRandomName();
			animale.padrone = getRandomPadrone();
			String nomeSerie = animale.getClass().getName();
			istogramma.aggiungiValore(nomeSerie, animale);
		}
		
		for(int i = 0; i < nomiSerie.length; i++){
			String nome = nomiSerie[i];
			if(istogramma.lunghezzaSerie(nome) != 0){
				System.out.println(	nome.substring(8) + " " 
									+ istogramma.lunghezzaSerie(nome) + " "
									+ istogramma.massimo(nome, animalComparator).nome + " " 
									+ istogramma.crescente(nome, animalComparator));
			}
		}
			
	}
	
	private static String getRandomName(){
		String[] nomi = {"Maya", "Buba", "Charlie", "Rudolf", "Pongo", "Peggy", "Argo", "Billy", "Lucky"};
		return nomi[new Random().nextInt(nomi.length)];
	}
	
	private static String getRandomPadrone(){
		String[] nomi = {"Peppo", "Mario", "Donato", "Alessandro", "Antonio"};
		return nomi[new Random().nextInt(nomi.length)];
	}

}
