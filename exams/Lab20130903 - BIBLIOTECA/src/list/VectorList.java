package list;

import java.util.Iterator;

public class VectorList<S> implements AddOnlyList<S> {

	private Object[] S = new Object[1];
	private int n = 0;
	
	@Override
	public void add(S e) {
		if(n==S.length){
			Object[] tmp = new Object[S.length * 2];
			
			for(int i = 0; i < n; i++)
				tmp[i] = S[i];
			S = tmp;
		}
		
		S[n] = e;
		n++;
	}

	@Override
	public String toString() {
		String s = "";
		
		for(Object o : this)
			s += o.toString() + "-";
		s+=" ";
		return s;
	}
	
	@Override
	public Iterator<S> iterator() {
		return new Iterator<S>(){
			private int i = 0;
			
			@Override
			public boolean hasNext() {
				return i < n;
			}

			@Override
			public S next() {
				return (S)S[i++];
			}
		};
	}

}
