package serie;
import java.util.Comparator;
import java.util.Iterator;


public class Serie<T> implements CompList<T> {
	public String name;
	private Object[] S = new Object[0];

	@Override
	public void add(T dato) {
		Object[] tmp = new Object[S.length+1];
		System.arraycopy(S, 0, tmp, 0, S.length);
		tmp[tmp.length-1] = dato;
		S = tmp;
	}

	@Override
	public T getElement(int i) {
		if(S.length == 0)
			throw new EmptySerieException();
		if(i >= S.length)
			throw new IndexOutOfBoundsException();
		return (T) S[i];
	}

	@Override
	public int numberElements() {
		return S.length;
	}

	@Override
	public T getMaximum(Comparator c) {
		if(S.length == 0)
			throw new EmptySerieException();
		
		T max = (T)S[0];
		for(int i = 1; i < S.length; i++)
			if(c.compare(max, S[i]) < 0)
				max = (T)S[i];
		return max;
	}

	@Override
	public boolean growing(Comparator c) {
		int i = 0;
		while(i < S.length-1){
			if(c.compare(S[i], S[i+1]) > 0)
				return false;
			i++;
		}
		return true;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int i = 0;

			@Override
			public boolean hasNext() {
				return i < S.length;
			}

			@Override
			public T next() {
				return (T)S[i++];
			}
		};
	}
}
