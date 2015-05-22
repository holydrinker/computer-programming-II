import bag.Bag;


public class BagOfWords {
	protected Bag<String> bow = new Bag<String>();
	protected int occurences = 0;
	
	void addText(String testo){
		String[] words = testo.split(" ");
		occurences += words.length;
		
		for(Object o : words){
			String word = o.toString();
			bow.addItem(word.toString());
		}
	}
	
	float similarita(BagOfWords b){
		float similarity = 0f;
		float n1 = this.occurences;
		float n2 = b.occurences;
		
		for(Object o : this.bow){
			String word = o.toString();
			int f1 = this.bow.occurrences(word);
			int f2 = b.bow.occurrences(word);
			similarity += ( (float) ((f1+1)/(n1+2)) ) * ( (float) ((f2+1)/(n2+2)) );
		}
		
		for(Object o : b.bow){
			String word = o.toString();
			float f1 = b.bow.occurrences(word);
			float f2 = this.bow.occurrences(word);
			similarity += ( (float) ((f1+1)/(n1+2)) ) * ( (float) ((f2+1)/(n2+2)) );
		}
		return similarity;
	}
	
	@Override
	public String toString() {
		return this.bow.toString();
	}
}
