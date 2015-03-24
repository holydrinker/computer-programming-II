package Polacca;

public class PolaccaTest {

	public static void main(String[] args) {
		
		String espressione = "35 17 40 9 - * + 7 - ";
		Polacca p = new Polacca();
		int res = p.valuta(espressione);
		
		System.out.println("Ris: " + res);
		
	}

}
