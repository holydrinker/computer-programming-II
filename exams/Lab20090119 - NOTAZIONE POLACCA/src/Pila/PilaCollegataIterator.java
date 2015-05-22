package Pila;
import java.util.Iterator;


class PilaCollegataIterator implements Iterator{

	private Record top;
	private Record nextElem;
	private static Record end = new Record(""); 
	
	public PilaCollegataIterator(Record top) {
		
		this.top = top;
		
	}

	@Override
	public boolean hasNext() {
	
		nextElem = top;
		
		if(top.next == null)
			top = end;
		else
			top = top.next;
		
		return nextElem != end;
		
	}

	@Override
	public Object next() {
		return nextElem;
	}
	
}
