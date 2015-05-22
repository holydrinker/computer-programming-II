import multibag.Bag;


public class BagOfWords {

	protected Bag bagOfWords = new Bag();;
	protected int occurrences;
	
	void addText(String txt){
		String words[] = txt.split(" ");
		occurrences = words.length;
		
		for(int i = 0; i < words.length; i++)			
			bagOfWords.addItem(words[i]);
	}
	
	float similarity(BagOfWords bow){
		float similarity = 0f;
		
		for(Object w : bagOfWords){	
			String ws = w.toString();
			float p1 = ((float)(this.bagOfWords.occurrences(ws) + 1)) / (this.occurrences + 2);
			float p2 = ((float)(bow.bagOfWords.occurrences(ws) + 1)) / (bow.occurrences + 2);
			similarity += p1*p2;
		}
		
		for(Object w : bow.bagOfWords){	
			String ws = w.toString();
			float p1 = ((float)(this.bagOfWords.occurrences(ws) + 1)) / (this.occurrences + 2);
			float p2 = ((float)(bow.bagOfWords.occurrences(ws) + 1)) / (bow.occurrences + 2);
			similarity += p1*p2;
		}
		
		return similarity;
	}
}
