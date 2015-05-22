
public interface Dictionary<T> extends Iterable<T> {
	public void insert(T e, Comparable k);
	public void delete(Comparable k);
	public T search(Comparable k);
}
