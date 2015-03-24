package polimeri;

import monomeri.Nucleotide;
import monomeri.Nucleotidi;

public class DNA extends Polimero{

	public DNA(String stringaDNA) {
		
		sequenza = new AList();
		Nucleotidi nucleotidi = Nucleotidi.getInstance();
		
		for(int i = 0; i < stringaDNA.length(); i++){
			
			char symbol = stringaDNA.charAt(i);
			Nucleotide nucleotide = nucleotidi.nucleotidiList.get(symbol);
			sequenza.add(nucleotide);
			
		}
		
	}
	
}
