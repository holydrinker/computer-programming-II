package polimeri;

public abstract class Polimero {

	protected ListaSemplice sequenza = null;
	
	@Override
	public String toString() {
		return sequenza.toString();
	}
	
}
