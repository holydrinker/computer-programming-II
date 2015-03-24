package dictionary;

import java.util.Iterator;

public class LinkedDict<K, V> implements Dictionary<K, V> {

	private Record<K,V> head = null;
	
	class Record<K, V>{
		K key;
		V value;
		Record<K,V> next;
		Record<K,V> prev;
		
		public Record(K key, V value) {
			this.key = key;
			this.value = value;
			prev = next = null;
		}
	}
	
	@Override
	public void insert(K key, V value) {
		Record<K,V> nuovo = new Record<K,V>(key,value);
		
		if(head==null)
			head = nuovo;		
		else {
			boolean duplicato = false;
			Record<K,V> tmp = head;
			
			while(!duplicato && tmp != null){
				if(tmp.key.equals(key))
					duplicato = true;
				else
					tmp = tmp.next;
			}
			
			if(duplicato)
				throw new EntryAlreadyExists(ExceptionMessages.DUPLICATE + key.toString());
			
			if(head.next != null){
				nuovo.next = head.next;
				head.next.prev = nuovo;
			}
			head.next = nuovo;
			nuovo.prev = head;
		}
	}

	@Override
	public void delete(K key) {
		if(head == null)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		boolean found = false;
		Record<K,V> tmp = head;
		
		while(!found && tmp != null){
			if(tmp.key.equals(key))
				found = true;
			else
				tmp = tmp.next;
		}
		
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_KEY + key.toString());
		
		//rimozione
		if(tmp == head){
			if(head.next == null)
				head = null;
			else{
				head = head.next;
				head.prev = null;
			}
		}
		else if(tmp.next == null)
			tmp.prev.next = null;
		else{
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
		}
	}

	@Override
	public V search(K key) {
		if(head == null)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		boolean found = false;
		Record<K,V> tmp = head;
		
		while(!found && tmp != null){
			if(tmp.key.equals(key))
				found = true;
			else
				tmp = tmp.next;
		}
		
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_KEY + key.toString());
		return tmp.value;
	}
	
	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>(){
			Record<K,V> current = head;
			
			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public K next() {
				K key = current.key;
				current = current.next;
				return key;
			}
		};
	}
}
