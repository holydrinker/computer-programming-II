package circlist;

public interface CircList<T> extends Iterable<T> {
	public void addCircList(T item);
	public void delCircList();
	public T value();
	public boolean isEmpty();
	public int numItem();
	public void setDir(Direzione d);
	public void ruota();
}
