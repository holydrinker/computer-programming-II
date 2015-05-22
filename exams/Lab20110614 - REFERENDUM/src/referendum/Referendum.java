package referendum;
import java.util.Iterator;

import dizionario.ArrayOrdinato;
import dizionario.Dictionary;


public class Referendum<T> implements Iterable<T>{

	protected Dictionary<Quesito<T>> referendum;
	private int numeroVotanti;
	
	public Referendum(int numeroVotanti) {
		
		referendum = new ArrayOrdinato<Quesito<T>>();
		this.numeroVotanti = numeroVotanti;
		
	}
	
	public void aggiungiQuesito(Quesito<T> q){
		
		referendum.insert(q, q.quesito);
		
	}
	
	public void scrutinaVoto(Quesito<T> q, Voto v){
		
		q.add((T)v);
		
	}
	
	public int numVoti(Quesito<T> q){
		
		return q.numberElements();
		
	}
	
	public T voto(Quesito<T> q, int i){
		
		return (T) q.getElement(i);
		
	}
	
	public boolean quorum(Quesito<T> q){
		
		return (q.numberElements()) > this.numeroVotanti / 2; 
		
	}

	@Override
	public Iterator<T> iterator() {
		
		return (Iterator<T>) referendum.iterator();
		
	}
	
}
