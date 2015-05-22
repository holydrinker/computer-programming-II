package list;

class DoubleCell<T> {

	T elem;
	PuntatoreDouble<T> prev;
	PuntatoreDouble<T> next;
	
	DoubleCell() {
		
		prev = next = null;
		
	}
	
	DoubleCell(T elem) {
		
		this.elem = elem;
		prev = next = null;	
		
	}
	
}
