
public class Test {

	public static void main(String[] args) {
		
		String txtA = "Questo è un sistema innovativo per la scoperta automatica di plagi";
		BagOfWords A = new BagOfWords();
		A.addText(txtA);
		
		String txtB = "Questo sistema innovativo permette la scoperta automatica di plagi";
		BagOfWords B = new BagOfWords();
		B.addText(txtB);
		
		String txtC = "Questo sistema non fa prorpio nulla di interessante";
		BagOfWords C = new BagOfWords();
		C.addText(txtC);
		
		BagOfWords[] bags = {A, B, C};

		for(int i = 0; i < bags.length; i++){
			String name;
			
			if(i == 0)
				name = "A";
			else if(i == 1)
				name = "B";
			else
				name = "C";
			
			System.out.println("bag-of-word " + name);
			System.out.println("occurrences: " + bags[i].occurrences);
			
			for(Object o : bags[i].bagOfWords){
				String word = o.toString();
				int occW = bags[i].bagOfWords.occurrences(word);
				System.out.println(word + ": " + occW);
			}
			System.out.println("\n \n");
		}
		
		System.out.println("Similarità fra A e B " + A.similarity(B));
		System.out.println("Similarità fra A e C " + A.similarity(C));
		System.out.println("Similarità fra B e C " + B.similarity(C));
		
	}
}
