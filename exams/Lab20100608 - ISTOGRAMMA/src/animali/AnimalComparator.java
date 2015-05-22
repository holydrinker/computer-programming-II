package animali;

import java.util.Comparator;

public class AnimalComparator implements Comparator {
	
	/**
	 * Restituisce -1 se arg0 < arg1
	 * Restituisce 0 se arg0 == arg1
	 * Restituisce +1 se arg0 > arg1
	 */
	@Override
	public int compare(Object arg0, Object arg1) {
		Animale animale1 = (Animale) arg0;
		Animale animale2 = (Animale) arg1;
		
		if(animale1.nome.equals(animale2.nome)){
			return animale1.padrone.compareTo(animale2.padrone);
		} else
			return animale1.nome.compareTo(animale2.nome);				
	}
}
