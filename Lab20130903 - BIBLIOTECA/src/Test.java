import java.util.Random;

import list.AddOnlyList;


public class Test {

	public static void main(String[] args){
		Volume v1 = new Volume("Progetto di Algoritmi e Strutture Data in Java", "McGrowHill", 2007);
		v1.addAutore("Camil Demetrescu");
		v1.addAutore("Umberto Ferraro Petrillo");
		v1.addAutore("Irene Finocchi");
		v1.addAutore("Giuseppe F. Italiano");
		
		Volume v2 = new Volume("Algoritmi e Strutture di Dati", "Citt‡Studi Edizioni", 2009);
		v2.addAutore("Alan Bertossi");
		
		Volume v3 = new Volume("Programmazione Java: Fondamenti", "Pearson-Prentice Hall", 2008);
		v3.addAutore("Deitel & Deitel");
		
		Volume v4 = new Volume("Java Software Structures", "Pearson Education", 2010);
		v4.addAutore("John Lewis");
		v4.addAutore("Joseph Chase");
		
		BibliotecaAbs biblioteca = new Biblioteca();
		biblioteca.addVol(generateRandomPos(), new Record(v1));
		biblioteca.addVol(generateRandomPos(), new Record(v1));
		biblioteca.addVol(generateRandomPos(), new Record(v1));
		biblioteca.addVol(generateRandomPos(), new Record(v2));
		biblioteca.addVol(generateRandomPos(), new Record(v3));
		biblioteca.addVol(generateRandomPos(), new Record(v3));
		biblioteca.addVol(generateRandomPos(), new Record(v4));
		
		AddOnlyList<String> list = biblioteca.posizione(v3);
		String pos = getFirstPos(list);
		biblioteca.prestito(pos);
		stampaVolumi(biblioteca);
	}
	
	private static String generateRandomPos(){
		String posizione = "";
		
		int numArmadio = new Random().nextInt(10);
		int numScaffale = new Random().nextInt(20);
		int progressivo = new Random().nextInt(100) + 1;
		posizione += "Armadio:" + numArmadio + "-Scaffale:" + numScaffale + "-Progressivo:" + progressivo + " ";
		return posizione;
	} 
	
	private static void stampaVolumi(BibliotecaAbs biblioteca){
		
		for(Object o : biblioteca.volumi){
			
			String pos = o.toString();
			Record r = biblioteca.volumi.search(pos);
			boolean prestato = r.getPrestato();
			Volume v = r.getVolume();
			String nome = v.getNome();
			String editore = v.getEditore();
			int anno = v.getAnnoPubblicazione();
			AddOnlyList<String> autori = v.getListaAutori();
			
			System.out.println(pos);
			System.out.println(nome);
			System.out.println(editore);
			System.out.println(anno);
			if(prestato)
				System.out.println("prestato");
			else
				System.out.println("disponibile");
			System.out.println(autori.toString() + "\n");
		}
	}
	
	private static String getFirstPos(AddOnlyList<String> list){
		String listToString = list.toString();
		String firstPos = "";

		for(int i = 0; i < listToString.length(); i++){
			String nextChar = Character.toString(listToString.charAt(i));
			
			if(nextChar.equalsIgnoreCase(" "))
				break;
			else
				firstPos += nextChar;
		}
		
		return firstPos + " ";
	}
}
