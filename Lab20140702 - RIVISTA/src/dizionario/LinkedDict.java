package dizionario;

import java.util.Iterator;

public class LinkedDict<K, V> implements Dictionary<K, V> {
	Record<K,V> start = null;
	Record<K,V> end = null;
	int n = 0;

	private class Record<K, V> {
		K key;
		V elem;
		Record<K,V> next = null;
		Record<K,V> prev = null;
		
		Record(K key, V elem) {
			this.key = key;
			this.elem = elem;
		}
	}
	
	@Override
	public void insert(K key, V value) {
		boolean found = false;
		Record<K,V> tmp = start;
		
		while(!found && tmp != null){
			if(tmp.key.equals(key))
				found = true;
			else
				tmp = tmp.next;
		}
		if(found)
			throw new KeyAlreadyExistsException(ExceptionMessages.MSG_DUPLICATA);
		
		Record<K,V> rec = new Record<K,V>(key, value);
		if(start == null){
			start = rec;
			end = rec;
		} else {
			rec.prev = end;
			end.next = rec;
			end = rec;
		}
		n++;
	}

	@Override
	public void delete(K key) {
		if(n == 0)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		boolean found = false;
		Record<K,V> tmp = start;
		
		while(!found && tmp != null){
			if(tmp.key.equals(key))
				found = true;
			else
				tmp = tmp.next;
		}
		if(!found)
			throw new KeyDoesntExistException(ExceptionMessages.MSG_INESISTENTE);
		
		if(tmp == start){
			if(tmp == end)
				start = end = null;
			else{
				start = start.next;
				start.prev = null;
			}
		} else if (tmp == end) {
			end = end.prev;
			end.next = null;
		} else {
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
			tmp.next = null;
			tmp.prev = null;
		}
		n--;
	}

	@Override
	public V search(K key) {
		if(n == 0)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		boolean found = false;
		Record<K,V> tmp = start;
		
		while(!found && tmp != null){	
			if(tmp.key.equals(key))
				found = true;
			else
				tmp = tmp.next;
		}
		if(!found)
			throw new KeyDoesntExistException(ExceptionMessages.MSG_INESISTENTE);
		return tmp.elem;		
	}
	
	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>(){
			Record<K,V> current = start;
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public K next() {
				K chiave = current.key;
				i++;
				current = current.next;
				return chiave;
			}};
	}
}
