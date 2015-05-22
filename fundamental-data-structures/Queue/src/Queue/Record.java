package Queue;

class Record<T> {

	T elem;
	Record<T> next;
	
	public Record(T obj) {
		
		this.elem = obj;
		next = null;
	}
	
}
