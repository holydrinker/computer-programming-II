import java.util.ArrayList;

import biblioteca.Biblioteca;
import biblioteca.Volume;

public class Test {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		int NUM_VOLUMI = 15;
		String lettera = "C";
		int numero = 9;
		ArrayList<String> allCodes = new ArrayList<String>();
		
		for(int i = 0; i < NUM_VOLUMI; i++){
			lettera = generaLettera(lettera);
			if(lettera.equalsIgnoreCase("A"))
				numero++;
			String codice = lettera+"-"+numero;
			allCodes.add(codice);
			biblioteca.registra( codice, "Titolo"+lettera+numero, "Autore"+lettera+numero, 2000);
		}
		System.out.println("TUTTI I VOLUMI (non in ordine di inserimento)");
		System.out.println(biblioteca.toString() + "\n");
		
		//---Ricerca
		ArrayList<String> copie10 = biblioteca.codice("TitoloA10", "AutoreA10", 2000);
		String codVol10 = copie10.get(0);
		System.out.println("Ricerca di un volume con codice che finisca con 10");
		System.out.println("Codice: " + codVol10);
		System.out.println("Titolo: " + biblioteca.titolo(codVol10));
		System.out.println("Autore : " + biblioteca.autore(codVol10));
		System.out.println("Anno: " + biblioteca.anno(codVol10) + "\n");
		
		ArrayList<String> copie13 = biblioteca.codice("TitoloA13", "AutoreA13", 2000);
		String codVol13 = copie13.get(0);
		System.out.println("Ricerca di un volume con codice che finisca con 13");
		System.out.println("Codice: " + codVol13);
		System.out.println("Titolo: " + biblioteca.titolo(codVol13));
		System.out.println("Autore: " + biblioteca.autore(codVol13));
		System.out.println("Anno: " + biblioteca.anno(codVol13) + "\n");
		
		ArrayList<String> copie14 = biblioteca.codice("TitoloA14", "AutoreA14", 2000);
		String codVol14 = copie14.get(0);
		System.out.println("Ricerca di un volume con codice che finisca con 14");
		System.out.println("Codice: " + codVol14);
		System.out.println("Titolo: " + biblioteca.titolo(codVol14));
		System.out.println("Autore: " + biblioteca.autore(codVol14));
		System.out.println("Anno: " + biblioteca.anno(codVol14) + "\n");

		//--Prestito
		int prestati = 0;
		
		for(String code : allCodes){
			if(iniziaConLettera(code, 'A')){
				biblioteca.prestito(code);
			}
			if(biblioteca.prestato(code))
				prestati++;
		}
		
		System.out.println("TUTTI I VOLUMI DOPO IL PRESTITO (non in ordine di inserimento)");
		System.out.println(biblioteca.toString() + "\n");
		
		System.out.println("Numero di tutti i volumi: " + biblioteca.volumi());
		System.out.println("Numero dei volumi presenti: " + (biblioteca.volumi() - prestati));
		
	}

	private static String generaLettera(String letteraPrecedente){
		String lettera = "";
		if(letteraPrecedente.equalsIgnoreCase("a"))
			lettera = "B";
		else if(letteraPrecedente.equalsIgnoreCase("b"))
			lettera = "C";
		else if(letteraPrecedente.equalsIgnoreCase("c"))
			lettera = "A";
		return lettera;
	}
	
	private static boolean iniziaConLettera(String codice, char carattere){
		char first = codice.charAt(0);
		return first == carattere;
	}
	
}
