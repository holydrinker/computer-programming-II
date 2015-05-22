package dictionary;

import java.util.Iterator;

public class LinkeList<S> implements Dictionary<S> {
	Record<S> head = null;
	
	@Override
	public void insert(S e, Comparable k) {
		Record<S> ins = new Record<S>(e,k);
		
		//Controllo che il nuovo record non sia già presente nella lista di collisione
		boolean duplicate = false;
		Record<S> tmp = head;
		while(!duplicate && tmp != null){
			if(tmp.k.equals(k))
				duplicate = true;
			else
				tmp = tmp.next;
		}
		if(duplicate)
			throw new EntryAlreadyExistsException(ExceptionMessages.DUPLICATE + k);
		
		//Inserimento
		if(head == null)
			head = ins;
		else if(head.next == null){
			ins.prev = head;
			head.next = ins;
		}
		else {
			ins.prev = head;
			ins.next = head.next;
			head.next.prev = ins;
			head.next = ins;
		}
	}

	@Override
	public void delete(Comparable k) {
		if(head == null)
			throw new EmptyStructuresException(ExceptionMessages.EMPTY);
		
		//Se devi eliminare il primo, rendi il successivo al primo la nuova testa (fare attenzione a distinguere il caso in cui head sia l'unico elemento della lista. In tal caso bisogna risettare head a null
		if(head.k.equals(k)){
			if(head.next == null)
				head = null;
			else{
				head = head.next;
				head.prev = null;
			}
		}
		else{
			boolean found = false;
			Record<S> tmp = head;
			while(!found && tmp!=null){
				if(tmp.k.equals(k))
					found = true;
				else
					tmp = tmp.next;
			}
			if(!found)
				throw new EntryDoesntExistException(ExceptionMessages.NOT_IN + k);
			
			//Se devi eliminare l'ultimo, rendi l'ultimo null, in modo che il precedente diventi la nuova fine
			if(tmp.next == null)
				tmp.prev.next = null;
			//Eltrimenti se l'elemento è in mezzo, scollegalo
			else{
				tmp.prev.next = tmp.next;
				tmp.next.prev = tmp.prev;
			}
		}
	}

	@Override
	public S search(Comparable k) {
		if(head == null)
			throw new EmptyStructuresException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		Record<S> tmp = head;
		while(!found && tmp!=null){
			if(tmp.k.equals(k))
				found = true;
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
				return tmp!=null;
			}

			@Override
			public Comparable next() {
				Comparable key = tmp.k;
				tmp = tmp.next;
				return key;
			}
		};
	}
}
