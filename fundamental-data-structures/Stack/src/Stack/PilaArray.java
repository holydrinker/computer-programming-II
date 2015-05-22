package Stack;

import java.util.Iterator;

public class PilaArray<T> implements Pila<T> {

	Object[] S = new Object[1];
	int n = 0;
	
	@Override
	public boolean isEmpty() {

		return n == 0;
		
	}

	@Override
	public void push(T e) {
		
		if(n == S.length){
			
			Object[] tmp = new Object[S.length * 2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			
			S = tmp;
			
		}
		
		int i;
		
		for(i = n; i > 0; i--)
			S[i] = S[i-1];
		
		S[i] = (T)e;
		
		n++;
	}

	@Override
	public T top() {
		
		if(isEmpty())
			throw new EccezioneStrutturaVuota(Pila.MSG_EMPTY);
		
		return (T)S[0];
	}

	@Override
	public void pop() {
		
		if(isEmpty())
			throw new EccezioneStrutturaVuota(Pila.MSG_EMPTY);
		
		for(int i = 0; i < n - 1; i++)
			S[i] = S[i + 1];
		
		n--;
		
		if(n == S.length / 4){
			
			Object[] tmp = new Object[S.length / 2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			
			S = tmp;
			
		}
		
	}
	
	@Override
	public Iterator<T> iterator() {
		
		return new PilaArrayIterator<T>(this);
		
	}
	
}
