package Deque;

import java.util.Iterator;

public class CodaDoppiaCollegataIterator<T> implements Iterator<T> {

	private Record<T> current;
	private int n;
	private int i = 0;
	
	public CodaDoppiaCollegataIterator(CodaDoppiaCollegata<T> deque) {
		
		this.current = deque.inizio;
		this.n = deque.n;
		
	}
	
	@Override
	public boolean hasNext() {
	
		return i < n;
	
	}

	@Override
	public T next() {
		
		T elem = current.e;
		i++;
		current = current.next;
		return elem;
		
	}

}
