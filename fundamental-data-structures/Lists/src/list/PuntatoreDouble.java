package list;

public class PuntatoreDouble<T> implements Position {

	DoubleCell<T> link;
	
	public PuntatoreDouble(DoubleCell<T> link) {
		
		this.link = link;
		
	}
	
}
