package queue;

public interface CircQueue<S> extends Iterable<S> {

	 public void add(S e); /* accoda un elemento */
	 public S value(); /* restituisce il primo elem */
	 public boolean isEmpty(); /* controlla se vuoto */
	 public void rotateF(); /* ruota la coda circolare */
	 public int size(); /* dimensione coda circ. */
	 public boolean equals(CircQueue<S> s);
	 public void stop();
	 public void restart(); 
	
}
