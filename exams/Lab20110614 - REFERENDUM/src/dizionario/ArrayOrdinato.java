package dizionario;

import java.util.Iterator;

public class ArrayOrdinato<S> implements Dictionary<S> {

	Coppia<S>[] S = new Coppia[0];
	
	@Override
	public Iterator<S> iterator() {
		
		return new ArrayOrdinatoIterator<S>(this);
		
	}

	@Override
	public void insert(S e, Comparable k) {
		
		boolean trovato = false;
		int i = 0;
		
		while(!trovato && i < S.length){
			
			if(S[i].key.compareTo(k) >= 0)
				trovato = true;
			else
				i++;
			
		}
		
		Coppia<S> tmp[] = new Coppia[S.length + 1];
		
		for(int j = 0; j < i; j++)
			tmp[j] = S[j];
		
		tmp[i] = new Coppia(e,k);
		
		for(int y = i; y < S.length; y++)
			tmp[y + 1] = S[y];
	
		S = tmp;

	}

	@Override
	public void delete(Comparable k) {
		
		if(S.length == 0)
			throw new EccezioneStrutturaVuota(MSG_EMPTY);
		
		boolean trovato = false;
		int i = 0;
		
		while(!trovato && i < S.length){
			
			if(S[i].key.compareTo(k) == 0)
				trovato = true;
			else
				i++;
			
		}

		if(!trovato)
			throw new EccezioneChiaveInesistente(MSG_DOESNT_EXISTS);
		
		Coppia<S> tmp[] = new Coppia[S.length - 1];
		
		for(int j = 0; j < i; j++)
			tmp[j] = S[j];
		
		for(int y = i; y < tmp.length; y++)
			tmp[y] = S[y+1];
		
		S = tmp;
		
	}

	@Override
	public S search(Comparable k) {
		
		if(S.length == 0)
			throw new EccezioneStrutturaVuota(MSG_EMPTY);
		
		boolean trovato = false;
		int inf = 0;
		int sup = S.length - 1;
		int mid = -1;
		
		while(!trovato && inf <= sup){
			
			mid = (inf + sup) / 2;
			
			if(S[mid].key.compareTo(k) == 0)
				trovato = true;
			
			else if(S[mid].key.compareTo(k) > 0)
				sup = mid - 1;
			
			else
				inf = mid + 1;
			
		}

		if(!trovato)
			throw new EccezioneChiaveInesistente(MSG_DOESNT_EXISTS);
		
		return S[mid].elem;
		
	}
	
}
