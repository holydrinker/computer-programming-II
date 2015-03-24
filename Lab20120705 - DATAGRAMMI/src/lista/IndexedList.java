package lista;
import java.util.Iterator;


public class IndexedList<T> implements ListaIndicizzata<T> {
	private Object[] list = new Object[1];
	private int n = 0;

	@Override
	public boolean isEmpty(int i) {
		if(!checkPos(i))
			throw new IndexOutOfBoundsException();
		return list[i] == null;
	}

	@Override
	public void addElement(T e, int i) {
		if(!checkPos(i))
			throw new IndexOutOfBoundsException();
		if(!isEmpty(i))
			throw new NotEmptyCellException();
		
		if(i > list.length-1){
			Object[] tmp = new Object[list.length + i*2];
			for(int j = 0; j < list.length; j++)
				tmp[j] = list[j];
			list = tmp;
		}
		list[i] = e;
		n++;
	}

	@Override
	public T getElement(int i) {
		if(!checkPos(i))
			throw new IndexOutOfBoundsException();
		
		if(list[i] == null)
			throw new UndefinedElement();
		
		return (T) list[i];
	}

	@Override
	public int numberElements() {
		return n;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>(){
			int counter = 0;
			int i = 0;
			
			@Override
			public boolean hasNext() {
				return counter < n;
			}

			@Override
			public T next() {
				boolean full = (list[i] != null);
				
				while(!full && i < list.length){
					if(list[i] != null)
						full = true;
					else
						i++;
				}
				
				counter++;
				T elem = (T) list[i];
				i++;
				return elem;
			}
		};
	}
	
	protected boolean checkPos(int i){
		return i >= 0;
	}
}
