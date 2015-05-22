package Queue;

import java.util.Iterator;

public class CodaCollegataIterator<T> implements Iterator<T> {

	private Record<T> current;
	private int n;
	private int i = 0;
	
	public CodaCollegataIterator(CodaCollegata<T> queue) {
		
		this.current = queue.inizio;
		this.n = queue.n;
		
	}
	
	@Override
	public boolean hasNext() {
		
		return i < n;
		
	}

	@Override
	public T next() {
		
		T elem = current.elem;
		i++;
		current = current.next;
		return elem;
		
	}

}
