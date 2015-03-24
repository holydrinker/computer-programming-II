package serie;

public interface Serie<T> extends Iterable<T> {

	public Posizione first();
	public void add(T e);
	public Posizione next(Posizione p);
	public Posizione pred(Posizione p);
	public boolean end(Posizione p);
	public T read(Posizione p); 
	
}
