package list;

import java.util.Iterator;

public class DoubleLinkedList<S> implements AddOnlyList<S> {
	Record<S> inizioLista = null;
	Record<S> fineLista = null;
	int n = 0;
	
	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>(){
			Record<S> current = inizioLista;
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public S next() {
				S elem = current.elem;
				i++;
				current = current.next;
				return elem;
			}};
	}

	@Override
	public void add(S e) {
		Record<S> nuovo = new Record<S>(e);
		
		if(inizioLista == null){			
			inizioLista = nuovo;
			fineLista = nuovo;
		}else if(inizioLista == fineLista){
			nuovo.prev = inizioLista;
			inizioLista.next = nuovo;
			fineLista = nuovo;
		}else{
			nuovo.prev = fineLista;
			fineLista.next = nuovo;
			fineLista = nuovo;
		}
		
		n++;		
	}
	
	@Override
	public String toString() {
		String result = "";
		for(S s : this)
			result += s.toString() + " ";
		
		return result;
	}
}
