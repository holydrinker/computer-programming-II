import java.util.ArrayList;

import list.AddOnlyList;
import list.DoubleLinkedList;
import biblioteca.Biblioteca;
import biblioteca.BibliotecaAbs;
import biblioteca.Record;
import biblioteca.Volume;

public class Test {
	public static void main(String[] args) {
		//2 copie
		AddOnlyList<String> a1 = new DoubleLinkedList<String>();
		a1.add("Camil Demetrescu");
		a1.add("Umberto Ferraro Petrillo");
		a1.add("Irene Finocchi");
		a1.add("Giuseppe F. Italiano");
		Volume v1 = new Volume("Progetto di Algoritmi e Strutture Dati in Java", "McGrowHill", 2007, a1);
		
		//1 copia
		AddOnlyList<String> a2 = new DoubleLinkedList<String>();
		a2.add("Alan Bertossi");
		Volume v2 = new Volume("Algoritmi e Strutture Dati", "CittaStudi Edizioni", 2009, a2);
		
		//3 copie
		AddOnlyList<String> a3 = new DoubleLinkedList<String>();
		a3.add("Deitel & Deitel");
		Volume v3 = new Volume("Programmazione in Java: Fondamenti", "Pearson-Prentice Hall", 2008, a3);
		
		//2 copie
		AddOnlyList<String> a4 = new DoubleLinkedList<String>();
		a4.add("John Lewis");
		a4.add("Joseph Chase");
		Volume v4 = new Volume("Java Software Structures", "Pearson Education", 2010, a4);
		
		BibliotecaAbs b = new Biblioteca();
		b.addVol(v1);
		b.addVol(v1);
		b.addVol(v2);
		b.addVol(v3);
		b.addVol(v3);
		b.addVol(v3);
		b.addVol(v4);
		b.addVol(v4);

		ArrayList<String> posizioni = b.posizioni(v4);
		String pos = posizioni.get(0);
		b.prestito(pos);
		
		for(Object s : b){
			String intpos = s.toString();
			Volume vol = b.volume(intpos);
			
			System.out.println(vol.listaAutori.toString());
			System.out.println(vol.titolo);
			System.out.println(vol.casaEditrice);
			System.out.println(vol.annoPubblicazione);
			System.out.println("Posizione: " + intpos);
			System.out.println("Disponibile: " + !b.prestato(intpos));
			System.out.println("");
		}
	}
}
