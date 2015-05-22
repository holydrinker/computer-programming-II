package serie;
import java.util.Comparator;


public interface CompList<T> extends Iterable<T> {
	public void add(T dato);
	public T getElement(int i);
	public int numberElements();
	public T getMaximum(Comparator c);
	public boolean growing (Comparator c);
}
