package Pila;
import Eccezioni.EccezioneStrutturaVuota;


public class PilaCollegata implements Pila {

	private Record top = null;
	private static final String MSG_EMPTY  = "Una delle operazioni non è lecita. Causa: Struttura vuota";
	private static final int USELESS_CHAR = 3;
	
	@Override
	public void push(Object e) {
		
		Record nuovo = new Record(e);
		
		if(top == null)
			top = nuovo;
		
		else{
			nuovo.next = top;
			top = nuovo;
		}

	}

	@Override
	public void pop() {
		
		if(top == null)
			throw new EccezioneStrutturaVuota(MSG_EMPTY);
		
		if(top.next == null)
			top = null;
		else
			top = top.next;

	}

	@Override
	public Object top() {
		return top.elem;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public String toString() {
		
		if(top == null)
			throw new EccezioneStrutturaVuota(MSG_EMPTY);
		
		PilaCollegataIterator iterator = new PilaCollegataIterator(top);
		String res = "";
		
		while(iterator.hasNext()){
			
			Record next = (Record)iterator.next();
			
			if(next == null)
				res += "null - ";
			else
				res += next.elem.toString() + " - ";
			
		}
		
		res = res.substring(0, res.length() - USELESS_CHAR);
		return res;
	}
	
}
