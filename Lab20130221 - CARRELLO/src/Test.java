import java.util.Random;

import articoli.*;
import list.Carrello;


public class Test {
	
	public static void main(String[] args){
		MarketBasketAnalysis mba = new MarketBasketAnalysis();
		int CARRELLI = 10;
		Carrello<Item>[] carrelli = new Carrello[CARRELLI];
		
		for(int i = 0; i < carrelli.length; i++){
			carrelli[i] = inizializzaCarrelloCasualmente();
			mba.add(carrelli[i]);
		}
		
		System.out.println(mba.toString());
	}
	
	private static Carrello<Item> inizializzaCarrelloCasualmente(){
		Carrello<Item> carrello = new Carrello<Item>();
		int numArticoliAcquistati = new Random().nextInt(5) + 1;
		int idx = new Random().nextInt(8);
		int qta = new Random().nextInt(5) + 1;
		
		for(int i = 0; i < numArticoliAcquistati; i++){
			switch(idx){
			
			case 0:
				carrello.add(new Item(new Pane(), qta));
				break;
			case 1:
				carrello.add(new Item(new Burro(), qta));
				break;
			case 2:
				carrello.add(new Item(new Spaghetti(), qta));
				break;
			case 3:
				carrello.add(new Item(new Cereali(), qta));
				break;
			case 4:
				carrello.add(new Item(new Sapone(), qta));
				break;
			case 5:
				carrello.add(new Item(new Dentifricio(), qta));
				break;
			case 6:
				carrello.add(new Item(new Tovagliolini(), qta));
				break;
			case 7:
				carrello.add(new Item(new Piatti(), qta));
				break;
			}
		}
		return carrello;
	}
}
