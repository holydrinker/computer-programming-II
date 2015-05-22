package dizionario;

public interface Dictionary<S> extends Iterable<S> {

	static final String MSG_EMPTY = "Struttura Vuota.";
	static final String MSG_DUPLICATE = "Chiave Duplicata ";
	static final String MSG_DOESNT_EXISTS = "La chiave non esiste ";
	
	public void insert(S e, Comparable k);
	public void delete(Comparable k);
	public S search(Comparable k); 
	
}
