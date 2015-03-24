package priorityQueue;
import java.util.Iterator;


public class PQA<T> implements PQ<T> {
	protected Record<T> queue = null;
	private int n = 0;
	
	class Record<T>{
		T item;
		int priority;
		Record<T> next;
		
		public Record(T item, int priority) {
			this.item = item;
			this.priority = priority;
		}
	}

	@Override
	public boolean isNew() {
		return n==0;
	}

	@Override
	public void insert(T value, int priority) {
		if(priority < 0 || priority > 100)
			throw new PriorityOutOfRangeException(ExceptionMessages.MSG_OUT);
		
		Record<T> newItem = new Record<T>(value, priority);
		
		if(queue == null)
			queue = newItem;
		else if(priority < queue.priority){
			newItem.next = queue;
			queue = newItem;
		}
		else{
			boolean inserted = false;
			Record<T> tmp = queue.next;
			Record<T> prev = queue;
			
			while(!inserted && tmp != null){
				if(priority < tmp.priority){
					newItem.next = tmp;
					prev.next = newItem;
					inserted = true;
				}else if(priority == tmp.priority){
					newItem.next = tmp.next;
					tmp.next = newItem;
					inserted = true;
				}else{
					prev = tmp;
					tmp = tmp.next;
				}		
			}
			if(!inserted)
				prev.next = newItem;
		}
		n++;
	}

	@Override
	public T first() {
		return queue.item;
	}

	@Override
	public void delFirst() {
		if(n==0)
			throw new EmptyQueueException(ExceptionMessages.MSG_EMPTY);
		
		Record<T> min = queue;
		Record<T> prevMin = queue;
		Record<T> prev = queue;
		Record<T> tmp = queue;
		
		while(tmp != null){
			if(tmp.priority < min.priority){
				min = tmp;
				prevMin = prev;
			}
			else{
				prev = tmp;
				tmp = tmp.next;
			}
		}
		
		if(min == queue)
			queue = queue.next;
		else
			prevMin.next = min.next;
		n--;
	}

	@Override
	public void changePriority(T value, int proprity) {
		if(n==0)
			throw new EmptyQueueException(ExceptionMessages.MSG_EMPTY);
		
		boolean found = false;
		Record<T> tmp = queue;
		
		while(!found && tmp != null){
			
			if(tmp.item.equals(value)){
				tmp.priority = proprity;
				found = true;
			}else
				tmp = tmp.next;
		}

		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.MSG_DOESNT_EXIST);
		
	}

	@Override
	public int getPriority(T value) {
		if(n==0)
			throw new EmptyQueueException(ExceptionMessages.MSG_EMPTY);
		
		boolean found = false;
		Record<T> tmp = queue;
		
		while(!found && tmp != null){			
			if(tmp.item.equals(value))
				found = true;
			else
				tmp = tmp.next;
		}

		if(!found)
			throw new EntryDoesntExistException(ExceptionMessages.MSG_DOESNT_EXIST);
		
		return tmp.priority;
	}

	@Override
	public int size() {
		return n;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int i = 0;
			Record<T> current = queue;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				T item = current.item;
				current = current.next;
				i++;
				return item;
			}
		};
	}
	
	public static void main(String[] args){
		PQ<String> queue = new PQA<String>();
		queue.insert("Sport", 5);
		queue.insert("ComputerScience", 1);
		queue.insert("Juggling", 10);
		queue.insert("Reading", 70);
		queue.insert("Music", 10);
	}
}
