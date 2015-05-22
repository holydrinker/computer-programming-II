package circlist;

class Record<T> {
	T elem;
	Record<T> prev;
	Record<T> next;
	
	Record(T elem) {
		this.elem = elem;
		prev = next = null;
	}
}
