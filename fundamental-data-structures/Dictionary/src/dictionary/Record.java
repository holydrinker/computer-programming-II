package dictionary;


final class Record<T> {

	Comparable chiave;
	T elem;
	Record<T> prev;
	Record<T> next;
	
	public Record(Comparable chiave, T elem) {
		
		this.chiave = chiave;
		this.elem = elem;
		prev = next = null;
		
	}
	
}
