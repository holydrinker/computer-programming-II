package List;

public interface List<T> extends Iterable<T> {
	public boolean isEmpty();
	public T readList(Position<T> p);
	public void writeList(T elem, Position<T> p);
	public Position<T> firstList();
	public boolean endList(Position<T> p);
	public Position<T> succList(Position<T> p);
	public Position<T> predList(Position<T> p);
	public void insList(T elem, Position<T> p);
	public void cancList(Position<T> p);
	
}
