package list;

import java.util.Iterator;

public class ListLinked<T> implements List<T> {

	Puntatore<T> inizioLista = null;
	int n = 0;
	
	@Override
	public Iterator<T> iterator() {
		
		return new ListLinkedIterator<T>(this);
		
	}

	@Override
	public boolean isEmpty() {

		return n == 0;
		
	}

	@Override
	public T readList(Position p) {
		
		if(isEmpty())
			throw new EccezioneListaVuota(List.MSG_EMPTY);
		
		if(p == firstList())
			return inizioLista.link.elem;
			
		return (T) ((Puntatore)p).link.next.link.elem;
		
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
			((Puntatore<T>)p).link.next.link.elem = elem;

	}

	@Override
	public Position firstList() {
		
		return null;
		
	}

	@Override
	public boolean endList(Position p) {
		
		if(isEmpty())
			return true;
		
		if( p == firstList() )
			return false;
		
		else
			return ((Puntatore<T>)p).link.next == null;
		
	}

	@Override
	public Position succList(Position p) {
		
		if(isEmpty())
			throw new EccezioneListaVuota(List.MSG_EMPTY);
		
		if(endList(p))
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID);
		
		if(p == firstList())
			return (Position)inizioLista;
		
		return ((Puntatore<T>)p).link.next;
		
	}

	@Override
	public Position predList(Position p) {
	
		if(isEmpty())
			throw new EccezioneListaVuota(List.MSG_EMPTY);
		if(p == firstList())
			throw new IndexOutOfBoundsException(List.MSG_POS_NOT_VALID);
		
		Puntatore<T> tmp = inizioLista;
		
		while(!(tmp.link.next == p))
			tmp = tmp.link.next;
		
		return (Position) tmp;
	}

	@Override
	public void insList(T elem, Position p) {
		
		Cella<T> nuovaCella = new Cella<T>(elem);
		
		if(isEmpty()){
			
			inizioLista = new Puntatore<T>(nuovaCella);
			
		}
		
		else{
		
			if(p == firstList()){
				
				nuovaCella.next = inizioLista;
				inizioLista = new Puntatore<T>(nuovaCella);
				
			}else{
				
				nuovaCella.next = ((Puntatore<T>)p).link.next;
				((Puntatore<T>)p).link.next = new Puntatore<T>(nuovaCella);
				
			}
			
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
		
		}else{
			
			/*
			 * Prendo la cella corrispondende alla posizione passata per parametro.
			 * Salvo in una variabile, per maggior chiarezza, chi diventerà l'elemento successivo alla cella a cui stiamo facendo riferimento.
			 */
			Puntatore<T> current = ((Puntatore<T>)p);
			Puntatore<T> nextCurrent = current.link.next.link.next;
			
			/*
			 * Facendo due volte .link.next ho praticamente saltato una cella, cioè quella che voglio eliminare.
			 * Collego la cella a cui sto facendo riferimento con il puntatore salvato nella nuova variabile.
			 * Così facendo ho eliminato il collegamento intermedio con la cella che volevo eliminare,
			 * che ovviamente resterà in memoria ma che il garbage collector rimuoverà dallo stack.
			 */
			current.link.next = nextCurrent;
			
		}
		
		n--;
	
	}

	public static void main(String[] args){
		
		List<Integer> list = new ListLinked<Integer>();
		list.insList(3, list.firstList());
		list.insList(2, list.firstList());
		list.insList(1, list.firstList());
		
		for(Integer x : list){
			
			System.out.print(x.toString() + " ");
			
		}
		
	}
	
}
