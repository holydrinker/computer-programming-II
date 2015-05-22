package dictionary;

import java.util.Iterator;

public class ArrayDict<K, V> implements Dictionary<K, V> {

	Pair<K,V> S[] = new Pair[1];
	int n = 0;
	
	private class Pair<K, V> {
		K key;
		V item;
		
		public Pair(K key, V item) {
			this.key = key;
			this.item = item;
		}
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
				K key = S[i].key;
				i++;
				return key;
			}
		};
	}

	@Override
	public void insert(K key, V value) {
		boolean duplicate = false;
		int j = 0;
		
		while(!duplicate && j < n){
			if(S[j].key.equals(key))
				duplicate = true;
			else
				j++;
		}
		if(duplicate)
			throw new KeyAlreadyExistsException(ExceptionMessages.MSG_DUPLICATE);
		
		if(n == S.length){	
			Pair<K,V> tmp[] = new Pair[S.length * 2];
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			S = tmp;
		}
		
		S[n] = new Pair<K,V>(key, value);
		n++;
	}

	@Override
	public void delete(K key) {
		if(n == 0)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		boolean found = false;
		int j = 0;		
		while(!found && j < n){
			if(S[j].key.equals(key))
				found = true;
			else
				j++;
		}
		if(!found)
			throw new KeyDoesntExistException(ExceptionMessages.MSG_DOESNT_EXISTS);
	
		for(int i = j; i < n - 1; i++)
			S[i] = S[i+1];		
		n--;
		
		if(n < S.length / 4){	
			Pair<K,V> tmp[] = new Pair[S.length / 2];
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			S = tmp;
		}
	}

	@Override
	public V search(K key) {
		if(n == 0)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		
		boolean found = false;
		int i = 0;
		while(!found && i < n){
			if(S[i].key.equals(key))
				found = true;
			else
				i++;
		}		
		if(!found)
			throw new KeyDoesntExistException(ExceptionMessages.MSG_DOESNT_EXISTS);
		return (V) S[i].item;
	}
}
