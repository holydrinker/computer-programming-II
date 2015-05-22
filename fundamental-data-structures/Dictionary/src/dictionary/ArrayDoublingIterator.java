package dictionary;

import java.util.Iterator;

public class ArrayDoublingIterator<T> implements Iterator<T> {

	private Coppia<T> S[];
	private int n;
	private int i = 0;
	
	public ArrayDoublingIterator(ArrayDoubling<T> dizionario, int dimArray) {
		
		this.S = dizionario.S;
		this.n = dimArray;
		
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
