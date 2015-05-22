package Stack;

import java.util.Iterator;

public class PilaArrayIterator<T> implements Iterator<T> {

	private Object[] S;
	private int n;
	private int i = 0;
	
	public PilaArrayIterator(PilaArray<T> queue) {

		this.S = queue.S;
		this.n = queue.n;
		
	}
	
	@Override
	public boolean hasNext() {

		return i < n;
		
	}

	@Override
	public T next() {
		
		T elem = (T)S[+i];
		i++;
		return elem;
		
	}

}
