package dictionary;

import java.util.Iterator;

public class LinkeList<S> implements Dictionary<S> {
	private Record<S> head = null;
	private Record<S> last = null;
	
	class Record<S>{
		S value;
		Comparable key;
		Record<S> next;
		Record<S> prev;
		
		public Record(S value, Comparable key) {
			this.value = value;
			this.key = key;
			this.next = null;
			this.prev = null;
		}
	}
	
	@Override
	public void insert(S e, Comparable k) {
		Record<S> nuovo = new Record<S>(e,k);
		
		if(head == null){
			head = nuovo;
			last = nuovo;
			return;
		}
		
		//controllo del duplicato
		boolean duplicate = false;
		Record<S> tmp = head;
		while(!duplicate && tmp != null){
			if(tmp.key.equals(k))
				duplicate = true;
			else
				tmp = tmp.next;
		}
		if(duplicate)
			throw new EntryAlreadyExists(ExceptionMessages.DUPLICATE + k.toString());
		
		//inserimento elemento
		nuovo.prev = last;
		last.next = nuovo;
		last = nuovo;
	}

	@Override
	public void delete(Comparable k) {
		if(head == null)
			throw new EmptyDictionaryException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		Record<S> tmp = head;
		while(!found && tmp != null) {
			if(tmp.key.equals(k))
				found = true;
			else
				tmp = tmp.next;
		}
		if(!found)
			throw new EntryDoesntExist(ExceptionMessages.NOT_IN + k.toString());
		
		if(tmp == head){
			if(tmp == last){
				head = last = null;
				return;
			}
			head.next.prev = null;
			head = head.next;
			return;
		} else if (tmp == last){
			last.prev.next = null;
			last = last.prev;
			return;
		}
		
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
	}

	@Override
	public S search(Comparable k) {
		if(head == null)
			throw new EmptyDictionaryException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		Record<S> tmp = head;
		while(!found && tmp != null) {
			if(tmp.key.equals(k))
				found = true;
			else
				tmp = tmp.next;
		}
		if(!found)
			throw new EntryDoesntExist(ExceptionMessages.NOT_IN + k.toString());
		return tmp.value;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new Iterator<Comparable>(){
			Record<S> tmp = head;
			
			@Override
			public boolean hasNext() {
				return tmp != null;
			}

			@Override
			public Comparable next() {
				Comparable key = tmp.key;
				tmp = tmp.next;
				return key;
			}
		};
	}
}
