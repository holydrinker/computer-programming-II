package dictionary;

import java.util.Iterator;

public class ArrayOrdinato<T> implements Dictionary<T> {
	private Pair[] S = new Pair[0];
	
	class Pair<T>{
		T value;
		Comparable key;
		
		public Pair(T value, Comparable key) {
			this.value = value;
			this.key = key;
		}
	}
	
	@Override
	public void insert(T e, Comparable k) {
		//controllo non esista un duplicato
		boolean duplicate = false;
		int i = 0;
		while(!duplicate && i < S.length){
			if(S[i].key.equals(k))
				duplicate = true;
			else
				i++;
		}
		if(duplicate)
			throw new EntryAlreadyExists(ExceptionMessages.DUPLICATE);
		
		//trovo la posizione in cui inserire il nuovo elemento
		boolean foundPos = false;
		int j = 0;
		while(!foundPos && j < S.length){
			if(S[j].key.compareTo(k) > 0)
				foundPos = true;
			else
				j++;
		}
		
		//inserisco la nuova coppia
		Pair<T>[] tmp = new Pair[S.length+1]; 
		for(int x = 0; x < j; x++)
			tmp[x] = S[x];
		for(int x = j+1; x < tmp.length; x++)
			tmp[x] = S[x-1];
		tmp[j] = new Pair<T>(e,k);
		S = tmp;
	}

	@Override
	public void delete(Comparable k) {
		if(S.length == 0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		int i = 0;
		while(!found && i < S.length){
			if(S[i].key.equals(k))
				found = true;
			else
				i++;
		}
		if(!found)
			throw new EntryDoesntExist(ExceptionMessages.NOT_IN);
		
		Pair<T>[] tmp = new Pair[S.length-1];
		for(int j = 0; j < i; j++)
			tmp[j] = S[j];
		for(int j = i; j < tmp.length; j++)
			tmp[j] = S[j+1];
		S = tmp;
	}

	@Override
	public T search(Comparable k) {
		if(S.length == 0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		boolean found = false;
		int i = 0;
		while(!found && i < S.length){
			if(S[i].key.equals(k))
				found = true;
			else
				i++;
		}
		if(!found)
			throw new EntryDoesntExist(ExceptionMessages.NOT_IN);
		return (T)S[i].value;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < S.length;
			}

			@Override
			public T next() {
				return (T)S[i++].value;
			}		
		};
	}
}
