package list;

class Record<T> {

	T elem;
	Record<T> next;
	Record<T> prev;
	
	public Record(T elem) {
		
		this.elem = elem;
		next = prev = null;		
		
	}
}
