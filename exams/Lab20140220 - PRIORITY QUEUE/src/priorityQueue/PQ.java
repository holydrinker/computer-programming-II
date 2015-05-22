package priorityQueue;

public interface PQ<T> extends Iterable<T> {

	public boolean isNew();
	public void insert(T value, int priority);
	public T first();
	public void delFirst();
	public void changePriority(T value, int priority);
	public int getPriority(T value);
	public int size();
	
}
