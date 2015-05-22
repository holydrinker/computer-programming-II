package dictionary;

public interface Dizionario<T> extends Iterable<T>{

	static final String MSG_EMPTY = "Empty data structure.";
	static final String MSG_KEY_EXISTS = "Duplicate key.";
	static final String MSG_KEY_DOESNT_EXISTS = "Key doesn't exists.";
	static final String MSG_FULL = "Full data structure.";
	
	public void insert(Comparable key, T elem);
	public void delete(Comparable key);
	public T search(Comparable key);
	
}
