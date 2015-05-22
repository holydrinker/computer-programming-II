package list;

import java.util.Iterator;

public class ListLinkedIterator<T> implements Iterator<T> {

	private Puntatore<T> current;
	private int n;
	private int i = 0;
	
	public ListLinkedIterator(ListLinked<T> list) {
		
		this.current = list.inizioLista;
		this.n = list.n;
		
	}
	
	@Override
	public boolean hasNext() {

		return i < n;
		
	}

	@Override
	public T next() {
		
		T elem = current.link.elem;
		i++;
		current = current.link.next;
		return elem;
		
	}

}
