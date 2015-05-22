package pila;

import java.util.Iterator;

public class PilaHD<T> implements Pila<T> {
	private Object[] S = new Object[1];
	private int n = 0;
	
	@Override
	public boolean isEmpty() {
		return n==0;
	}

	@Override
	public void push(T e) {
		if(n == S.length){
			Object[] tmp = new Object[S.length*2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			S = tmp;
		}

		for(int i = n; i >= 1; i--)
			S[i] = S[i - 1];
		S[0] = e;
		n++;
	}

	@Override
	public void pop() {
		if(n==0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		for(int i = 1; i < n; i++)
			S[i-1] = S[i];
		n--;
		
		if(n == S.length / 4){
			Object[] tmp = new Object[S.length / 2];
			for(int j = 0; j < n; j++)
				tmp[j] = S[j];
			S = tmp;
		}
	}

	@Override
	public T top() {
		if(n==0)
			throw new EmptyStructureException(ExceptionMessages.EMPTY);
		
		return (T)S[0];
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			private int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public T next() {
				return (T)S[i++];
			}
		};
	}
}
