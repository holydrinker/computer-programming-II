package dictionary;

import java.util.Iterator;

public class TabellaHashApertaIterator<T> implements Iterator<T> {

	private Coppia<T>[] S;
	private int n;
	private int i = 0;
	
	public TabellaHashApertaIterator(TabellaHashAperta<T> dizionario) {
		
		this.S = dizionario.S;
		this.n = S.length;
		
	}
	
	@Override
	public boolean hasNext() {
		
		return i < n;
		
	}

	@Override
	public T next() {
		
		if(S[i] == null){
			
			i++;
			return null;
			
		}
		
		T elem = S[i].elem;
		i++;
		return elem;
		
	}

}
