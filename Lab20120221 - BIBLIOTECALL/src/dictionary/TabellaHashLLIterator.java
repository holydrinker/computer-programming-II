package dictionary;

import java.util.Iterator;

public class TabellaHashLLIterator<S> implements Iterator<Comparable> {
	private int i = 0;
	private LinkeList<S>[] elementi;
	private Iterator<Comparable> listCollIter = null;
	
	public TabellaHashLLIterator(TabellaHashLL<S> dizionario) {
		this.elementi = dizionario.elementi;
		listCollIter = elementi[0].iterator();
	}
	
	@Override
	public boolean hasNext() {
		checkArray();
		return i < elementi.length;
	}

	@Override
	public Comparable next() {
		return listCollIter.next();
	}
	
	private void checkArray(){
		if(!listCollIter.hasNext() || elementi[i].head == null){
			i = getNextIdx();
			if(i < elementi.length)
				listCollIter = elementi[i].iterator();
		}
	}
	
	private int getNextIdx(){
		i++;
		boolean found = false;
		while(!found && i < elementi.length){
			if(elementi[i].head == null)
				i++;
			else
				found = true;
		}
		return i;
	}

}
