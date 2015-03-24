package serie;

import java.util.Iterator;

public class SerieDLIterator<T> implements Iterator<T> {
	private SerieDL<T> s;
	private Posizione tmp;
	
	public SerieDLIterator(SerieDL<T> s) {
		this.s = s;
		this.tmp = s.first();
	}
	
	@Override
	public boolean hasNext() {
		return !s.end(tmp);
	}

	@Override
	public T next() {
		T item = s.read(tmp);
		tmp = s.next(tmp);
		return item;
	}
}
