package dictionary;

import java.util.Iterator;

import dictionary.Hash;
import dictionary.Record;

public class TabellaHashLinkedList<T> implements Dizionario<T> {

	StrutturaCollegata<T> S[];
	private Hash hFun;
	int n = 0;
	
	public TabellaHashLinkedList(int dimArray, Hash hFun) {
		
		this.S = new StrutturaCollegata[dimArray];
		this.hFun = hFun;
		
	}
	
	@Override
	public void insert(Comparable key, T elem) {
		
		int pos = hFun.h(key, S.length);
		
		if(S[pos] == null)
			S[pos] = new StrutturaCollegata<T>();
		
		S[pos].insert(key, elem);
		n++;
		
	}

	@Override
	public void delete(Comparable key) {
		
		if(n == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		int pos = hFun.h(key, S.length);
		
		if(S[pos] == null)
			throw new EccezioneChiaveInesistente(Dizionario.MSG_KEY_DOESNT_EXISTS);
		
		S[pos].delete(key);
		n--;
		
	}

	@Override
	public T search(Comparable key) {
		
		if(n == 0)
			throw new EccezioneDizionarioVuoto(Dizionario.MSG_EMPTY);
		
		int pos = hFun.h(key, S.length);
		
		if(S[pos] == null)
			throw new EccezioneChiaveInesistente(Dizionario.MSG_KEY_DOESNT_EXISTS);
		
		return S[pos].search(key);
		
	}

	@Override
	public Iterator<T> iterator() {
		
		return new TabellaHashLinkedListIterator<T>(this);
	}
	
	public static void main(String[] args){
		
		int dimArray = 5;
		Hash fHash = new HashDivisione();
		
		Dizionario<Integer> tab = new TabellaHashLinkedList<Integer>(dimArray, fHash);
		tab.insert("Peppo1", 1);
		tab.insert("Peppo2", 2);
		tab.insert("Peppo3", 3);
		tab.insert("Peppo4", 4);
		tab.insert("Peppo5", 5);
		tab.insert("Peppo6", 6);
		tab.insert("Peppo7", 7);
		
		for(Integer x : tab)
			System.out.println(x.toString());
		
	}
	
}
