package polimeri;

import monomeri.Aminoacidi;
import monomeri.Aminoacido;

public class Proteina extends Polimero {

	public Proteina(String stringaProteina) {
		
		sequenza = new AList();
		char symbol;
		Aminoacido aminoacido;
		Aminoacidi aminoacidi = Aminoacidi.getInstance();
		
		for(int i = 0; i < stringaProteina.length(); i++){
			
			symbol = stringaProteina.charAt(i);
			aminoacido = aminoacidi.aminoacidiList.get(symbol);
			sequenza.add(aminoacido);
		
		}	
	}
	
}
