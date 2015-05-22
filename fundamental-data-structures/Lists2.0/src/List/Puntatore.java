package List;

public class Puntatore<T> implements Position<T> {
	Cella<T> link;

	public Puntatore(Cella<T> link) {
		this.link = link;
	}
}
