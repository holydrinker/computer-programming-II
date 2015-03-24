package queue;

import java.util.Iterator;

public class CircQueueArray<S> implements CircQueue<S> {
	private Object[] S = null;
	private boolean blocked = true;
	
	public CircQueueArray(int n) {
		S = new Object[n];
	}
	
	@Override
	public void add(S e) {
		boolean found = false;
		int i = 0;
		
		while(!found && i < S.length){
			if(S[i] == null)
				found = true;
			else
				i++;
		}
		
		if(!found)
			throw new FullQueueException(ExceptionMessages.FULL);
		S[i] = e;
	}

	@Override
	public S value() {
		if(isEmpty())
			throw new EmptyQueueException(ExceptionMessages.EMPTY);
		return (S)S[0];
	}

	@Override
	public boolean isEmpty() {
		return S == null;
	}

	@Override
	public void rotateF() {
		/*
		 * La lancetta punta sempre al primo elemento dell'array, quindi nel momento in cui ruoto avanti l'orologio,
		 * il primo va in ultima posizione, e dal secondo all n-1esimo elemento scalando tutti di una posizione verso dietro
		 */
		if(blocked)
			return;
		if(isEmpty())
			throw new EmptyQueueException(ExceptionMessages.EMPTY);
		
		S first = (S)S[0];
		for(int i = 1; i < S.length; i++)
			S[i - 1] = S[i];
		
		S[S.length-1] = first;

	}

	@Override
	public int size() {
		return S.length;
	}

	@Override
	public boolean equals(CircQueue<S> s) {
		if(this.size() != s.size())
			return false;
		if(this.isEmpty() && s.isEmpty())
			return true;
		
		boolean equal = true;
		int i = 0;
		while(equal && i < size()){
			if(this.value() == s.value()){
				this.rotateF();
				s.rotateF();
				i++;
			} else
				equal = !equal;
		}
		
		return equal;
	}

	@Override
	public void stop() {
		this.blocked = true;
	}

	@Override
	public void restart() {
		this.blocked = false;
	}

	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>(){
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < S.length;
			}

			@Override
			public S next() {
				return (S) S[i++];
			}
		};
	}
}
