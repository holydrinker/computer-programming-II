import java.util.LinkedList;
import java.util.Random;

import referendum.Cittadino;
import referendum.NonRegistrato;
import referendum.Referendum;
import referendum.Voto;

public class Test {

	public static void main(String[] args) {
		Cittadino c1 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c2 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c3 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c4 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c5 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c6 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c7 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c8 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c9 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c10 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c11 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c12 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c13 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c14 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c15 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c16 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c17 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c18 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c19 = new Cittadino("Ciccio", "Cappuccio");
		Cittadino c20 = new Cittadino("Ciccio", "Cappuccio");

		Referendum referendum = new Referendum();
		referendum.addCittadino(c1);
		referendum.addCittadino(c2);
		referendum.addCittadino(c3);
		referendum.addCittadino(c4);
		referendum.addCittadino(c5);
		referendum.addCittadino(c6);
		referendum.addCittadino(c7);
		referendum.addCittadino(c8);
		referendum.addCittadino(c9);
		referendum.addCittadino(c10);
		referendum.addCittadino(c11);
		referendum.addCittadino(c12);
		referendum.addCittadino(c13);
		referendum.addCittadino(c14);
		referendum.addCittadino(c15);
		referendum.addCittadino(c16);
		referendum.addCittadino(c17);
		referendum.addCittadino(c18);
		referendum.addCittadino(c19);
		referendum.addCittadino(c20);

		System.out.println("LISTA CITTADINI REGISTRATI");
		for (Object obj : referendum.registrati()) {
			Cittadino c = (Cittadino) obj;
			System.out.println(c.getNome() + " " + c.getCognome() + " ID: " + c.getId());
		}

		referendum.apriReferendum();
		LinkedList<Cittadino> cittadiniVotanti = new LinkedList<Cittadino>();
		cittadiniVotanti.add(c1);
		cittadiniVotanti.add(c2);
		cittadiniVotanti.add(c3);
		cittadiniVotanti.add(c4);
		cittadiniVotanti.add(c5);
		cittadiniVotanti.add(c6);
		cittadiniVotanti.add(c7);
		cittadiniVotanti.add(c8);
		cittadiniVotanti.add(c9);
		cittadiniVotanti.add(c10);
		cittadiniVotanti.add(c11);
		cittadiniVotanti.add(new Cittadino("Ciccio", "Pasticcio"));
		
		for(Cittadino c : cittadiniVotanti){
			try{
				referendum.vota(c, votoRandom());
			} catch (NonRegistrato e) {
				System.out.println(e.getMessage());
			}
		}
	
		referendum.chiudiRefendum();
		
		System.out.println("");
		System.out.println("Quorum: " + quorum(referendum) + "%");
		System.out.println("SI: " + referendum.votiSi());
		System.out.println("NO: " + referendum.votiNo());
		System.out.println("NULLE: " + referendum.schedeNulle());
		System.out.println("BIANCHE: " + referendum.schedeBianche());
		
		

	}

	static Voto votoRandom() {
		int idx = new Random().nextInt(Voto.values().length);
		switch (idx) {
			case 0:
				return Voto.si;
			case 1:
				return Voto.no;
			case 2:
				return Voto.bianca;
			case 3:
				return Voto.nulla;
		}
		return null;
	}
	
	//votanti : registrati = x : 100
	static int quorum(Referendum referendum){
		int registrati = referendum.registrati().size();
		int votanti = referendum.votanti().size();
		int quorum = votanti * 100 / registrati;
		
		return quorum;
	}

}
