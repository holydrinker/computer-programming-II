
import java.util.LinkedList;
import java.util.Random;

import bussola.Bussola;
import bussola.Cardinale;

public class Navigazione {
	static LinkedList<Record> registrazioni = new LinkedList<Record>();
	
	static void naviga(int N){	
		Bussola bussola = new Bussola();
		
		//Supponiamo che la nave salpi verso est
		Cardinale direzioneCorrente = Cardinale.porto;
		for(int i = 0; i < N; i++){
			if(deveRuotare())
				direzioneCorrente = ruota(bussola);
			registrazioni.add(new Record(i+1, direzioneCorrente));
		}
	}
	
	private static boolean deveRuotare(){
		Random gen = new Random();
		int idx = gen.nextInt(3);
		final int ROTATE = 0;
		
		if(idx == ROTATE)
			return true;
		else
			return false;
	}
	
	private static Cardinale ruota(Bussola bussola){
		Random gen = new Random();
		int idx = gen.nextInt(2);
		final int FORWARD = 0;
		
		if(idx == FORWARD)
			bussola.ruotaA();
		else
			bussola.ruotaI();
		return bussola.direzione();		
	}
	
	@Override
	public String toString() {
		String result = "";
		for(Record r : registrazioni){
			String direzione;
			if(r.direzione == Cardinale.porto)
				direzione = "Non ha ancora salpato";
			else
				direzione = r.direzione.toString();
			
			result += "istante: " + r.istante + " direzione: " + direzione + "\n";
		}
		return result;	
	}
	
	public static void main(String[] args){
		final int NUM_ISTANTI = 30;
		Navigazione nave = new Navigazione();
		Navigazione.naviga(NUM_ISTANTI);
		
		String tragitto = nave.toString();
		System.out.println("TRAGITTO NAVE");
		System.out.println(tragitto);
	}
}
