package dictionary;

import java.util.Iterator;

public class TabellaHashLLIterator<S> implements Iterator<Comparable> {
	private int i = 0;
	LinkeList<S>[] S;
	Iterator<Comparable> it;
	Comparable key;
	
	public TabellaHashLLIterator(TabellaHashLL<S> tabella) {
		this.S = tabella.S;
		if(S[i] == null)
			posizionaCursore();	
		
		this.it = S[i].iterator();
	}
	
	@Override
	public boolean hasNext() {
		if(!it.hasNext()){
			posizionaCursore();
			if(i > S.length - 1)
				return false;
			it = S[i].iterator();
		}
		
		key = it.next();
		return i < S.length;
	}

	@Override
	public Comparable next() {
		return key;
	}

	private void posizionaCursore(){
		int j;
		for(j = i+1; j < S.length; j++){
			if(S[j] != null)
				if(S[j].iterator().hasNext())
					break;
		}
		i = j;
	}
	
}
