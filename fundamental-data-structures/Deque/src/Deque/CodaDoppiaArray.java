package Deque;

import java.util.Iterator;

public class CodaDoppiaArray<T> implements CodaDoppia<T> {

	Object[] S = new Object[1];
	int n = 0;
	
	@Override
	public Iterator<T> iterator() {
		
		return null;
	}

	@Override
	public void accoda(T elem) {
		
		if(n == S.length){
			
			Object[] tmp = new Object[S.length * 2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			
			S = tmp;
			
		}
		
		S[n] = elem;
		n++;
		
	}

	@Override
	public T leggiCoda() {

		if(dequeVuota())
			throw new EccezioneStrutturaVuota(CodaDoppia.MSG_EMPTY);
		
		return (T)S[n-1];
		
	}

	@Override
	public void fuoriCoda() {
		
		if(dequeVuota())
			throw new EccezioneStrutturaVuota(CodaDoppia.MSG_EMPTY);
		
		S[n-1] = null;
		n--;
		
		if(n == S.length / 4){
			
			Object[] tmp = new Object[S.length / 2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			
			S = tmp;
		}
		
	}

	@Override
	public void inpila(T elem) {
		
		for(int i = n; i > 0; i--)
			S[i] = S[i - 1];
		
		S[0] = elem;
		n++;
		
		if(n == S.length){
			
			Object[] tmp = new Object[S.length * 2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			
			S = tmp;
			
		}
		
	}

	@Override
	public T leggiTesta() {
		
		if(dequeVuota())
			throw new EccezioneStrutturaVuota(CodaDoppia.MSG_EMPTY);
		
		return (T)S[0];
		
	}

	@Override
	public void fuoriTesta() {
		
		if(dequeVuota())
			throw new EccezioneStrutturaVuota(CodaDoppia.MSG_EMPTY);
		
		for(int i = 0; i < n-1; i++)
			S[i] = S[i+1];
		
		n--;
		
		if(n == S.length / 4){
			
			Object[] tmp = new Object[S.length / 2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			
			S = tmp;
		}
		
	}

	@Override
	public boolean dequeVuota() {
		
		return n == 0;
		
	}

	@Override
	public String toString() {
		
		if(dequeVuota())
			throw new EccezioneStrutturaVuota(CodaDoppia.MSG_EMPTY);
		
		String result = "";
		
		for(int i = 0; i < n; i++)
			result += S[i].toString() + " ";
		
		return result;
		
	}
	
}
