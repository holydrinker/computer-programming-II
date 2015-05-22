package list;

import java.util.Iterator;

public class WOListLinked implements ListaOrdinata {
	private Cella head = null;
	private int n = 0;
	
	@Override
	public void insert(Comparable e) {
		Cella nuova = new Cella(e); 
		
		if(numElementi() == 0)
			head = nuova;
		else{
			Cella tmp = head;
			Cella prev = null;
			int i = 0;
			boolean inserito = false;
				
			while(i < numElementi() && !inserito){
				if(nuova.item.compareTo(tmp.item) > 0){
					nuova.next = tmp;
					if(prev == null)
						head = nuova;
					else
						prev.next = nuova;
					inserito = true;
				}
				else{
					prev = tmp;
					tmp = tmp.next;
					i++;
				}
			}
			
			if(!inserito)
				prev.next = nuova;
		}
		n++;
	}

	@Override
	public int numElementi() {
		return this.n;
	}
	
	@Override
	public Iterator iterator() {
		return new Iterator(){
			Cella tmp = head;
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public Comparable next() {
				Comparable item = tmp.item;
				tmp = tmp.next;
				i++;
				return item;
			}};
	}

	private class Cella{
		Comparable item;
		Cella next;
		
		public Cella(Comparable item) {
			this.item = item;
		}
	}
	
	/*
	 * Testing my structure
	 
	public static void main(String[] args) {
		ListaOrdinata lista = new WOListLinked();
		lista.insert(2);
		lista.insert(4);
		lista.insert(1);
		lista.insert(3);
		
		for(Object c : lista)
			System.out.print(c.toString() + " ");
	}
	*/
}
