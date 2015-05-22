package Queue;

import java.util.Iterator;

public class CodaCollegata<T> implements Coda<T> {

	Record<T> inizio = null;
	private Record<T> fine = null;
	int n = 0;
	
	@Override
	public Iterator<T> iterator() {
		
		return new CodaCollegataIterator<T>(this);
	}

	@Override
	public boolean isEmpty() {
		
		return n == 0;
		
	}

	@Override
	public void enqueue(T e) {
		
		Record<T> nuovo = new Record<T>(e);
		
		if(inizio == null)
			inizio = fine = nuovo;
		
		else{
			
			fine.next = nuovo;
			fine = nuovo;
			
		}
		
		n++;
		
	}

	@Override
	public T first() {
		
		if(isEmpty())
			throw new EccezioneStrutturaVuota(Coda.MSG_EMPTY);
		
		return inizio.elem;
		
	}

	@Override
	public void dequeue() {
		
		if(isEmpty())
			throw new EccezioneStrutturaVuota(Coda.MSG_EMPTY);
		
		inizio = inizio.next;
		n--;
		
	}
	
}
