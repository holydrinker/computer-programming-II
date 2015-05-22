package list;

import java.util.Iterator;

public class ListDoublingIterator<T> implements Iterator<T> {

	private Object[] list;
	private int n;
	private int i = 0;
	
	public ListDoublingIterator(ListDoubling<T> listaCollegata) {
		
		this.list = listaCollegata.list;
		this.n = listaCollegata.n;
		
	}
	
	@Override
	public boolean hasNext() {
		
		return i < n;
		
	}

	@Override
	public T next() {
		
		T elem = (T)list[i];
		i++;
		return elem;
		
	}

}
