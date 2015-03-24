package list;

public interface AddOnlyList<S> extends Iterable<S> {
	public void add(S elem);
	public String toString();
}
