package dictionary;

import java.util.Iterator;

import dictionary.Coppia;

public class ArrayOrdinato<T> implements Dizionario<T> {

	Coppia<T> S[] = new Coppia[0];
	
	@Override
	public void insert(Comparable key, T elem) {
		
		Coppia<T> tmp[] = new Coppia[S.length + 1];
		
		if(tmp.length == 1){
			tmp[0] = new Coppia(key, elem);
			S = tmp;
			return;
		}
		
		boolean inserito = false;
		int i = 0;
		
		while( i < S.length && !inserito){
			
			if(S[i].key.compareTo(key) == 0)
				throw new EccezioneChiavePresente(Dizionario.MSG_KEY_EXISTS);
			
			if(key.compareTo(S[i].key) < 0){
				
				tmp[i] = new Coppia(key, elem);
				inserito = true;
				
			}
			else
				tmp[i] = S[i];
			
			i++;
			
		}
		
		if(!inserito)
			tmp[i] = new Coppia(key, elem);
		
		else{
			
			while(i < tmp.length){
				tmp[i] = S[i - 1];
				i++;
			}
			
		}
		
		S = tmp;
		
	}

	@Override
	public void delete(Comparable key) {
		
		if(S.length == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		Coppia<T> tmp[] = new Coppia[S.length - 1];
		
		int stopIdx = 0;
		boolean trovato = false;
		
		while(stopIdx < S.length && !trovato){
			
			if(S[stopIdx].key.compareTo(key) == 0)
				trovato = true;
			else
				stopIdx++;
			
		}
		
		if(!trovato)
			throw new EccezioneChiaveInesistente(Dizionario.MSG_KEY_DOESNT_EXISTS);
		
		for(int i = 0; i < stopIdx; i++)
			tmp[i] = S[i];
		
		for(int i = stopIdx; i < tmp.length; i++)
			tmp[i] = S[i + 1];
		
		S = tmp;
		
	}

	@Override
	public T search(Comparable key) {
		
		if(S.length == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		boolean trovato = false;
		int inf = 0;
		int sup = S.length - 1;
		int mid = (inf + sup) / 2;
		
		while(!trovato && inf <= sup){
			
			mid = (inf + sup) / 2;
			
			if(key.compareTo(S[mid].key) == 0)
				trovato = true;
			
			else if (S[mid].key.compareTo(key) < 0)
				inf = mid + 1;
			
			else
				sup = mid - 1;
			
		}
		
		if(!trovato)
			throw new EccezioneChiaveInesistente("Chiave non presente in rubrica. Impossibile effettuare la ricerca.");
		
		return S[mid].elem;
	}

	@Override
	public String toString() {
		
		String result = "";
		
		for(int i = 0; i < S.length; i++)
			result += (S[i].key.toString() + " - " + S[i].elem.toString() + "\n");
		
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new ArrayOrdinatoIterator<T>(this);
		
	}

	public static void main(String[] args){
		
		Dizionario<Integer> d = new ArrayOrdinato<Integer>();
		d.insert("Peppo2", 2);
		d.delete("Peppo1");
		
	}
	
}
