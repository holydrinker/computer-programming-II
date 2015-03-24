package circlist;

import java.util.Iterator;

public class ListaCircDL<T> implements CircList<T> {
	private Cella<T> head = null;
	private Direzione direzione = Direzione.forward;
	private int n = 0;
	
	class Cella<T>{
		T item;
		Cella<T> prev;
		Cella<T> next;
		
		public Cella(T item) {
			this.item = item;
			prev = next = null;
		}
	}
	
	@Override
	public void addCircList(T item) {
		Cella<T> newItem = new Cella<T>(item);
		
		if(head == null){
			head = newItem;
			head.next = newItem;
			head.prev = newItem;
		}
		else if(head.next == head){
			head.next = newItem;
			head.prev = newItem;
			newItem.next = head;
			newItem.prev = head;
		} else {
			newItem.prev = head.prev;
			newItem.next = head;
			head.prev = newItem;
			head.prev.prev.next = newItem;
		}
		n++;
	}

	@Override
	public void delCircList() {
		if(head == null)
			throw new EmptyCircListException(ExceptionMessages.EMPTY);
		
		if(head == head.next)
			head = null;
		else{
			head.prev.next = head.next;
			head.next.prev = head.prev;
			
			if(direzione == Direzione.forward)
				head = head.next;
			else
				head = head.prev;
		}
		n--;
	}

	@Override
	public T value() {
		if(head == null)
			throw new EmptyCircListException(ExceptionMessages.EMPTY);
		return (T)head.item;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public int numItem() {
		return n;
	}

	@Override
	public void setDir(Direzione d) {	
		direzione = d;
	}

	@Override
	public void ruota() {
		if(head == null)
			throw new EmptyCircListException(ExceptionMessages.EMPTY);
		if(numItem()==1)
			return;
		
		if(direzione == Direzione.forward)
			head = head.next;
		else
			head = head.prev;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int i = 0;
			Cella<T> tmp = head;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				T item = head.item;
				if(direzione == Direzione.forward)
					head = head.next;
				else
					head = head.prev;
				i++;
				return item;
			}
		};
	}
}
