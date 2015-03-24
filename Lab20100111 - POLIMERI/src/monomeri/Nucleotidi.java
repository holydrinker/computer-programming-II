package monomeri;
import java.util.HashMap;


public class Nucleotidi {

	static Nucleotidi nucleotidi = null;
	public static HashMap<Character, Nucleotide> nucleotidiList = new HashMap<Character, Nucleotide>();
	
	private Nucleotidi() {
		inizializza();
	}
	
	public static Nucleotidi getInstance(){
		
		if(nucleotidi == null)
			nucleotidi = new Nucleotidi();
		return nucleotidi;
		
	}
	
	private void inizializza(){
		
		nucleotidiList.put('A', new Nucleotide('A',"Adenina"));
		nucleotidiList.put('C', new Nucleotide('C',"Citosina"));
		nucleotidiList.put('G', new Nucleotide('G',"Guanina"));
		nucleotidiList.put('T', new Nucleotide('T',"Timina"));
		
	}
}
