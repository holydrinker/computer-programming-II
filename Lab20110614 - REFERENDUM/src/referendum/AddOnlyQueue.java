package referendum;

public interface AddOnlyQueue<T> {

	public void add(T elem);
	public T getElement (int i);
	public int numberElements();
	
}
