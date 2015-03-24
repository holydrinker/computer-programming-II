import java.util.Random;

import articoli.*;
import carrello.Carrello;


public class Test {

	public static void main(String[] args) {
		MarketBasketAnalysis mba = new MarketBasketAnalysis();
		int NUM_CARRELLI = 10;
		int NUM_MAX_ACQUISTI = 10;
		
		for(int i = 0; i < NUM_CARRELLI; i++){
			Carrello<Item> trolley = new Carrello<Item>();
			int numAcquisti = new Random().nextInt(NUM_MAX_ACQUISTI);
			
			for(int j = 0; j < numAcquisti; j++){
				int idxArticolo = new Random().nextInt(8);
				int qtaArticolo = new Random().nextInt(5)+1;
				
				switch(idxArticolo){
				case 0:
					trolley.add(new Item(new Pane(), qtaArticolo));
					break;
				case 1:
					trolley.add(new Item(new Cereali(), qtaArticolo));
					break;
				case 2:
					trolley.add(new Item(new Spaghetti(), qtaArticolo));
					break;
				case 3:
					trolley.add(new Item(new Burro(), qtaArticolo));
					break;
				case 4:
					trolley.add(new Item(new Sapone(), qtaArticolo));
					break;
				case 5:
					trolley.add(new Item(new Dentifricio(), qtaArticolo));
					break;
				case 6:
					trolley.add(new Item(new Piatti(), qtaArticolo));
					break;
				case 7:
					trolley.add(new Item(new Tovagliolini(), qtaArticolo));
					break;
				}
				trolley.forward();
				mba.add(trolley);
			}
		}
		
		System.out.println(mba.toString());
	}

}
