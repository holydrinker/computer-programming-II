package list;

import java.util.Iterator;

public class ListDoubleLinked<T> implements List<T> {

	PuntatoreDouble<T> inizioLista = null;
	int n = 0;
	
	@Override
	public Iterator<T> iterator() {
		
		return new ListDoubleLinkedIterator<T>(this);
		
	}

	@Override
	public boolean isEmpty() {
		
		return n == 0;
		
	}

	@Override
	public T readList(Position p) {
		
		if(isEmpty())
			throw new EccezioneListaVuota(List.MSG_EMPTY);
		
		if(endList(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID);
		
		if(p == firstList())
			return inizioLista.link.elem;
		else
			return ((PuntatoreDouble<T>)p).link.elem;
		
	}

	@Override
	public void writeList(T elem, Position p) {
		
		if(isEmpty())
			throw new EccezioneListaVuota(List.MSG_EMPTY);
		
		if(endList(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID);
		
		if(p == firstList())
			inizioLista.link.elem = elem;
		else
			((PuntatoreDouble<T>)p).link.next.link.elem = elem;

	}

	@Override
	public Position firstList() {
		
		return null;
		
	}

	@Override
	public boolean endList(Position p) {
		
		if(isEmpty())
			return true;
		
		if(p == firstList())
			return false;
		
		else
			return ((PuntatoreDouble<T>)p).link.next == null;
		
	}

	@Override
	public Position succList(Position p) {
		
		if(isEmpty())
			throw new EccezioneListaVuota(List.MSG_EMPTY);
		
		if(endList(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID);
		
		if(p == firstList())
			return inizioLista;
		
		else
			return ((PuntatoreDouble<T>)p).link.next;
		
	}

	@Override
	public Position predList(Position p) {
		
		if(isEmpty())
			throw new EccezioneListaVuota(List.MSG_EMPTY);
		
		if(p == firstList())
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID);
		
		else
			return ((PuntatoreDouble<T>)p).link.prev;
		
	}

	@Override
	public void insList(T elem, Position p) {
		
		DoubleCell<T> cell = new DoubleCell<T> ( elem );
		PuntatoreDouble<T> pdCell;
		
		if(isEmpty()){
			
			pdCell = new PuntatoreDouble<T>(cell);
			inizioLista = pdCell;
			
		}else if(p == firstList()){
			
			cell.next = inizioLista;
			pdCell = new PuntatoreDouble<T>(cell);
			inizioLista.link.prev = pdCell;
			inizioLista = pdCell;
			
		}else{
			
			//Creo il nuovo collegamento
			cell.next = ((PuntatoreDouble<T>)p).link.next;
			cell.prev = ((PuntatoreDouble<T>)p);
			pdCell = new PuntatoreDouble<T> ( cell );
			
			//Elimino i vecchi collegamenti indirizzandoli verso la nuova cella
			((PuntatoreDouble<T>)p).link.next = pdCell;
			((PuntatoreDouble<T>)p).link.next.link.prev = pdCell;
			
		}
			
		n++;
		
	}

	@Override
	public void cancList(Position p) {
		
		if(isEmpty())
			throw new EccezioneListaVuota(List.MSG_EMPTY);
		
		if(endList(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID);
		
		if(p == firstList()){
			
			inizioLista = inizioLista.link.next;
			inizioLista.link.prev = null;
			
		}else if(endList(succList(p))){
			
			PuntatoreDouble<T> inf = (PuntatoreDouble<T>)p;
			inf.link.next = null;
			
		}else{
			
			PuntatoreDouble<T> inf = (PuntatoreDouble<T>)p;
			PuntatoreDouble<T> sup = ((PuntatoreDouble<T>)p).link.next.link.next;
			inf.link.next = sup;
			sup.link.prev = inf;
	
		}

		n--;
		
	}
	
}
