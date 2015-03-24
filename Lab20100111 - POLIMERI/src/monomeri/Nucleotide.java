package monomeri;
import eccezioni.IllegalNucleotide;


public class Nucleotide extends Monomero {

	private static final char[] dnaNucleotidiSymbol = {'A', 'C', 'G', 'T'};
	private static final String[] dnaNucleotidiName = {"Adenina", "Citosina", "Guanina", "Timina"};
	private static final String MSG_ILLEGAL_NUCLEOTIDE = "Nucleotide Illegale!";
	
	public Nucleotide(char symbol, String name) {
		
		if(!isValid(symbol, dnaNucleotidiSymbol, name, dnaNucleotidiName))
			throw new IllegalNucleotide(MSG_ILLEGAL_NUCLEOTIDE);
		
		super.symbol = symbol;
		super.name = name;
		
	}
	
}
