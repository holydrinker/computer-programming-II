
public class Test {

	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		
		//Test 1
		int NUM_VOLUMI = 15;
		String lettera = "C";
		int num = 9;
		
		for(int i = 0; i < NUM_VOLUMI; i++){
			lettera = generaLettera(lettera);
			if(lettera.equals("A"))
				num++;
			String genCode = lettera+"-"+num;
			biblioteca.registra(genCode, "Titolo" + genCode, "Autore" + genCode, 1992);
		}
		
		//Test2
		String c1 = "A-10";
		String titolo1 = biblioteca.titolo(c1);
		String autore1 = biblioteca.autore(c1);
		int anno1 = biblioteca.anno(c1);
		System.out.print("Ricerca codice " + c1 + ": ");
		System.out.println(titolo1 + " " + autore1 + " " + anno1);
		
		String c2 = "A-13";
		String titolo2 = biblioteca.titolo(c2);
		String autore2 = biblioteca.autore(c2);
		int anno2 = biblioteca.anno(c2);
		System.out.print("Ricerca codice " + c2 + ": ");
		System.out.println(titolo2 + " " + autore2 + " " + anno2);
		
		String c3 = "A-14";
		String titolo3 = biblioteca.titolo(c3);
		String autore3 = biblioteca.autore(c3);
		int anno3 = biblioteca.anno(c3);
		System.out.print("Ricerca codice " + c3 + ": ");
		System.out.println(titolo3 + " " + autore3 + " " + anno3);
		
		//Test3
		for(Object obj : biblioteca.volumi){
			String code = ((Comparable)obj).toString();
			if(code.charAt(0) == 'A')
				biblioteca.prestito(code);
			else if(code.charAt(0) == 'B')
				biblioteca.volumi.delete(code);
		}
		
		//Test4
		int numVolumi = biblioteca.volumi();
		int numPrestati = 0;
		
		for(Object obj : biblioteca.volumi){
			String code = ((Comparable)obj).toString();
			if(biblioteca.prestato(code))
				numPrestati++;
		}
		System.out.println("\nNumero volumi registrati: " + numVolumi);
		System.out.println("Numero volumi presenti: " + (numVolumi-numPrestati));
		
	}

	private static String generaLettera(String prevLett){
		if(prevLett.equals("A"))
			return "B";
		else if(prevLett.equals("B"))
			return "C";
		else if(prevLett.equals("C"))
			return "A";
		return "";
	}
}
