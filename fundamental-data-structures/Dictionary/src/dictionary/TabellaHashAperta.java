package dictionary;

import java.util.Iterator;

import dictionary.Coppia;
import dictionary.Hash;
import dictionary.Scansione;

public class TabellaHashAperta<T> implements Dizionario<T> {

	Coppia<T>[] S;
	private Hash fHash;
	private Scansione scan;
	private static Object canc = new Object();
	private int n = 0;
	
	public TabellaHashAperta(int dimArray, Hash fHash, Scansione scan) {
		
		this.S = new Coppia[dimArray];
		this.fHash = fHash;
		this.scan = scan;
		
	}
	
	@Override
	public void insert(Comparable key, T elem) {
		int pos = fHash.h(key, S.length);
		boolean inserito = false;
		int i = 0;
	
		while(!inserito && i < S.length){
			if(S[pos] == null || S[pos].elem.equals(canc)){
				S[pos] = new Coppia<T>(key, elem);
				inserito = true;
			} else {
				pos = scan.c(pos, 1, S.length);
				i++;
			}
		}
		if(!inserito)
			throw new EccezioneStrutturaPiena(Dizionario.MSG_FULL);
		n++;
	}

	@Override
	public void delete(Comparable key) {
		
		if(n == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		boolean trovato = false;
		int i = 0;
		int pos = fHash.h(key, S.length);
		
		while(!trovato && i < S.length){
			
			if(S[pos].key.equals(key))
				trovato = true;
			
			else{
				
				pos = scan.c(pos, 1, S.length);
				i++;
				
			}
			
		}
		
		if(!trovato)
			throw new EccezioneChiaveInesistente(MSG_KEY_DOESNT_EXISTS);
		
		S[pos].elem = (T)canc;
		n--;
		
	}

	@Override
	public T search(Comparable key) {
		
		if(n == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		boolean trovato = false;
		int i = 0;
		int pos = fHash.h(key, S.length);
		
		while(!trovato && i < S.length){
			
			if(S[pos] == null)
				i++;
			
			else if(S[pos].key.equals(key))
				trovato = true;
			
			else{
				
				pos = scan.c(pos, 1, S.length);
				i++;
				
			}
				
		}
		
		if(!trovato)
			throw new EccezioneChiaveInesistente(MSG_KEY_DOESNT_EXISTS);
		
		return S[pos].elem;
		
	}
	
	@Override
	public Iterator<T> iterator() {
		
		return new TabellaHashApertaIterator<T>(this);
		
	}
	
	@Override
	public String toString() {
		
		String result = "";
		Coppia<T> tmp;
		
		for(int i = 0; i < S.length; i++){
			
			tmp = S[i];
			
			if(tmp == null)
				result += "null \n";
			
			else if (tmp.elem.equals(canc))
				result += "[" + tmp.key.toString() + " - canc] \n";
			
			else
				result += "[" + tmp.key.toString() + " - " + tmp.elem.toString() + "] \n";
			
		}
		
		return result;
	}
	
}
