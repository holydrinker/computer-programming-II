package monomeri;
import java.util.HashMap;


public class Aminoacidi {

	public static Aminoacidi aminoacidi = null;
	public static HashMap<Character, Aminoacido> aminoacidiList = new HashMap<Character, Aminoacido>();
	
	private Aminoacidi(){
		inizializza();
	}
	
	public static Aminoacidi getInstance(){
		
		if (aminoacidi == null)
			aminoacidi = new Aminoacidi();
		return aminoacidi;
		
	}
	
	private static void inizializza(){
		
		aminoacidiList.put('A', new Aminoacido('A',"Alanina"));
		aminoacidiList.put('C', new Aminoacido('C',"Cisteina"));
		aminoacidiList.put('D', new Aminoacido('D',"Acido Aspartico"));
		aminoacidiList.put('E', new Aminoacido('E',"Acido Glutammico"));
		
	}
	
}
