package polimeri;

public interface ListaSemplice {

	public void add(Object o); // aggiunge o in coda
	public void reset(); // si posiziona sul primo elem.
	public Object next(); // restituisce elem. puntato
	public boolean hasNext(); // verifica che ci siano altri elementi
	
}
