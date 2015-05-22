package dictionary;

import java.util.Iterator;

public class LinkedDict<V> implements Dictionary<V> {
	private Record<V> start = null;
	private Record<V> end = null;
	private int n = 0;
	
	class Record<V>{
		Comparable key;
		V value;
		Record<V> prev;
		Record<V> next;
		
		public Record(Comparable key, V value) {
			this.key = key;
			this.value = value;
			prev = next = null;
		}
	}
	
	@Override
	public void insert(Comparable key, V value) {
		Record<V> add = new Record<V>(key,value);
		
		if(n == 0){
			start = add;
			end = add;
		}
		else{
			boolean duplicate = false;
			Record<V> tmp = start;
			
			while(!duplicate && tmp != null){
				if(key.equals(tmp.key))
					duplicate = true;
				else
					tmp = tmp.next;
			}
			
			if(duplicate)
				throw new EntryAlreadyExistsException(ExceptionMessages.DUPLICATE);
			
			add.prev = end;
			end.next = add;
			end = add;
		}
		n++;
	}

	@Override
	public void delete(Comparable key) {
		if(n == 0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		//controllo sugli estremi
		if(key.equals(start.key)){
			
			if(start == end)
				start = end = null;
			else{
				start = start.next;
				start.prev = null;
			}
			n--;
			return;
			
		}else if(key.equals(end.key)){
			end = end.prev;
			end.next = null;
			n--;
			return;
		}
		
		//controllo su un valore intermedio	
		boolean found = false;
		Record<V> tmp = start;
		
		while(!found && tmp != null){
			if(key.equals(tmp.key))
				found = true;
			else
				tmp = tmp.next;
		}
		
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_KEY);
		
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		n--;
	}

	@Override
	public V search(Comparable key) {
		if(n == 0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		Record<V> tmp = start;
		
		while(!found && tmp != null){
			if(tmp.key.equals(key))
				found = true;
			else
				tmp = tmp.next;
		}
		
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_KEY);
		
		return tmp.value;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new Iterator<Comparable>(){
			Record<V> current = start;
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public Comparable next() {
				Comparable c = current.key;
				i++;
				current = current.next;
				return c;
			}
		};
	}
}
