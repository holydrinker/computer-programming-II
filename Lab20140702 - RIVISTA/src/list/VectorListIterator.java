package list;

import java.util.Iterator;

public class VectorListIterator<S> implements Iterator<S> {
	private Object[] S;
	private int n;
	private int i = 0;
	
	public VectorListIterator(VectorList<S> list) {
		this.S = list.S;
		this.n = S.length - 1;
	}
	
	@Override
	public boolean hasNext() {
		return i < n;
	}

	@Override
	public S next() {
		S elem = (S)S[i];
		i++;
		return elem;
	}
}
