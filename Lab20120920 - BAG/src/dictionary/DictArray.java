package dictionary;

import java.util.Iterator;

public class DictArray<K, V> implements Dictionary<K, V> {
	private Pair<K,V>[] S = new Pair[1];
	private int n = 0;
	
	class Pair<K,V>{
		K key;
		V value;
		
		public Pair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	@Override
	public void insert(K key, V value) {
		if(n==S.length){
			Pair<K,V>[] tmp = new Pair[S.length*2];
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			S = tmp;
		}
		
		boolean duplicate = false;
		int i = 0;
		while(!duplicate && i < n){
			if(S[i].key.equals(key))
				duplicate = true;
			else
				i++;
		}
		
		if(duplicate)
			throw new EntryAlreadyExists(ExceptionMessages.DUPLICATE + key.toString());
		S[n] = new Pair<K,V>(key, value);
		n++;
	}

	@Override
	public void delete(K key) {
		if(n==0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		int i = 0;
		while(!found && i < n){
			if(S[i].key.equals(key))
				found = true;
			else
				i++;
		}
		
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_IN + key.toString());
		
		for(int j = i+1; j < n; j++)
			S[j-1] = S[j];
		n--;
	}

	@Override
	public V search(K key) {
		if(n==0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		int i = 0;
		while(!found && i < n){
			if(S[i].key.equals(key))
				found = true;
			else
				i++;
		}
		
		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.NOT_IN + key.toString());
		return S[i].value;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < n; i++)
			s += "[" + S[i].key.toString() + ": " + S[i].value.toString() + "] ";
		return s;
	}
	
	@Override
	public Iterator<K> iterator() {
		return new Iterator<K>(){
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public K next() {
				return S[i++].key;
			}
		};
	}
}
