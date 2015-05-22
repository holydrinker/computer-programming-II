package List;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {
	private Puntatore<T> inizioLista = null;
	
	@Override
	public boolean isEmpty() {
		return inizioLista == null;
	}

	@Override
	public T readList(Position<T> p) {
		if(isEmpty())
			throw new EmptyStructureException(MessagesException.EMPTY);
		
		if(p == firstList())
			return (T)inizioLista.link.elem;
		else if(endList(p))
			throw new IndexOutOfBoundsException(MessagesException.INDEX_NOT_VALID);
		
		Puntatore<T> pos = (Puntatore<T>) p;
		return (T)pos.link.next.link.elem;
	}

	@Override
	public void writeList(T elem, Position<T> p) {
		if(isEmpty())
			throw new EmptyStructureException(MessagesException.EMPTY);
		
		if(p == firstList())
			inizioLista.link.elem = elem;
		else if(endList(p))
			throw new IndexOutOfBoundsException(MessagesException.INDEX_NOT_VALID);
		else{
			Puntatore<T> pos = (Puntatore<T>) p;
			pos.link.next.link.elem = elem;
		}
	}

	@Override
	public Position<T> firstList() {
		return null;
	}

	@Override
	public boolean endList(Position<T> p) {
		if(isEmpty())
			return true;
		if(p == firstList())
			return false;
		
		Puntatore<T> pos = (Puntatore<T>) p;
		return pos.link.next == null;
	}

	@Override
	public Position<T> succList(Position<T> p) {
		if(isEmpty())
			throw new EmptyStructureException(MessagesException.EMPTY);
		
		if(firstList() == p)
			return inizioLista;
		else if(endList(p))
			throw new IndexOutOfBoundsException(MessagesException.INDEX_NOT_VALID);
		else{
		Puntatore<T> pos = (Puntatore<T>) p;
			return pos.link.next;
		}
	}

	@Override
	public Position<T> predList(Position<T> p) {
		if(isEmpty())
			throw new EmptyStructureException(MessagesException.EMPTY);
		
		if(firstList() == p)
			throw new IndexOutOfBoundsException(MessagesException.INDEX_NOT_VALID);
		if(p == inizioLista)
			return null;
		
		Puntatore<T> tmp = inizioLista;
		while(tmp != p)
			tmp = tmp.link.next;
		return tmp;
	}

	@Override
	public void insList(T elem, Position<T> p) {
		Puntatore<T> nuovo = new Puntatore<T>(new Cella<T>(elem));
		
		if(isEmpty())
			inizioLista = nuovo;
		else if(p == firstList()){
			nuovo.link.next = inizioLista;
			inizioLista = nuovo;
		}
		else if(endList(p)){
			Puntatore<T> pos = (Puntatore<T>) p;
			Puntatore<T> last = pos.link.next;
			last.link.next = nuovo;
		}
		else{
			Puntatore<T> pos = (Puntatore<T>) p;
			Puntatore<T> pred = pos.link.next;
			Puntatore<T> succ = pred.link.next;
			pred.link.next = nuovo;
			nuovo.link.next = succ;
		}	
	}

	@Override
	public void cancList(Position<T> p) {
		if(isEmpty())
			throw new EmptyStructureException(MessagesException.EMPTY);
		
		if(p == firstList())
			inizioLista = inizioLista.link.next;
		else if(endList(p)){
			Puntatore<T> pos = (Puntatore<T>) p;
			pos.link.next = null;
		}
		else{
			Puntatore<T> pos = (Puntatore<T>) p;
			pos.link.next = pos.link.next.link.next;
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			Position<T> tmp = firstList();
			
			@Override
			public boolean hasNext() {
				return !endList(tmp);
			}

			@Override
			public T next() {
				T item = readList(tmp);
				tmp = succList(tmp);
				return item;
			}};
	}


	/* Testing my structure 
	public static void main(String[] args) {
		List<Integer> lista = new LinkedList<Integer>();
		lista.insList(4, lista.firstList());
		lista.insList(3, lista.firstList());
		lista.insList(2, lista.firstList());
		lista.insList(1, lista.firstList());
		
		for(Integer item : lista)
			System.out.print(item.toString() + " ");
	}
	*/
	
}
