package dictionary;

import java.util.Iterator;

public class TabellaHashLL<S> implements Dictionary<S> {
	LinkeList<S> elementi[];
	Iterator<S> listCollIter;
	Hash f;
	
	public TabellaHashLL(int n, Hash f) {
		this.elementi = new LinkeList[n];
		for(int i = 0; i < elementi.length; i++)
			elementi[i] = new LinkeList<S>();
		this.f = f;
	}
	
	@Override
	public void insert(S e, Comparable k) {
		int pos = f.h(k, elementi.length);
		elementi[pos].insert(e, k);
	}

	@Override
	public void delete(Comparable k) {
		int pos = f.h(k, elementi.length);
		elementi[pos].delete(k);
	}

	@Override
	public S search(Comparable k) {
		int pos = f.h(k, elementi.length);
		return elementi[pos].search(k);
	}
	
	@Override
	public Iterator<S> iterator() {
		return new TabellaHashLLIterator(this);
	}

	public static void main(String[] args) {
		Dictionary<String> tab = new TabellaHashLL<String>(4, new HashDivisione());
		tab.insert("A1", "A1");
		tab.insert("A2", "A2");
		tab.insert("D1", "D1");
		tab.insert("B1", "B1");
		tab.insert("C1", "C1");
		tab.insert("D2", "D2");
		tab.insert("D3", "D3");
		tab.insert("B2", "B2");
	
		for(Object obj : tab){
			String s = obj.toString(); 
			System.out.print(s + " ");
		}	
	}
}
