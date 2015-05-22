package dictionary;

import java.util.Iterator;

public class ArrayDoubling<T> implements Dizionario<T> {

	Coppia<T> S[] = new Coppia[1];
	private int n = 0;
	
	@Override
	public void insert(Comparable key, T elem) {
		
		if(n == S.length){
			
			Coppia<T> tmp[] = new Coppia[S.length * 2];
			
			for(int i = 0; i < n; i++){
				
				if(S[i].key.compareTo(key) == 0)
					throw new EccezioneChiavePresente(Dizionario.MSG_KEY_EXISTS);
				
				tmp[i] = S[i];
			}
			
			S = tmp;

		}
		
		S[n] = new Coppia(key, elem);
		n++;
		
	}

	@Override
	public void delete(Comparable key) {
		
		if(n == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		boolean stop = false;
		int i = 0;
		
		while(!stop && i < n){
			if(S[i].key.compareTo(key) == 0)				
				stop = true;
			else
				i++;
		}
		
		if(!stop)
			throw new EccezioneChiaveInesistente(Dizionario.MSG_KEY_DOESNT_EXISTS);
		
		for(int j = i + 1; j < n; j++)
			S[i - 1] = S[i];
		
		n--;
		
		if(n == S.length / 4){
					
			Coppia<T> tmp[] = new Coppia[S.length / 2];
					
			for(int k = 0; k < n; k++)
				tmp[k] = S[k];
					
			S = tmp;
		}
	}

	@Override
	public T search(Comparable key) {
		
		if(n == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		boolean trovato = false;
		int i = 0;
		
		while(i < n && !trovato){
			
			if(S[i].key.compareTo(key) == 0)
				trovato = true;
			else
				i++;
			
		}
		
		if(!trovato)
			throw new EccezioneChiaveInesistente(Dizionario.MSG_KEY_DOESNT_EXISTS);
		
		return S[i].elem;
		
	}

	@Override
	public String toString() {
		
		String result = "";
		
		if(n == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		for(int i = 0; i < n; i++)
			result += S[i].key.toString() + " - " + S[i].elem.toString() + "\n";
		
		return result;
		
	}

	@Override
	public Iterator<T> iterator() {
		
		return new ArrayDoublingIterator<T>(this, n);
		
	}
	
}
