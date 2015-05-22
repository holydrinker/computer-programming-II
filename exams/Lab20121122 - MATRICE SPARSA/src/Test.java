
public class Test {
	static String testo1 = "those who cannot remember the past are condemned to repeat it";
	static String testo2 = "those who misquote santayana are condemned to paraphrase him";
	static String testo3 = "sanity is a madness put to good uses";
	static String[] dizionario = {"those" , "who" , "cannot" , "the" , "madness" , "are" , "to"};
	static String[] testi = {testo1, testo2, testo3};
	static final int PRESENTE = 1;
	static final int ASSENTE = 0;
	
	private static MatriceSparsaD<Integer> text = new MatriceSparsaD<Integer>(testi.length, dizionario.length, ASSENTE);
	
	public static void main(String[] args) {
		/*
		 * Indice i -> Scandisce i testi
		 * Indice j -> Scandisce le parole di un testo
		 * Indice k -> Scandisce le parole di un dizionario
		 */
		for(int i = 0; i < testi.length; i++){
			String[] words = testi[i].split(" ");
			
			for(int j = 0; j < words.length; j++){
				String word = words[j];
				
				for(int k = 0; k < dizionario.length; k++)
					if(word.equals(dizionario[k]))
						text.cambiaValore(i, k, PRESENTE);
			}	
		}
		System.out.println("MATRIX");
		System.out.println(text.toString() + "\n");
		System.out.println("Similarita primo testo (prima riga) con se stesso: " + text.similarita(0, 0));
		System.out.println("Similarita primo testo (prima riga) con secondo testo (seconda riga): " + text.similarita(0, 1));
		System.out.println("Similarita primo testo (prima riga) con terzo testo: " + text.similarita(0, 2));
	}
}
