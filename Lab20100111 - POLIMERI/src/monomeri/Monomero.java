package monomeri;

public abstract class Monomero {

	String name;
	char symbol;
	
	public String getName(){
		return this.name;
	}
	
	public char getSymbol(){
		return this.symbol;
	}
	
	/**
	 * Metodo per verificare la validità della istanziazione di una monomero
	 * @param mySymbol
	 * @param validSymbols
	 * @param myName
	 * @param validNames
	 * @return
	 */
	protected boolean isValid(char mySymbol, char[] validSymbols, String myName, String[] validNames){
		
		boolean valid = false;
		boolean symbolValidity = false;
		int i;
	
		for(i = 0; i < validSymbols.length; i++){			
			if(validSymbols[i] == mySymbol){
				symbolValidity = true;
				break;
			}
		}
		
		if(symbolValidity){
			if(validNames[i].equalsIgnoreCase(myName))
				valid = true;
		}
		
		return valid;
	}
	
	
}
