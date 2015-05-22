package list;

import java.util.Iterator;

public class ListDoubleLinkedIterator<T> implements Iterator<T> {

	private PuntatoreDouble<T> inizioLista;
	private int n;
	private int i = 0;
	
	public ListDoubleLinkedIterator(ListDoubleLinked<T> list) {
		
		this.inizioLista = list.inizioLista;
		this.n = list.n;
		
	}
	
	@Override
	public boolean hasNext() {
		
		return i < n;
		
	}

	@Override
	public T next() {
		
		T elem = inizioLista.link.elem;
		i++;
		inizioLista = inizioLista.link.next;
		return elem;
		
	}

}
