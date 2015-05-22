package bag;

import java.util.Iterator;

import dictionary.DictArray;
import dictionary.Dictionary;
import dictionary.EmptyStructureException;
import dictionary.EntryAlreadyExists;
import dictionary.EntryDoesntExistException;

public class Bag<T> implements Iterable<T> {
	protected Dictionary<T,Integer> freqParole = new DictArray<T,Integer>();
	
	public void addItem(T item){
		
		try {
			freqParole.insert(item, 1);
		} catch (EntryAlreadyExists e) {
			int freqItem = freqParole.search(item);
			freqParole.delete(item);
			freqParole.insert(item, freqItem+1);
		}	
	}
	
	public void delItem(T item){
		
		try {
			int freqItem = freqParole.search(item);
			freqParole.delete(item);
			if(freqItem > 1)
				freqParole.insert(item, freqItem - 1);
			
		} catch (EntryDoesntExistException e) {
			throw new EntryNotInBagException(e.getMessage());
		} catch (EmptyStructureException e) {
			throw new EmptyBagException(e.getMessage());
		}
		
	}
	
	public int occurrences(T item){
		//se l'elemento non è presente ritorna zero
		int occurrencesItem = 0;
		
		try {
			occurrencesItem = freqParole.search(item);	
		} catch (EntryDoesntExistException e) {
		} catch (EmptyStructureException e) {
		}
		return occurrencesItem;
	}
	
	public boolean isEmpty(){
		int n = 0;
		for(Object o : freqParole)
				n++;
		return n == 0;
	}
	
	@Override
	public Iterator<T> iterator() {
		return freqParole.iterator();
	}
	
	@Override
	public String toString() {
		return freqParole.toString();
	}
}
