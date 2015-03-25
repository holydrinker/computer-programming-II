package indexedList;

import java.util.Iterator;

public class IndexedLL<T> implements IndexedList<T> {
	private Record<T> head = null;
	private int n = 0;
	
	class Record<T>{
		T value;
		int pos;
		Record<T> prev = null;
		Record<T> next = null;
		
		public Record(T value, int pos) {
			this.value = value;
			this.pos = pos;
		}
	}

	@Override
	public boolean isEmpty(int i) {
		if(head == null)
			return true;
		
		Record<T> tmp = head;
		while(tmp != null){
			if(tmp.pos == i)
				return false;
			else
				tmp = tmp.next;
		}
		return true;
	}

	@Override
	public void addItem(T e, int i) {
		if(i < 0)
			throw new InvalidRangePosition(ExceptionMessages.POS + i);
		if(!isEmpty(i))
			throw new ItemAlreadyPresent(ExceptionMessages.DUPLICATE + e);
		
		Record<T> nuovo = new Record<T>(e,i);
		if(head==null){
			head = nuovo;
		} else if(i < head.pos){
			nuovo.next = head;
			head.prev = nuovo;
			head = nuovo;
		}else if (head.next == null){
			if(head.pos < i){
				nuovo.prev = head;
				head.next = nuovo;
			} else {
				nuovo.next = head;
				head.prev = nuovo;
				head = nuovo;
			}
		} else {
			boolean insert = false;
			Record<T> tmp = head;
			Record<T> last = null;
			while(!insert && tmp != null){
				if(i < tmp.pos)
					insert = true;
				else{
					last = tmp;
					tmp = tmp.next;
				}
			}
			
			if(!insert){
				nuovo.prev = last;
				last.next = nuovo;
			} else {
				nuovo.next = tmp;
				nuovo.prev = tmp.prev;
				tmp.prev.next = nuovo;
				tmp.prev = nuovo;		
			}
		}
		n++;
	}

	@Override
	public void delItem(int i) {
		if(isEmpty(i))
			throw new ItemNotPresents(ExceptionMessages.NOT_IN + i);

		if(head.pos == i){
			head.next.prev = null;
			head = head.next;
			n--;
			return;
		}
		
		boolean found = false;
		Record<T> tmp = head;
		while(!found){ //il secondo controllo è inutile,perchè lo troverà sicuramente altrimenti si sarebbe sollevata l'eccezione isEmpty
			if(tmp.pos == i)
				found = true;
			else
				tmp = tmp.next;
		}
		
		if(tmp.next == null)
			tmp.prev.next = null;
		else{
			tmp.prev.next = tmp.next;
			tmp.next.prev = tmp.prev;
		}
		n--;
	}

	@Override
	public T getItem(int i) {
		if(isEmpty(i))
			throw new ItemNotPresents(ExceptionMessages.NOT_IN + i);
		
		boolean found = false;
		Record<T> tmp = head;
		while(!found){
			if(tmp.pos == i)
				return tmp.value;
			else
				tmp = tmp.next;
		}
		return null;
	}

	@Override
	public int numberItems() {
		return n;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			Record<T> tmp = head;
			
			@Override
			public boolean hasNext() {
				return tmp != null;
			}

			@Override
			public T next() {
				T value = tmp.value;
				tmp = tmp.next;
				return value;
			}
		};
	}
	
	public static void main(String[] args){
		IndexedLL<String> list = new IndexedLL<String>();
		list.addItem("Peppo3", 3);
		list.addItem("Peppo2", 2);
		list.addItem("Peppo1", 1);
		list.addItem("Peppo0", 0);
	}
}
