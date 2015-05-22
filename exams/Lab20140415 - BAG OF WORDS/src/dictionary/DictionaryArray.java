package dictionary;

import java.util.Iterator;

public class DictionaryArray<S> implements Dictionary<S> {
	
	private Pair<S> S[] = new Pair[1];
	private int n = 0;

	class Pair<S>{
		Comparable key;
		S value;
		
		public Pair(S value, Comparable key) {
			this.key = key;
			this.value = value;
		}
	}
	
	@Override
	public void insert(S e, Comparable k) {
		
		if(n == S.length){
			Pair<S>[] tmp = new Pair[S.length * 2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			
			S = tmp;
		}
		
		boolean duplicate = false;
		int i = 0;
		
		while(!duplicate && i < n){
			if(S[i].key.equals(k))
				duplicate = true;
			else
				i++;
		}
		
		if(duplicate)
			throw new EntryAlreadyExistsException(ExceptionMessages.DUPLICATE_KEY + k); 
			
		S[n] = new Pair<S>(e, k);
		n++;
		
	}

	@Override
	public void delete(Comparable k) {
		
		if(n == 0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY_STRUCUTRE);
		
		boolean found = false;
		int i = 0;
		
		while(!found && i < n){
			if(S[i].key.equals(k))
				found = true;
			else
				i++;
		}
		
		if(!found)
			throw new EntryDoesntExistsException(ExceptionMessages.NOT_KEY + k);
		
		for(int x = i; x < n - 1; x++)
			S[x] = S[x+1];
		
		n--;
		
		if(n == S.length / 4){
			
			Pair<S>[] tmp = new Pair[S.length / 2];
			
			for(int j = 0; j < n; j++)
				tmp[j] = S[j];
			
			S = tmp;
			
		}
		
	}

	@Override
	public S search(Comparable k) {
		
		if(n == 0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY_STRUCUTRE);
		
		boolean found = false;
		int i = 0;
		
		while(!found && i < n){
			if(S[i].key.equals(k))
				found = true;
			else
				i++;
		}
		
		if(!found)
			throw new EntryDoesntExistsException(ExceptionMessages.NOT_KEY + k);
		
		return S[i].value;
		
	}

	@Override
	public Iterator<Comparable> iterator() {
		
		return new Iterator<Comparable>(){
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public Comparable next() {
				return S[i++].key;
			}
		};	
		
	}
	
}
