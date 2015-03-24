package simplyClock;

import java.util.Iterator;

public class Orologio<S> implements CircList<S> {
	private Object[] S = new Object[0];
	
	@Override
	public void add(S e) {
		Object[] tmp = new Object[S.length + 1];
		for(int i = 1; i < tmp.length; i++)
			tmp[i] = S[i-1];
		tmp[0] = e;
		S = tmp;
	}

	@Override
	public S value() {
		if(isEmpty())
			throw new EmptyClockException(ExceptionMessages.EMPTY);
		return (S)S[0];
	}

	@Override
	public boolean isEmpty() {
		return S.length == 0;
	}

	@Override
	public void rotateF() {
		if(isEmpty())
			throw new EmptyClockException(ExceptionMessages.EMPTY);
		
		S newLastItem = (S)S[0];
		for(int i = 1; i < S.length; i++)
			S[i-1] = S[i];
		S[S.length-1] = newLastItem;
	}

	@Override
	public int size() {
		return S.length;
	}

	@Override
	public boolean equals(CircList<S> s) {
		if(this.isEmpty() && s.isEmpty())
			return true;
		if(this.size() != s.size())
			return false;
		
		for(int i = 0; i < this.size(); i++){
			if(!(this.value().equals(s.value())))
				return false;
			this.rotateF();
			s.rotateF();
		}
		return true;
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
				return (S)S[i++];
			}
			
		};
	}
}
