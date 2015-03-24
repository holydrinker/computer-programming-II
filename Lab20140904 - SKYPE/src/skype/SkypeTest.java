package skype;

import java.util.ArrayList;
import java.util.Random;

public class SkypeTest {

	public static void main(String[] args) {
		Pacchetto c1p1 = new Pacchetto(0, "Asd", false);
		Pacchetto c1p2 = new Pacchetto(1, "è", false);
		Pacchetto c1p3 = new Pacchetto(2, "un", false);
		Pacchetto c1p4 = new Pacchetto(3, "esame", false);
		Pacchetto c1p5 = new Pacchetto(4, "utile", false);
		Pacchetto c1p6 = new Pacchetto(5, "ed", false);
		Pacchetto c1p7 = new Pacchetto(6, "appassionante", true);
		
		Pacchetto c2p1 = new Pacchetto(0, "Asd", false);
		Pacchetto c2p2 = new Pacchetto(1, "è", false);
		Pacchetto c2p3 = new Pacchetto(2, "un", false);
		Pacchetto c2p4 = new Pacchetto(3, "esame", false);
		Pacchetto c2p5 = new Pacchetto(4, "utile", false);
		Pacchetto c2p6 = new Pacchetto(5, "ed", false);
		Pacchetto c2p7 = new Pacchetto(6, "appassionante", false);
		Pacchetto c2p8 = new Pacchetto(7, "presente nel", false);
		Pacchetto c2p9 = new Pacchetto(8, "piano di studi", true);
		
		Pacchetto c3p1 = new Pacchetto(0, "Asd", false);
		Pacchetto c3p2 = new Pacchetto(1, "è", false);
		Pacchetto c3p3 = new Pacchetto(2, "un", false);
		Pacchetto c3p4 = new Pacchetto(3, "esame", false);
		Pacchetto c3p5 = new Pacchetto(4, "utile", false);
		Pacchetto c3p6 = new Pacchetto(5, "ed", false);
		Pacchetto c3p7 = new Pacchetto(6, "appassionante", false);
		Pacchetto c3p8 = new Pacchetto(7, "presente nel", false);
		Pacchetto c3p9 = new Pacchetto(8, "piano di studi", false);
		Pacchetto c3p10 = new Pacchetto(9, "degli", false);
		Pacchetto c3p11 = new Pacchetto(10, "studenti", false);
		Pacchetto c3p12 = new Pacchetto(11, "di", false);
		Pacchetto c3p13 = new Pacchetto(12, "ITPS", true);
		
		ArrayList<Pacchetto> packC1 = new ArrayList<Pacchetto>();
		packC1.add(c1p1);
		packC1.add(c1p2);
		packC1.add(c1p3);
		packC1.add(c1p4);
		packC1.add(c1p5);
		packC1.add(c1p6);
		packC1.add(c1p7);
		
		ArrayList<Pacchetto> packC2 = new ArrayList<Pacchetto>();
		packC2.add(c2p1);
		packC2.add(c2p2);
		packC2.add(c2p3);
		packC2.add(c2p4);
		packC2.add(c2p5);
		packC2.add(c2p6);
		packC2.add(c2p7);
		packC2.add(c2p8);
		packC2.add(c2p9);
		
		ArrayList<Pacchetto> packC3 = new ArrayList<Pacchetto>();
		packC3.add(c3p1);
		packC3.add(c3p2);
		packC3.add(c3p3);
		packC3.add(c3p4);
		packC3.add(c3p5);
		packC3.add(c3p6);
		packC3.add(c3p7);
		packC3.add(c3p8);
		packC3.add(c3p9);
		packC3.add(c3p10);
		packC3.add(c3p11);
		packC3.add(c3p12);
		packC3.add(c3p13);
	
		Skype comunicazione1 = new Skype();
		int startSizeC1 = packC1.size();
		for(int i = 0; i < startSizeC1; i++){
			int idx = new Random().nextInt(packC1.size());
			Pacchetto p = packC1.get(idx);
			comunicazione1.addPacchetto(p);
			packC1.remove(idx);	
		}
		
		Skype comunicazione2 = new Skype();
		int startSizeC2 = packC2.size();
		for(int i = 0; i < startSizeC2; i++){
			int idx = new Random().nextInt(packC2.size());
			Pacchetto p = packC2.get(idx);
			comunicazione2.addPacchetto(p);
			packC2.remove(idx);	
		}
		
		Skype comunicazione3 = new Skype();
		int startSizeC3 = packC3.size();
		for(int i = 0; i < startSizeC3; i++){
			int idx = new Random().nextInt(packC3.size());
			Pacchetto p = packC3.get(idx);
			comunicazione3.addPacchetto(p);
			packC3.remove(idx);	
		}
		
		if(comunicazione1.complete())
			System.out.println("Comunicazione1: " + comunicazione1.toString());
		if(comunicazione2.complete())
			System.out.println("Comunicazione2: " + comunicazione2.toString());
		if(comunicazione3.complete())
			System.out.println("Comunicazione3: " + comunicazione3.toString());
		
		System.out.println("Confronto fra Comunicazione1 e Comunicazione2: " + comunicazione1.compareTo(comunicazione2));
	}
	
}
