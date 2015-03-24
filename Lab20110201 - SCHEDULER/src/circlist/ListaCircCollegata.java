package circlist;

import java.util.Iterator;

public class ListaCircCollegata<T> implements CircList<T> {
	private Record<T> head;
	private int n = 0;
	
	class Record<T>{
		T item;
		Record<T> next;
		
		public Record(T item) {
			this.item = item;
			next = null;
		}
	}
	
	public void addCircList(T item) {
		Record<T> last = new Record<T>(item);
		last.next = head;
		
		if(head == null){
			head = last;
			head.next = head;
		} else if (head.next == head) {
			head.next = last;
		} else {
			boolean found = false;
			Record<T> tmp = head;
			while(!found){
				if(tmp.next == head)
					found = true;
				else
					tmp = tmp.next;
			}
			tmp.next = last;
		}
		n++;
	}

	@Override
	public void delCircList() {
		if(isEmpty())
			throw new EmptyCircListException(ExceptionMessages.EMPTY);
		
		if(head.next == head){
			head = null;
			n--;
			return;
		}
		
		boolean found = false;
		Record<T> tmp = head;
		while(!found){
			if(tmp.next == head)
				found = true;
			else
				tmp = tmp.next;
		}
		tmp.next = head.next;
		head = head.next;
		n--;
	}

	@Override
	public T value() {
		if(isEmpty())
			throw new EmptyCircListException(ExceptionMessages.EMPTY);
		return head.item;
	}

	@Override
	public boolean isEmpty() {
		return head==null;
	}

	@Override
	public void ruotaAvanti() {
		if(isEmpty())
			throw new EmptyCircListException(ExceptionMessages.EMPTY);
		if(numItem()==1)
			return;
		head = head.next;
	}

	@Override
	public Integer numItem() {
		return n;
	}


	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int i = 0;
			Record<T> tmp = head;

			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				T item = tmp.item;
				tmp = tmp.next;
				i++;
				return item;
			}
		};
	}
	
	public static void main(String[] args) {
		CircList<String> list = new ListaCircCollegata<String>();
		list.addCircList("alpha");
		list.addCircList("beta");
		list.addCircList("gamma");
		list.addCircList("delta");
		list.addCircList("epsilon");
		list.addCircList("zeta");
		list.addCircList("eta");
		list.addCircList("theta");
		
		for(String x : list)
			System.out.print(x + " ");
		System.out.println("");
		
		list.ruotaAvanti();
		list.ruotaAvanti();
		list.delCircList();
		
		for(String x : list)
			System.out.print(x + " ");
		System.out.println("");
	}
}
