
public class Test {

	public static void main(String[] args){
		final int NUM_ACQUISTI = 10;
		Market market = new Market(NUM_ACQUISTI);
		market.stampa();
		market.istogramma();
	}
}
