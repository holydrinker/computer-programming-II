package list;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {
	Object S[] = new Object[1];
	
	@Override
	public Iterator<S> iterator() {
		return new VectorListIterator<S>(this);
	}

	@Override
	public void add(S elem) {
		S[S.length - 1] = elem;
		Object[] tmp = new Object[S.length + 1];
		
		for(int i = 0; i < S.length; i++)
			tmp[i] = S[i];
		S = tmp;
	}

	@Override
	public String toString() {
		String s = "";
		for(S nextElem : this)
			s += nextElem.toString() + " ";
		return s;
	}
}
