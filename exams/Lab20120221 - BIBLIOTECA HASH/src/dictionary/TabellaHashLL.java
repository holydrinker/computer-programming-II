package dictionary;

import java.util.Iterator;

public class TabellaHashLL<S> implements Dictionary<S> {
	LinkeList[] S; 
	Hash fHash;
	
	public TabellaHashLL(int n, Hash fHash) {
		S = new LinkeList[n];
		this.fHash = fHash;
	}
	
	@Override
	public void insert(S e, Comparable k) {
		int pos = fHash.h(k, S.length);
		if(S[pos] == null)
			S[pos] = new LinkeList<S>();
		S[pos].insert(e, k);
	}

	@Override
	public void delete(Comparable k) {
		int pos = fHash.h(k, S.length);
		if(S[pos] == null)
			return;
		S[pos].delete(k);

	}

	@Override
	public S search(Comparable k) {
		int pos = fHash.h(k, S.length);
		if(S[pos] == null)
			return null;
		return (S) S[pos].search(k);
	}
	
	@Override
	public Iterator<Comparable> iterator() {
		return new TabellaHashLLIterator<S>(this);
	}
}
