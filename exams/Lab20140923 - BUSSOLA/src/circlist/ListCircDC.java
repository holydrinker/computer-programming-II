package circlist;

import java.util.Iterator;

import bussola.Cardinale;

public class ListCircDC<T> implements CircList<T> {
	Record<T> inizioLista = null;
	Record<T> fineLista = null;
	int n = 0;
	
	@Override
	public void addCircList(T item) {
		Record<T> nuovo = new Record<T>(item);
		
		if(inizioLista == null){
			nuovo.prev = nuovo;
			nuovo.next = nuovo;
			inizioLista = fineLista = nuovo;
		} else if ( inizioLista == fineLista ){
			fineLista = nuovo;
			inizioLista.prev = inizioLista.next = fineLista;
			fineLista.next = fineLista.prev = inizioLista;
		} else {
			nuovo.prev = fineLista;
			nuovo.next = inizioLista;
			fineLista.next = nuovo;
			fineLista = nuovo;
		}
		n++;
	}

	@Override
	public void delCircList() {
		if(n == 0)
			throw new EccezioneStrutturaVuota(ExceptionMessages.MSG_EMPTY);
		
		if(n == 1){
			inizioLista = null;
			fineLista = null;
			n = 0;
		} else {
			inizioLista.next.prev = fineLista;
			fineLista.next = inizioLista.next;
			inizioLista = inizioLista.next;
		}
		
		n--;
	}

	@Override
	public T value() {
		if(n == 0)
			throw new EccezioneStrutturaVuota(ExceptionMessages.MSG_EMPTY);
		return inizioLista.elem;
	}

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void ruotaAvanti() {
		if(n == 0)
			throw new EccezioneStrutturaVuota(ExceptionMessages.MSG_EMPTY);
		inizioLista = inizioLista.next;
		fineLista = inizioLista.prev;
	}

	@Override
	public void ruotaIndietro() {
		if(n == 0)
			throw new EccezioneStrutturaVuota(ExceptionMessages.MSG_EMPTY);
		fineLista = fineLista.prev;
		inizioLista = fineLista.next;
	}

	@Override
	public Integer numItem() {
		return n;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			Record<T> current = inizioLista;
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				T elem = current.elem;
				current = current.next;
				i++;
				return elem;
			}};
	}
	
	public static void main(String[] args){
		CircList<String> list = new ListCircDC<String>();
		list.addCircList("nord");
		list.addCircList("nord-est");
		list.addCircList("est");
		list.addCircList("sud-est");
		list.addCircList("sud");
		list.addCircList("sud-ovest");
		list.addCircList("ovest");
		list.addCircList("nord-ovest");
		
		for(String s : list){
			System.out.print(s + " ");
		}
	}
}
