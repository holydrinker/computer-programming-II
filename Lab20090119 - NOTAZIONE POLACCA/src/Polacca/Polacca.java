package Polacca;
import Pila.PilaCollegata;

public class Polacca {

	private final static String SUM = "+";
	private final static String MINUS = "-";
	private final static String MULT = "*";
	private final static String DIV = "/";
	private static String[] operazioni = {SUM, MINUS, MULT, DIV}; 
	
	PilaCollegata pila = new PilaCollegata();
	
	public int valuta(String espressione){
		
		String symbol = "";
		char c; 
		
		for(int i = 0; i < espressione.length(); i++){
			
			c = espressione.charAt(i);
			
			//finchè non mi imbatto in uno spazio continuo a scandire
			if(c != ' ')
				symbol += Character.toString(c);
			
			//appena mi imbatto in uno spazio...
			else{
				
				//Se riesco a convertirlo in intero, significa che è operando, quindi inpilo
				try{
					
					int num = Integer.parseInt(symbol);
					pila.push(num);
					System.out.println(pila.toString());
					
				//Se non ci sono riuscito, significa che è un operatore	
				}catch(Exception ecc){
					
					//Identifico l'operatore e faccio le operazioni
					int sec = (int) pila.top();
					pila.pop();
					int first = (int) pila.top();
					pila.pop();
					
					if(symbol.equals(SUM))
						pila.push(first + sec);
					else if(symbol.equals(MINUS))
						pila.push(first - sec);
					else if(symbol.equals(MULT))
						pila.push(first * sec);
					else if(symbol.equals(DIV))
						pila.push(first / sec);
					
				}
				symbol = "";
			}
		}
		return (int)pila.top();
	}
}
