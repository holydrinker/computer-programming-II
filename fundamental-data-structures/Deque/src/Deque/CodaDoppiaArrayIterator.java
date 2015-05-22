package Deque;

import java.util.Iterator;

public class CodaDoppiaArrayIterator<T> implements Iterator<T> {

	private Object S[];
	private int n;
	private int i = 0;
	
	public CodaDoppiaArrayIterator(CodaDoppiaArray<T> deque) {
		
		this.S = deque.S;
		this.n = deque.n;
		
	}
	
	@Override
	public boolean hasNext() {
		
		return i < n;
		
	}

	@Override
	public T next() {
		
		T elem = (T)S[i];
		i++;
		return elem;
		
	}

}
