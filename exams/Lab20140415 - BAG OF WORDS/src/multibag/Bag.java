package multibag;

import java.util.Iterator;

import dictionary.Dictionary;
import dictionary.DictionaryArray;
import dictionary.EmptyStructureException;
import dictionary.EntryAlreadyExistsException;
import dictionary.EntryDoesntExistsException;

public class Bag implements Iterable {
	Dictionary<Integer> wordsFreq = new DictionaryArray<Integer>();
	
	public void addItem(String word){
		try {
			wordsFreq.insert(1, word);
		} catch (EntryAlreadyExistsException e) {
			int wordOccurrence = wordsFreq.search(word);
			wordsFreq.delete(word);
			wordsFreq.insert(wordOccurrence + 1, word);	
		}
	}

	public void delItem(String word){
		int occ;
		
		try {
			occ = wordsFreq.search(word);
		} catch (EntryDoesntExistsException e) {
			throw new WordDoesntExistException(ExceptionMessages.NOT_WORD + word);
		}
		
		wordsFreq.delete(word);
		if(occ > 1)
			wordsFreq.insert(occ - 1, word);
	}
	
	public int occurrences(String word){
		int occurrence = -1;
		
		try {
			occurrence = wordsFreq.search(word);
		} catch (EntryDoesntExistsException e) {
			occurrence = 0;
		} catch (EmptyStructureException e) {
			throw new EmptyBagException(ExceptionMessages.EMPTY);
		}
		
		return occurrence;
	}
	
	public boolean isEmpty(){
		try {
			wordsFreq.delete("");
		} catch (EmptyStructureException e) {
			return true;
		}
		
		return false;
	}

	@Override
	public Iterator iterator() {
		return wordsFreq.iterator();
	}
}
