package stack;

import java.util.Iterator;

public class PilaCollegata<T> implements Pila<T> {
	private Record<T> first = null;
	private Record<T> last = null;
	
	class Record<T>{
		T item;
		Record<T> next;
		
		public Record(T item) {
			this.item = item;
			this.next = null;		
		}
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void push(T e) {
		Record<T> lastIn = new Record<T>(e);
		
		if(first == null) {
			first = lastIn;
		} else if(last == null) {
			last = lastIn;
			first.next = last;
		} else {
			last.next = lastIn;
			last = last.next;
		}
	}

	@Override
	public T top() {
		if(isEmpty())
			throw new EmptyStackException(ExceptionMessages.EMPTY_STACK);
		if(last == null)
			return first.item;
		else
			return last.item;
	}

	@Override
	public void pop() {
		if(isEmpty())
			throw new EmptyStackException(ExceptionMessages.EMPTY_STACK);
		if(first==last){
			first = null;
			last = null;
			return;
		}
			
		Record<T> tmp = first;
		while(tmp.next != last)
			tmp = tmp.next;
		tmp.next = null;
		last = tmp;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			Record<T> tmp = first;

			@Override
			public boolean hasNext() {
				return tmp != null;
			}

			@Override
			public T next() {
				T item = tmp.item;
				tmp = tmp.next;
				return item;
			}
		};
	}
}
