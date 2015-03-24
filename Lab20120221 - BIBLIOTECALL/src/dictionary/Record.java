package dictionary;

class Record<S>{
	S value;
	Comparable k;
	Record<S> next;
	Record<S> prev;
	
	Record(S value, Comparable k) {
		this.value = value;
		this.k = k;
		next = null;
		prev = null;
	}
}