package Deque;

import java.util.Iterator;

public class CodaDoppiaCollegata<T> implements CodaDoppia<T> {

	Record<T> inizio = null;
	Record<T> fine = null;
	int n = 0;
	
	@Override
	public Iterator<T> iterator() {
		
		return new CodaDoppiaCollegataIterator<T>(this);
	}

	@Override
	public void accoda(T elem) {
		
		Record<T> nuovo = new Record<T>(elem);
		
		if(dequeVuota()){
			inizio = fine = nuovo;
		}
		
		else if ( inizio == fine ){
			
			nuovo.prev = inizio;
			inizio.next = nuovo;
			fine = nuovo;
			
		}
		
		else {
			
			nuovo.prev = fine;
			fine.next = nuovo;
			fine = nuovo;
			
		}
		
		n++;
		
	}

	@Override
	public T leggiCoda() {
		
		if ( dequeVuota() )
			throw new EccezioneStrutturaVuota( CodaDoppia.MSG_EMPTY );
		
		return fine.e;
	}

	@Override
	public void fuoriCoda() {
		
		if(dequeVuota())
			throw new EccezioneStrutturaVuota(CodaDoppia.MSG_EMPTY);
		
		if(inizio.next == null)
			inizio = fine = null;
		
		fine.prev.next = null;
		fine = fine.prev;
		
		n--;
		
	}

	@Override
	public void inpila(T elem) {
		
		Record<T> nuovo = new Record<T>(elem);
		
		if(dequeVuota()){
			
			inizio = fine = nuovo;
			
		}
		
		else if( inizio == fine ){
			
			nuovo.next = inizio;
			fine.prev = inizio;
			inizio = nuovo;
	
		}
		
		else{
			
			nuovo.next = inizio;
			inizio.prev = nuovo;
			inizio = nuovo;
			
		}
		
		n++;
		
	}

	@Override
	public T leggiTesta() {
		
		if(dequeVuota())
			throw new EccezioneStrutturaVuota(CodaDoppia.MSG_EMPTY);
		
		return inizio.e;
		
	}

	@Override
	public void fuoriTesta() {
		
		if(dequeVuota())
			throw new EccezioneStrutturaVuota(CodaDoppia.MSG_EMPTY);
		
		if(inizio.next == null)
			inizio = fine = null;
		
		inizio.next.prev = null;
		inizio = inizio.next;
		
		n--;
		
	}

	@Override
	public boolean dequeVuota() {
		
		return n == 0;
		
	}
	
	public static void main(String[] args){
		
		CodaDoppia<Integer> deque = new CodaDoppiaCollegata<Integer>();
		deque.inpila(4);
		deque.inpila(3);
		deque.inpila(2);
		deque.inpila(1);
		deque.accoda(5);
		deque.accoda(6);
		deque.accoda(7);
		deque.accoda(8);
		
		deque.fuoriCoda();
		deque.fuoriCoda();
		deque.fuoriCoda();
		deque.fuoriCoda();
		deque.fuoriCoda();
		deque.fuoriCoda();deque.fuoriCoda();
		deque.fuoriCoda();deque.fuoriCoda();
		
		
		
		for(Integer x : deque){
			
			System.out.print(x.toString() + " ");
			
		}
		
	}
	
}
