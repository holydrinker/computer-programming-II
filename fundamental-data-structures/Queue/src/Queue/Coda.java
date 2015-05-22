package Queue;

public interface Coda<T> extends Iterable<T>{

	static final String MSG_EMPTY = "Empty Queue";
	
	public boolean isEmpty();
	public void enqueue(T e);
	public T first();
	public void dequeue();
	
}
