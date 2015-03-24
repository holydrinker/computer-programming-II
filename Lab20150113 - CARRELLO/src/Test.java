import matriceSparsa.MatriceSparsa;


public class Test {
	private static final int RIGHE = 4;
	private static final int COLONNE = 9;
	private static final int ASSENTE = 0;
	private static final int PRESENTE = 1;
	private static MatriceSparsa<Integer> test = new MatriceSparsa<Integer>(RIGHE, COLONNE, ASSENTE);
	private static String[] dizionario = {	"pane", "burro", "marmellata", "biscotti", 
											"patatine", "aranciata", "cioccolata", "prosciutto", "formaggio" };
	
	public static void main(String[] args) {
		//carrello1
		int CARRELLO1 = 0;
		test.cambiaValore(CARRELLO1, getItemIdx("pane"), PRESENTE);
		test.cambiaValore(CARRELLO1, getItemIdx("burro"), PRESENTE);
		test.cambiaValore(CARRELLO1, getItemIdx("formaggio"), PRESENTE);
		
		//carrello2
		int CARRELLO2 = 1;
		test.cambiaValore(CARRELLO2, getItemIdx("cioccolata"), PRESENTE);
		test.cambiaValore(CARRELLO2, getItemIdx("biscotti"), PRESENTE);
		test.cambiaValore(CARRELLO2, getItemIdx("patatine"), PRESENTE);
		
		//carrello3
		int CARRELLO3 = 2;
		test.cambiaValore(CARRELLO3, getItemIdx("prosciutto"), PRESENTE);
		test.cambiaValore(CARRELLO3, getItemIdx("formaggio"), PRESENTE);
		test.cambiaValore(CARRELLO3, getItemIdx("aranciata"), PRESENTE);
		
		//carrello4
		int CARRELLO4 = 3;
		test.cambiaValore(CARRELLO4, getItemIdx("pane"), PRESENTE);
		test.cambiaValore(CARRELLO4, getItemIdx("prosciutto"), PRESENTE);
		test.cambiaValore(CARRELLO4, getItemIdx("marmellata"), PRESENTE);
		test.cambiaValore(CARRELLO4, getItemIdx("formaggio"), PRESENTE);
		test.cambiaValore(CARRELLO4, getItemIdx("patatine"), PRESENTE);
		
		System.out.println("MATRICE SPARSA\n");
		System.out.println(test.toString());
		System.out.println("\n\nCALCOLO DELLA SIMILARITA");
		System.out.println("Similarità fra carrello1 e carrello2: " + similarity(CARRELLO1, CARRELLO2));
		System.out.println("Similarità fra carrello1 e carrello3: " + similarity(CARRELLO1, CARRELLO3));
		System.out.println("Similarità fra carrello1 e carrello4: " + similarity(CARRELLO1, CARRELLO4));
		System.out.println("Similarità fra carrello2 e carrello3: " + similarity(CARRELLO2, CARRELLO3));
		System.out.println("Similarità fra carrello2 e carrello4: " + similarity(CARRELLO2, CARRELLO4));
		System.out.println("Similarità fra carrello3 e carrello4: " + similarity(CARRELLO3, CARRELLO4));
	}
	
	private static int getItemIdx(String item){
		int NOT_FOUND = -1;
		for(int i = 0; i < dizionario.length; i++)
			if(dizionario[i].equalsIgnoreCase(item))
				return i;
		return NOT_FOUND;
	}
	
	private static int similarity(int rigaCarrelloA, int rigaCarrelloB){
		int similarity = 0;
		for(int i = 0; i < test.numeroColonne(); i++){
			Integer v1 = test.valore(rigaCarrelloA, i);
			Integer v2 = test.valore(rigaCarrelloB, i);
			if(v1 == v2)
				if(v1 != ASSENTE)
				similarity++;
		}
		return similarity;
	}
}
