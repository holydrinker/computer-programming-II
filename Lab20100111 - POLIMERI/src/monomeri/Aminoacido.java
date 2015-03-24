package monomeri;
import eccezioni.IllegalAminoacido;


public class Aminoacido extends Monomero {

	private static final String MSG_ILLEGAL_AMINOACIDO = "Aminoacido Illegale";
	private static final char[] aminoacidiSymbol = {'A', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'Y'};
	private static final String[] aminoacidiName = {"Alanina", "Cisteina", "Acido Aspartico", "Acido Glutammico",
													"Fenilalanina", "Glicina", "Istidina", "Isoleucina", "Lisina",
													"Leucina", "Metionina", "Asparagina", "Prolina", "Glutammina",
													"Argina", "Serina", "Treonina", "Valina", "Triptofano", "Tirosina"};
	
	public Aminoacido(char symbol, String name){
		
		if(!isValid(symbol, aminoacidiSymbol, name, aminoacidiName))
			throw new IllegalAminoacido(MSG_ILLEGAL_AMINOACIDO);
		
		super.name = name;
		super.symbol = symbol;
			
	}
	
}
