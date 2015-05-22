import java.util.Iterator;


public class StrutturaCollegata<T> implements Dictionary<T> {
	private Record<T> inizio = null;
	private Record<T> fine = null;
	private int n = 0;
	
	class Record<T>{
		T value;
		Comparable key;
		Record<T> prev = null;
		Record<T> next = null;
		
		public Record(T value, Comparable key) {
			this.value = value;
			this.key = key;
		}
	}

	@Override
	public void insert(T e, Comparable k) {
		Record<T> nuovo = new Record<T>(e,k);
		
		if(inizio == null){ //ins testa
			inizio = nuovo;
			fine = nuovo;
		} else if (inizio.next == null){ //ins coda
			nuovo.prev = inizio;
			inizio.next = nuovo;
			fine = nuovo;
		} else {  //ins mezzo
			boolean duplicate = false;
			Record<T> tmp = inizio;
			while(!duplicate && tmp != null){
				if(tmp.key.equals(k))
					duplicate = true;
				else
					tmp = tmp.next;
			}
			if(duplicate)
				throw new ItemAlreadyPresentException(ExceptionMsg.DUPLICATE + ": " + k.toString()); //esiste duplicato
			nuovo.prev = fine;
			fine.next = nuovo;
			fine = nuovo;
		}
		n++;
	}

	@Override
	public void delete(Comparable k) {
		if(inizio == null)
			throw new EmptyDictionaryException(ExceptionMsg.EMPTY);
		
		if(inizio.key.equals(k)){
			if(inizio.next == null)
				inizio = fine = null;
			else{
				inizio = inizio.next;
				inizio.prev = null;
			}
		} else if(fine.key.equals(k)){
			fine = fine.prev;
			fine.next = null;
			return;
		} else {
			boolean found = false;
			Record<T> tmp = inizio;
			while(!found && tmp != null){
				if(tmp.key.equals(k))
					found = true;
				else
					tmp = tmp.next;
			}
			if(!found)
				throw new ItemNotPresentException(ExceptionMsg.NOT_IN + ": " + k.toString());
			
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
		}
		n--;
	}

	@Override
	public T search(Comparable k) {
		if(inizio == null)
			throw new EmptyDictionaryException(ExceptionMsg.EMPTY);
		
		boolean found = false;
		Record<T> tmp = inizio;
		while(!found && tmp != null){
			if(tmp.key.equals(k))
				found = true;
			else
				tmp = tmp.next;
		}
		if(!found)
			throw new ItemNotPresentException(ExceptionMsg.NOT_IN + ": " + k.toString());
		return tmp.value;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			Record<T> tmp = inizio;
			
			@Override
			public boolean hasNext() {
				return tmp != null;
			}

			@Override
			public T next() {
				T value = tmp.value;
				tmp = tmp.next;
				return value;
			}
		};
	}
	
	public int getNumElem(){
		return this.n;
	}
}
