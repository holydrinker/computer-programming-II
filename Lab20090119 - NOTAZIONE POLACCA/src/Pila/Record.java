package Pila;

class Record {

	Object elem;
	Record next;
	
	public Record(Object elem) {
		
		this.elem = elem;
		this.next = next;
		
	}
	
	@Override
	public String toString() {
		return this.elem.toString();
	}
	
}
