package dictionary;

import java.util.Iterator;

public class LinkedDict<S> implements Dictionary<S> {
	private Record<S> head;
	
	class Record<S>{
		Comparable key;
		S value;
		Record<S> next;
		
		public Record(S value, Comparable key) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}
	

	@Override
	public void insert(S e, Comparable k) {
		Record<S> newRec = new Record<S>(e,k);
		boolean duplicate = false;
		Record<S> tmp = head;
		
		//--verifico se esiste un duplicato
		while(!duplicate && tmp!=null){
				if(tmp.key.equals(k))
					duplicate = true;
				else
					tmp = tmp.next;
		}
		if(duplicate)
			throw new EntryAlreadyExistException(ExceptionMessages.DUPLICATE + k.toString());
		
		//inserisco il nuovo record
		if(head==null)
			head = newRec;
		else{
			newRec.next = head.next;
			head.next = newRec;
		}
	}

	@Override
	public void delete(Comparable k) {
		if(head==null)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		//se l'elemento da eliminare si trova in testa
		if(head.key.equals(k)){
			if(head.next == null)
				head = null;
			else
				head = head.next;
			return;
		}
		
		//ricerca dell'elemento da eliminare
		boolean found = false;
		Record<S> tmp = head;
		while(!found && tmp.next != null){
			if(tmp.next.key.equals(k))
				found=true;
			else
				tmp = tmp.next;
		}
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_IN + k);
		
		//se l'elemento si trova alla fine diventa null, in modo che il precedente, puntando ad una cella null, diventi l'ultimo
		if(tmp.next == null)
			tmp = null;
		//se l'elemento si trova in mezzo devo creare un ponte di collegamenti per saltarlo
		else
		tmp.next = tmp.next.next;
	}

	@Override
	public S search(Comparable k) {
		if(head==null)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		Record<S> tmp = head;
		while(!found && tmp != null){
			if(tmp.key.equals(k))
				found=true;
			else
				tmp = tmp.next;
		}
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_IN + k);
		return tmp.value;
	}
	
	@Override
	public Iterator iterator() {
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
