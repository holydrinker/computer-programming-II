package Deque;

public class Record<T> {

	T e;
	Record<T> prev;
	Record<T> next;
	
	public Record(T e) {
	
		this.e = e;
		prev = next = null;
		
	}
	
	
}
