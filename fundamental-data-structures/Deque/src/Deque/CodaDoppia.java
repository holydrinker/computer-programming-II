package Deque;

public interface CodaDoppia<T> extends Iterable<T> {

	static final String MSG_EMPTY = "Empty Deque";
	
	public void accoda(T elem);
	public T leggiCoda();
	public void fuoriCoda();
	public void inpila(T elem);
	public T leggiTesta();
	public void fuoriTesta();
	public boolean dequeVuota();
	
}
