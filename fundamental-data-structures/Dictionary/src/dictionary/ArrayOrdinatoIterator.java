package dictionary;

import java.util.Iterator;

public class ArrayOrdinatoIterator<T> implements Iterator<T> {

	private Coppia<T> S[];
	private int n;
	private int i = 0;
	
	public ArrayOrdinatoIterator(ArrayOrdinato<T> dizionario) {
		
		this.S = dizionario.S;
		this.n = S.length;
		
	}
	
	@Override
	public boolean hasNext() {
		
		return i < n;
		
	}

	@Override
	public T next() {
		
		T elem = S[i].elem;
		i++;
		return elem;
		
	}

}
