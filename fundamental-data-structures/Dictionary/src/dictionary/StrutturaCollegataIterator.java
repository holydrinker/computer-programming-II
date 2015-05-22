package dictionary;

import java.util.Iterator;

public class StrutturaCollegataIterator<T> implements Iterator<T> {

	private Record<T> list;
	private int n;
	private int i = 0;;
	
	public StrutturaCollegataIterator(StrutturaCollegata<T> dizionario) {
		
		this.list = dizionario.list;
		this.n = dizionario.n;
	}
	
	@Override
	public boolean hasNext() {
		
		return i < n;
		
	}

	@Override
	public T next() {

		T tmp = list.elem;
		list = list.next;
		i++;
		return tmp;
		
	}

}
