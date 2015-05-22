package list;

public class Puntatore<T> implements Position {

	Cella<T> link;
	
	public Puntatore(Cella<T> link) {
		
		this.link = link;
		
	}
	
}
