
public class Test {

	public static void main(String[] args) {
		String a = "Those who cannot remember the past are condemned to repeat it";
		String b = "Those who misquote Santayana are condemned to paraphrase him";
		String c = "Sanity is a madness put to good uses";
		
		BagOfWords b1 = new BagOfWords();
			b1.addText(a);
		BagOfWords b2 = new BagOfWords();
			b2.addText(b);
		BagOfWords b3 = new BagOfWords();
			b3.addText(c);
		
		System.out.println("Bag Of Words testo A: \n" + b1.toString());
		System.out.println("Bag Of Words testo B: \n" + b2.toString());
		System.out.println("Bag Of Words testo C: \n" + b3.toString() + "\n");
		System.out.println("Similarità fra a e b: " + b1.similarita(b2));
		System.out.println("Similarità fra b e c: " + b2.similarita(b3));
		System.out.println("Similarità fra a e c: " + b1.similarita(b3));
	}
	
}
