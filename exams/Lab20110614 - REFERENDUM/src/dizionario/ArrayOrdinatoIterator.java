package dizionario;

import java.util.Iterator;

public class ArrayOrdinatoIterator<E> implements Iterator<E> {

	private Coppia<E> S[];
	private int n;
	private int i = 0;
	
	public ArrayOrdinatoIterator(ArrayOrdinato<E> dizionario) {
		
		this.S = dizionario.S;
		this.n = S.length;
		
	}
	
	@Override
	public boolean hasNext() {
		
		return i < n;
	}

	@Override
	public E next() {
		
		E elem = S[i].elem;
		i++;
		return elem;
		
	}

}
