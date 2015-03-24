package serie;

import java.util.Iterator;

public class SerieDL<T> implements Serie<T> {
	private Elemento<T> listHead = new Elemento<T>(null);
	
	@Override
	public Posizione first() {
		if(listHead.successivo == null)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		return listHead.successivo;
	}

	@Override
	public void add(T e) {
		Elemento<T> nuovo = new Elemento<T>(e);
		
		if(listHead.successivo == null){
			nuovo.precedente = listHead;
			nuovo.successivo = listHead;
			listHead.successivo = nuovo;
			listHead.precedente = nuovo;
		}else {
			listHead.precedente.successivo = nuovo;
			listHead.precedente = nuovo;
			nuovo.precedente = listHead.precedente;
			nuovo.successivo = listHead;
		}
	}

	@Override
	public Posizione next(Posizione p) {
		if(listHead.successivo == null)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		return ((Elemento<T>)p).successivo;
	}

	@Override
	public Posizione pred(Posizione p) {
		if(listHead.successivo == null)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		return ((Elemento<T>)p).precedente;
	}

	@Override
	public boolean end(Posizione p) {
		if(listHead.successivo == null)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		return ((Elemento<T>)p) == listHead;
	}

	@Override
	public T read(Posizione p) {
		if(listHead.successivo == null)
			throw new EmptyStructureException(ExceptionMessages.MSG_EMPTY);
		return ((Elemento<T>)p).elemento;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new SerieDLIterator<T>(this);
	}

	/*
	 * Testing my structure
	 
	public static void main(String[] args) {
		Serie<Integer> s = new SerieDL<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		
		for(Integer i : s)
			System.out.println(i);
	}
	*/
	
}
